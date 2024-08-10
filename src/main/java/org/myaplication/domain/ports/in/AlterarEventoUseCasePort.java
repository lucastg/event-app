package org.myaplication.domain.ports.in;

import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.entities.Evento;

public interface AlterarEventoUseCasePort {

    Evento alterarEvento(EventoDto eventoDto);
}
