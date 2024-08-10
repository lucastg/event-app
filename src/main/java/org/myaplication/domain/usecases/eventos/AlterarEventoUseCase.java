package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.AlterarEventoUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

@ApplicationScoped
public class AlterarEventoUseCase implements AlterarEventoUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    BuscarEventoPorNomeUseCase buscarEventoPorNome;

    @Override
    public Evento alterarEvento(EventoDto eventoDto) {
        buscarEventoPorNome.buscarEventoPorNome(eventoDto.getNome());

        var evento = new Evento(eventoDto.getNome(), eventoDto.getDataInicial(), eventoDto.getDataFinal(), eventoDto.getAtivo());
        return eventoPersistancePort.alterarEvento(evento);
    }
}
