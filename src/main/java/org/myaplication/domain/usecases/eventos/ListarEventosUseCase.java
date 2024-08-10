package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.ListarEventosUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

import java.util.List;

@ApplicationScoped
public class ListarEventosUseCase implements ListarEventosUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Override
    public List<Evento> listarEventos() {
        var result = eventoPersistancePort.listarEventos();

        if (result == null) {
            throw new RuntimeException("Sem Registros");
        }
        return result;
    }
}
