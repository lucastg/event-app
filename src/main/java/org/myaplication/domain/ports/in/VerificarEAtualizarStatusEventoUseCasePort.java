package org.myaplication.domain.ports.in;

import org.myaplication.application.presenters.requests.EventoDto;

public interface VerificarEAtualizarStatusEventoUseCasePort {

    void atualizarStatusEvento();

    void verificarStatusEvento(EventoDto eventoDto);
}
