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
    private Boolean ativo;

    public Evento(
            @NotBlank String nome,
            @NotBlank Date dataInicial,
            @NotBlank Date dataFinal,
            @NotBlank Boolean ativo) {
    }
}
