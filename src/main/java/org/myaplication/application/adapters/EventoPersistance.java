package org.myaplication.application.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import org.myaplication.application.presenters.mappers.EventoMapper;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.ports.out.EventoPersistancePort;
import org.myaplication.infrastructure.db.repositories.EventoRepository;

import java.util.List;

@ApplicationScoped
@AllArgsConstructor
public class EventoPersistance implements EventoPersistancePort {

    @Inject
    EventoRepository eventoRepository;

    @Inject
    EventoMapper eventoMapper;


    @Override
    public List<Evento> listarEventos() {
        var eventos = eventoRepository.findAll().list();
        if (eventos == null) {
            throw new RuntimeException("Sem Registros");
        }
        return eventos.stream().map(eventoEntity -> eventoMapper.toDomain(eventoEntity)).toList();
    }

    @Override
    public Evento buscarEventoPorId(Integer id) {
        var eventoEntity = eventoRepository.findById(id);
        if (eventoEntity == null) {
            throw new RuntimeException("Registro nao encontrado com id:" + id);
        }
        return eventoMapper.toDomain(eventoEntity);
    }

    @Override
    public Evento buscarEventoPorNome(String nome) {
        return eventoMapper.toDomain(eventoRepository.findNomeByNativeQuery(nome));
    }

    @Override
    public void criarEvento(Evento evento) {
        eventoRepository.persist(eventoMapper.toEntity(evento));
    }

    @Override
    public Evento alterarEvento(Evento evento) {
        eventoRepository.persist(eventoMapper.toEntity(evento));
        return evento;
    }
}
