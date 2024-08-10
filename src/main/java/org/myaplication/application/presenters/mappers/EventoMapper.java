package org.myaplication.application.presenters.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.myaplication.domain.entities.Evento;
import org.myaplication.infrastructure.db.entity.EventoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EventoMapper {

    public EventoEntity toEntity(Evento evento) {
        return new EventoEntity(
                evento.getId(),
                evento.getNome(),
                evento.getDataInicial(),
                evento.getDataFinal(),
                evento.getAtivo()
        );
    }

    public Evento toDomain(EventoEntity eventoEntity) {
        return new Evento(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDataInicial(),
                eventoEntity.getDataFinal(),
                eventoEntity.getAtivo()
        );
    }

    public Evento toDomain(Optional<EventoEntity> eventoEntity) {
        return new Evento(
                eventoEntity.get().getId(),
                eventoEntity.get().getNome(),
                eventoEntity.get().getDataInicial(),
                eventoEntity.get().getDataFinal(),
                eventoEntity.get().getAtivo()
        );
    }

    public List<Evento> toDomain(List<EventoEntity> eventoEntityList){
        var eventos = new ArrayList<Evento>();
        eventoEntityList.forEach(eventoEntity -> eventos.add(toDomain(eventoEntity)));
        return eventos;
    }
}
