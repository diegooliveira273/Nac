package br.com.fiap.Show.dto;


import br.com.fiap.Show.entity.Banda;
import br.com.fiap.Show.entity.Estilo;

import java.util.List;
import java.util.stream.Collectors;

public class BandaDTO {

    private Integer id;
    private String name;
    private Estilo estilo;
    private String imageUrl;
    private List<CidadeDTO> cidadeList;

    public BandaDTO() { }

    public BandaDTO(Banda banda) {
        this.id = banda.getId();
        this.name = banda.getName();
        this.estilo = banda.getEstilo();
        this.imageUrl = banda.getImageUrl();
        this.cidadeList = banda.getCidadeList()
                .stream()
                .map(CidadeDTO::new)
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<CidadeDTO> getCidadeList() {
        return cidadeList;
    }

    public void setCidadeList(List<CidadeDTO> cidadeList) {
        this.cidadeList = cidadeList;
    }
}