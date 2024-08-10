package org.myaplication.application.presenters.requests;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EventoDto {

    @Nonnull
    @NotBlank
    private String nome;

    @Nonnull
    @NotBlank
    private Date dataInicial;

    @Nonnull
    @NotBlank
    private Date dataFinal;

    @Nonnull
    @NotBlank
    private Boolean ativo;
}
