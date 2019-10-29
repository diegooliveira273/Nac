package br.com.fiap.Show.service.impl;

import br.com.fiap.Show.dto.BandaDTO;
import br.com.fiap.Show.dto.CreateBandaDTO;
import br.com.fiap.Show.dto.SimpleBandaDTO;
import br.com.fiap.Show.entity.Banda;
import br.com.fiap.Show.repository.BandaRepository;
import br.com.fiap.Show.service.BandaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandaServiceImpl implements BandaService {

    @Autowired
    private BandaRepository repository;

    @Override
    public List<SimpleBandaDTO> getBandaList(String name) {
        List<Banda> bandaList = repository.findAll();
        return bandaList.stream()
                .filter(banda -> name == null || banda.getName().startsWith(name))
                .map(SimpleBandaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public BandaDTO getBandaById(Integer bandaId) {
        Banda banda = findBandaById(bandaId);
        banda.setName(banda.getName());
        return new BandaDTO(banda);
    }

    @Override
    public BandaDTO insertBanda(CreateBandaDTO createBandaDTO) {
        Banda banda = new Banda();
        banda.setName(createBandaDTO.getName());
        banda.setEstilo(createBandaDTO.getEstilo());
        banda.setImageUrl(createBandaDTO.getImageUrl());
        Banda savedBanda = repository.save(banda);
        return new BandaDTO(savedBanda);
    }

    @Override
    public BandaDTO updateBanda(Integer bandaId, CreateBandaDTO createBandaDTO) {
        Banda banda = findBandaById(bandaId);
        BeanUtils.copyProperties(createBandaDTO, banda);
        Banda updateBanda = repository.save(banda);
        return new BandaDTO(updateBanda);
    }

    @Override
    public void deleteBanda(Integer bandaId) {
        repository.deleteById(bandaId);
    }

    private Banda findBandaById(Integer bandaId) {
        return repository.findById(bandaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
