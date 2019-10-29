package br.com.fiap.Show.dto;

import br.com.fiap.Show.entity.Estilo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateBandaDTO {

    private String name;
    private Estilo estilo;

    @NotBlank
    @NotNull(message = "Imagem Obrigatoria")
    private String imageUrl;

    public CreateBandaDTO() { }

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
}
