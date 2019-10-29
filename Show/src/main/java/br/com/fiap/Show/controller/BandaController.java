package br.com.fiap.Shows.controller;

import br.com.fiap.Show.dto.BandaDTO;
import br.com.fiap.Show.dto.CreateBandaDTO;
import br.com.fiap.Show.dto.SimpleBandaDTO;
import br.com.fiap.Show.service.BandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bandas")
public class BandaController {

    @Autowired
    private BandaService bandaService;

    @GetMapping
    public List<SimpleBandaDTO> getBandaList(@RequestParam(required = false) String name) {
        return bandaService.getBandaList(name);
    }

    @GetMapping("{bandaId}")
    public BandaDTO getBandaById(@PathVariable Integer bandaId) {
        return bandaService.getBandaById(bandaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BandaDTO insertBanda(@RequestBody @Valid CreateBandaDTO createBandaDTO) {
        return bandaService.insertBanda(createBandaDTO);
    }

    @PutMapping("{bandaId}")
    public BandaDTO updateBanda(@PathVariable Integer bandaId,
                                @RequestBody CreateBandaDTO createBandaDTO) {
        return bandaService.updateBanda(bandaId, createBandaDTO);
    }

    @DeleteMapping("{bandaId}")
    public void deleteBanda(@PathVariable Integer bandaId) {
        bandaService.deleteBanda(bandaId);
    }

}