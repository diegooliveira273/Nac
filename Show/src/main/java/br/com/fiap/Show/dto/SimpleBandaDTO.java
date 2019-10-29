package br.com.fiap.Show.dto;

import br.com.fiap.Show.entity.Banda;
import br.com.fiap.Show.entity.Estilo;

public class SimpleBandaDTO {

    private Integer id;
    private String name;
    private Estilo estilo;

    public SimpleBandaDTO() { }

    public SimpleBandaDTO(Banda banda) {
        this.id = banda.getId();
        this.name = banda.getName();
        this.estilo = banda.getEstilo();
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
}
