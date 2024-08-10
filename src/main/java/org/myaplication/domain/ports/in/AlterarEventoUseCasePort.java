package org.myaplication.domain.ports.in;

import org.myaplication.application.presenters.requests.EventoDto;

public interface AlterarEventoUseCasePort {

    void alterarEvento(Integer id, EventoDto eventoDto);
}
