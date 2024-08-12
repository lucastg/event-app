package org.myaplication.domain.usecases.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.mappers.EventoMapper;
import org.myaplication.application.presenters.mappers.InstituicaoMapper;
import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.ports.in.AlterarEventoUseCasePort;
import org.myaplication.domain.ports.in.VerificarEAtualizarStatusEventoUseCasePort;
import org.myaplication.domain.ports.out.EventoPersistancePort;
import org.myaplication.domain.ports.out.InstituicaoPersistancePort;

import java.util.NoSuchElementException;

@ApplicationScoped
public class AlterarEventoUseCase implements AlterarEventoUseCasePort {

    @Inject
    EventoPersistancePort eventoPersistancePort;

    @Inject
    EventoPersistancePort eventoPersistance;

    @Inject
    EventoMapper eventoMapper;

    @Inject
    VerificarEAtualizarStatusEventoUseCasePort verificarEAtualizarStatusEventoUseCasePort;

    @Inject
    InstituicaoMapper instituicaoMapper;

    @Inject
    InstituicaoPersistancePort instituicaoPersistancePort;


    @Override
    public void alterarEvento(Integer id, EventoDto eventoDto) {
        var result = eventoMapper.toDomain(eventoPersistance.buscarEventoPorId(id));
        var resultInstituicao = instituicaoMapper.toDomain(instituicaoPersistancePort.buscarInstituicaoPorId(eventoDto.getInstituicao()));

        if (result == null) {
            throw new NoSuchElementException("Evento não encontrado com ID: " + id);
        }

        verificarEAtualizarStatusEventoUseCasePort.verificarStatusEvento(eventoDto);

        result.setNome(eventoDto.getNome().toUpperCase());
        result.setDataInicial(eventoDto.getDataInicial());
        result.setDataFinal(eventoDto.getDataFinal());
        result.setAtivo(eventoDto.getAtivo());
        result.setInstituicao(resultInstituicao);
        eventoPersistancePort.alterarEvento(result);
    }
}
