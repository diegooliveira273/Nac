package br.com.fiap.Show.service;

import br.com.fiap.Show.dto.CidadeDTO;
import br.com.fiap.Show.dto.CreateCidadeDTO;

public interface CidadeService {

    CidadeDTO addCidade(Integer bandaId, CreateCidadeDTO createCidadeDTO);
    void deleteCidade(Integer bandaId, Integer cidadeId);
}
