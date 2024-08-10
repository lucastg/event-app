package org.myaplication.domain.ports.in;

import org.myaplication.domain.entities.Evento;

public interface BuscarEventoPorNomeUseCasePort {

    Evento buscarEventoPorNome(String nome);
}
