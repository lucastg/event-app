package org.myaplication.application.presenters.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.myaplication.domain.entities.Evento;
import org.myaplication.infrastructure.db.entity.EventoEntity;

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
}
