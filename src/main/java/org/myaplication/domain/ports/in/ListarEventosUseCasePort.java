package org.myaplication.domain.ports.in;

import org.myaplication.domain.entities.Evento;

import java.util.List;

public interface ListarEventosUseCasePort {

    List<Evento> listarEventos();
}
