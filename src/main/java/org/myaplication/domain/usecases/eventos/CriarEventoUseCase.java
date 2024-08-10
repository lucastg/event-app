package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.CriarEventoUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

@ApplicationScoped
public class CriarEventoUseCase implements CriarEventoUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    EventoPersistancePort eventoPersistance;

    @Override
    public void criarEvento(EventoDto eventoDto) {
        if(eventoDto.getDataInicial().after(eventoDto.getDataFinal())){
            throw new IllegalArgumentException("Data inicial maior que data final");
        }

        var evento = new Evento(
                eventoDto.getNome(),
                eventoDto.getDataInicial(),
                eventoDto.getDataFinal(),
                eventoDto.getAtivo()
        );

        eventoPersistancePort.criarEvento(evento);
    }
}
