package org.myaplication.domain.entities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Instituicao {

    private Integer id;
    private String nome;
    private String tipo;
}
