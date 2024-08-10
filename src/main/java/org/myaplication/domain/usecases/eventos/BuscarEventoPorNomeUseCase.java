package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.BuscarEventoPorNomeUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

@ApplicationScoped
public class BuscarEventoPorNomeUseCase implements BuscarEventoPorNomeUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Override
    public Evento buscarEventoPorNome(String nome) {
        var result = eventoPersistancePort.buscarEventoPorNome(nome);

        if (result == null) {
            throw new RuntimeException("Registro nao encontrado com nome: " + nome);
        }
        return result;
    }
}
