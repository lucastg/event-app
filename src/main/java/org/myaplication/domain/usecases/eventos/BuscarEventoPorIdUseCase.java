package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.mappers.EventoMapper;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.BuscarEventoPorIdUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

import java.util.NoSuchElementException;

@ApplicationScoped
public class BuscarEventoPorIdUseCase implements BuscarEventoPorIdUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    EventoMapper eventoMapper;

    @Override
    public Evento buscarEventoPorId(Integer id) {
        var result = eventoPersistancePort.buscarEventoPorId(id);

        if(result.isEmpty()){
            throw new NoSuchElementException("Evento não encontrado com ID: " + id );
        }

        return eventoMapper.toDomain(result);
    }
}
