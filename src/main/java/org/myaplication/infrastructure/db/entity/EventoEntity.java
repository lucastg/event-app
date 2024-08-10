package org.myaplication.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_eventos")
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date dataInicial;

    @Column(nullable = false)
    private Date dataFinal;

    @Column(nullable = false)
    private Boolean ativo;

    @OneToOne
    @JoinColumn(name = "id_instituicao")
    private InstituicaoEntity instituicao;

    public EventoEntity(Integer id, String nome, Date dataInicial, Date dataFinal, Boolean ativo) {
    }
}
