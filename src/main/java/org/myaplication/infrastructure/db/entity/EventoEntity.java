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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_inicial", nullable = false)
    private Date dataInicial;

    @Column(name = "data_final", nullable = false)
    private Date dataFinal;

    @Column(nullable = false)
    private Boolean ativo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_instituicao", nullable = false)
    private InstituicaoEntity instituicao;

    public EventoEntity(Integer id, String nome, Date dataInicial, Date dataFinal, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.ativo = ativo;
    }

    public EventoEntity(String nome, Date dataInicial, Date dataFinal, Boolean ativo) {
        this.nome = nome;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.ativo = ativo;
    }
}
