package br.com.fiap.Show.controller;

import br.com.fiap.Show.dto.CidadeDTO;
import br.com.fiap.Show.dto.CreateCidadeDTO;
import br.com.fiap.Show.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shows/{bandaId}/cidade")
public class CidadeController {

   @Autowired
   private CidadeService cidadeService;

    @PostMapping
    public CidadeDTO addCidade(@PathVariable Integer bandaId,
                               @RequestBody CreateCidadeDTO createCidadeDTO) {
        return cidadeService.addCidade(bandaId, createCidadeDTO);
    }

    @DeleteMapping
    public void deleteCidade(@PathVariable Integer bandaId,
                             @PathVariable Integer cidadeId) {
        cidadeService.deleteCidade(bandaId, cidadeId);
    }
}
