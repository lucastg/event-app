package org.myaplication.domain.ports.out;

import org.myaplication.domain.entities.Evento;
import org.myaplication.infrastructure.db.entity.EventoEntity;

import java.util.List;
import java.util.Optional;

public interface EventoPersistancePort {

    List<EventoEntity> listarEventos();

    Optional<EventoEntity> buscarEventoPorId(Integer id);

    Optional<EventoEntity> buscarEventoPorNome(String nome);

    void criarEvento(Evento evento);

    void alterarEvento(Evento evento);

    void deletarEvento(Integer id);

    void atualizarStatusEvento(Evento evento);
}
