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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_instituicao")
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
