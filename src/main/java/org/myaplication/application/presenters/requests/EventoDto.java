package org.myaplication.application.presenters.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @NotBlank(message = "A data inicial não pode estar em branco.")
    private Date dataInicial;

    @NotBlank(message = "A data final não pode estar em branco.")
    private Date dataFinal;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    private Boolean ativo;

    @NotBlank(message = "A instituição não pode estar em branco.")
    private Integer instituicao;
}
