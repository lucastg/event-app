package org.myaplication.domain.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    private Integer id;
    private String nome;
    private Date dataInicial;
    private Date dataFinal;
    private Boolean ativo = false;
    private Instituicao instituicao;

    public Evento(@NotBlank String nome, @NotBlank Date dataInicial, @NotBlank Date dataFinal, @NotBlank Boolean ativo, Instituicao instituicao) {
        this.nome = nome;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.ativo = ativo;
        this.instituicao = instituicao;
    }

}
