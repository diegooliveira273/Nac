package br.com.fiap.Show.service.impl;

import br.com.fiap.Show.dto.CidadeDTO;
import br.com.fiap.Show.dto.CreateCidadeDTO;
import br.com.fiap.Show.entity.Banda;
import br.com.fiap.Show.entity.Cidade;
import br.com.fiap.Show.repository.CidadeRepository;
import br.com.fiap.Show.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public CidadeDTO addCidade(Integer bandaId, CreateCidadeDTO createCidadeDTO) {
        Cidade cidade = new Cidade();
        cidade.setName(createCidadeDTO.getName());
        cidade.setImageUrl(createCidadeDTO.getImageUrl());

        Banda banda = new Banda();
        banda.setId(bandaId);
        cidade.setBanda(banda);

        Cidade savedCidade = cidadeRepository.save(cidade);

        return new CidadeDTO(savedCidade);
    }

    @Override
    public void deleteCidade(Integer bandaId, Integer cidadeId) {
        Cidade cidade = cidadeRepository.findById(cidadeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(!cidade.getBanda().getId().equals(bandaId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Banda Incorreta");
        }

        cidadeRepository.delete(cidade);

    }

}
