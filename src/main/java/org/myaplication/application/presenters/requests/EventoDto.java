package org.myaplication.application.presenters.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    private Boolean ativo;
}
