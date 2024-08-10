package org.myaplication.domain.ports.in;

import org.myaplication.domain.entities.Evento;

public interface BuscarEventoPorIdUseCasePort {

    Evento buscarEventoPorId(Integer id);
}
