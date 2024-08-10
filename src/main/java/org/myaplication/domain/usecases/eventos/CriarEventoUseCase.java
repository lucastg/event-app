package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.BuscarEventoPorNomeUseCasePort;
import org.myaplication.domain.ports.in.CriarEventoUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

@ApplicationScoped
public class CriarEventoUseCase implements CriarEventoUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    BuscarEventoPorNomeUseCasePort buscarEventoPorNomeUseCasePort;

    @Inject
    BuscarEventoPorNomeUseCase buscarEventoPorNome;

    @Override
    public void criarEvento(EventoDto eventoDto) {
        var result = buscarEventoPorNomeUseCasePort.buscarEventoPorNome(eventoDto.getNome());

        if (result == null) {
            throw new IllegalArgumentException("Evento ja cadastrado!");
        }

        if(eventoDto.getDataInicial().after(eventoDto.getDataFinal())){
            throw new IllegalArgumentException("Data inicial maior que data final");
        }
        var evento = new Evento(eventoDto.getNome(), eventoDto.getDataInicial(), eventoDto.getDataFinal(), eventoDto.getAtivo());
        eventoPersistancePort.criarEvento(evento);
    }
}
