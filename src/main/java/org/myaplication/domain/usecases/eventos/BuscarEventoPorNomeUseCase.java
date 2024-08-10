package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.mappers.EventoMapper;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.BuscarEventoPorNomeUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

@ApplicationScoped
public class BuscarEventoPorNomeUseCase implements BuscarEventoPorNomeUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    EventoMapper eventoMapper;

    @Override
    public Evento buscarEventoPorNome(String nome) {
        var result = eventoPersistancePort.buscarEventoPorNome(nome);

        if (result.isEmpty()) {
            throw new RuntimeException("Registro nao encontrado com nome: " + nome);
        }
        return eventoMapper.toDomain(result);
    }
}
