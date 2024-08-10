package org.myaplication.domain.ports.out;

import org.myaplication.domain.entities.Evento;

import java.util.List;

public interface EventoPersistancePort {

    List<Evento> listarEventos();

    Evento buscarEventoPorId(Integer id);

    Evento buscarEventoPorNome(String nome);

    void criarEvento(Evento evento);

    Evento alterarEvento(Evento evento);
}
