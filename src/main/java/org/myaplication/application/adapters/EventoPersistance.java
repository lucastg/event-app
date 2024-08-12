package org.myaplication.application.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import org.myaplication.application.presenters.mappers.EventoMapper;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.out.EventoPersistancePort;
import org.myaplication.infrastructure.db.entity.EventoEntity;
import org.myaplication.infrastructure.db.repositories.EventoRepository;
import org.myaplication.infrastructure.db.repositories.InstituicaoRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class EventoPersistance implements EventoPersistancePort {

    @Inject
    EventoRepository eventoRepository;

    @Inject
    InstituicaoRepository instituicaoRepository;

    @Inject
    EventoMapper eventoMapper;


    @Override
    public List<EventoEntity> listarEventos() {
        return eventoRepository.findAll().list();
    }

    @Override
    public Optional<EventoEntity> buscarEventoPorId(Integer id) {
        return eventoRepository.findByIdOptional(id);
    }

    @Override
    public Optional<EventoEntity> buscarEventoPorNome(String nome) {
        return eventoRepository.findByNome(nome);
    }

    @Override
    public void criarEvento(Evento evento) {
        eventoRepository.persist(eventoMapper.toEntity(evento));
    }

    @Override
    public void alterarEvento(Evento evento) {
        var eventoEntity = eventoRepository.findByIdOptional(evento.getId()).get();
        var instituicaoEntity = instituicaoRepository.findByIdOptional(evento.getInstituicao().getId()).get();
        eventoEntity.setNome(evento.getNome());
        eventoEntity.setDataInicial(evento.getDataInicial());
        eventoEntity.setDataFinal(evento.getDataFinal());
        eventoEntity.setAtivo(evento.getAtivo());
        eventoEntity.setInstituicao(instituicaoEntity);
        eventoRepository.persist(eventoEntity);
    }

    @Override
    public void deletarEvento(Integer id) {
        eventoRepository.deleteAll();
    }

    @Override
    public void atualizarStatusEvento(Evento evento) {
        var eventoEntity = eventoRepository.findById(evento.getId());
        var instituicaoEntity = instituicaoRepository.findById(evento.getInstituicao().getId());
        eventoEntity.setNome(evento.getNome());
        eventoEntity.setDataInicial(evento.getDataInicial());
        eventoEntity.setDataFinal(evento.getDataFinal());
        eventoEntity.setAtivo(evento.getAtivo());
        eventoEntity.setInstituicao(instituicaoEntity);
        eventoRepository.persist(eventoEntity);
    }
}
