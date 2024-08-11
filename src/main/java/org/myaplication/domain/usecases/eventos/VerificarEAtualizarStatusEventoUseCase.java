package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.myaplication.application.presenters.mappers.EventoMapper;
import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.in.VerificarEAtualizarStatusEventoUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;

import java.util.Date;

@Slf4j
@ApplicationScoped
public class VerificarEAtualizarStatusEventoUseCase implements VerificarEAtualizarStatusEventoUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    EventoMapper eventoMapper;

    @Override
    @Transactional
    public void atualizarStatusEvento() {
        Date agora = new Date();
        var eventos = eventoMapper.toDomain(eventoPersistancePort.listarEventos());

        for (Evento evento : eventos) {
            if (agora.after(evento.getDataInicial()) && agora.before(evento.getDataFinal())) {
                evento.setAtivo(true);
            } else if (agora.after(evento.getDataFinal())) {
                evento.setAtivo(false);
            }
            eventoPersistancePort.atualizarStatusEvento(evento);
        }
    }

    @Override
    public void verificarStatusEvento(EventoDto eventoDto) {
        Date agora = new Date();

        if(eventoDto.getDataInicial().after(eventoDto.getDataFinal())){
            throw new IllegalArgumentException("Data inicial maior que data final");
        }

        if (agora.after(eventoDto.getDataInicial()) && agora.before(eventoDto.getDataFinal())) {
            eventoDto.setAtivo(true);

        } else if (agora.after(eventoDto.getDataFinal()) || agora.before(eventoDto.getDataInicial())) {
            eventoDto.setAtivo(false);
        }
    }
}
