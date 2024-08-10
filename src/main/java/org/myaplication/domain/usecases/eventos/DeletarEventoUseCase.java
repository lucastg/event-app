package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.domain.ports.in.BuscarEventoPorIdUseCasePort;
import org.myaplication.domain.ports.in.DeletarEventoUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

import java.util.NoSuchElementException;

@ApplicationScoped
public class DeletarEventoUseCase implements DeletarEventoUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    EventoPersistancePort eventoPersistance;

    @Inject
    BuscarEventoPorIdUseCasePort buscarEventoPorId;

    @Override
    public void deletarEvento(Integer id) {
        var te = eventoPersistancePort.buscarEventoPorId(id);
        if (te.isEmpty()) {
            throw new NoSuchElementException("Evento não encontrado com ID: " + id );
        }
        eventoPersistance.deletarEvento(id);
    }
}
