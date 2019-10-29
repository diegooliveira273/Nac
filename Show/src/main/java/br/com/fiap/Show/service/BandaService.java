package br.com.fiap.Show.service;

import br.com.fiap.Show.dto.BandaDTO;
import br.com.fiap.Show.dto.CreateBandaDTO;
import br.com.fiap.Show.dto.SimpleBandaDTO;

import java.util.List;

public interface BandaService {

    List<SimpleBandaDTO> getBandaList(String nome);
    BandaDTO getBandaById(Integer bandaId);
    BandaDTO insertBanda(CreateBandaDTO createBandaDTO);
    BandaDTO updateBanda(Integer bandaId, CreateBandaDTO createBandaDTO);
    void deleteBanda(Integer bandaId);
}
