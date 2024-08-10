package org.myaplication.domain.ports.in;

import org.myaplication.application.presenters.requests.EventoDto;


public interface CriarEventoUseCasePort {

    void criarEvento (EventoDto eventoDto);
}
