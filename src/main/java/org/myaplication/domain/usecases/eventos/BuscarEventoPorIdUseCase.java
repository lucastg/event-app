package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.BuscarEventoPorIdUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

@ApplicationScoped
public class BuscarEventoPorIdUseCase implements BuscarEventoPorIdUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Override
    public Evento buscarEventoPorId(Integer id) {
       var result = eventoPersistancePort.buscarEventoPorId(id);
       if (result == null) {
           throw new RuntimeException("Registro nao encontrado com id: " + id);
       }
       return result;
    }
}
