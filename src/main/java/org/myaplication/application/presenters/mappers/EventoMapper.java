package org.myaplication.application.presenters.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.myaplication.domain.entities.Evento;
import org.myaplication.domain.entities.Instituicao;
import org.myaplication.infrastructure.db.entity.EventoEntity;
import org.myaplication.infrastructure.db.entity.InstituicaoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EventoMapper {

    public EventoEntity toEntity(Evento evento) {
        var instituicaoEntity = new InstituicaoEntity();
        instituicaoEntity.setId(evento.getInstituicao().getId());
        instituicaoEntity.setNome(evento.getInstituicao().getNome());
        instituicaoEntity.setTipo(evento.getInstituicao().getTipo());

        return new EventoEntity(
                evento.getId(),
                evento.getNome(),
                evento.getDataInicial(),
                evento.getDataFinal(),
                evento.getAtivo(),
                instituicaoEntity
        );
    }

    public Evento toDomain(EventoEntity eventoEntity) {
        var instituicao = new Instituicao();
        instituicao.setId(eventoEntity.getInstituicao().getId());
        instituicao.setNome(eventoEntity.getInstituicao().getNome());
        instituicao.setTipo(eventoEntity.getInstituicao().getTipo());

        return new Evento(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDataInicial(),
                eventoEntity.getDataFinal(),
                eventoEntity.getAtivo(),
                instituicao
        );
    }

    public Evento toDomain(Optional<EventoEntity> eventoEntity) {
        var instituicao = new Instituicao();
        instituicao.setId(eventoEntity.get().getInstituicao().getId());
        instituicao.setNome(eventoEntity.get().getInstituicao().getNome());
        instituicao.setTipo(eventoEntity.get().getInstituicao().getTipo());

        return new Evento(
                eventoEntity.get().getId(),
                eventoEntity.get().getNome(),
                eventoEntity.get().getDataInicial(),
                eventoEntity.get().getDataFinal(),
                eventoEntity.get().getAtivo(),
                instituicao
        );
    }

    public List<Evento> toDomain(List<EventoEntity> eventoEntityList){
        var eventos = new ArrayList<Evento>();
        eventoEntityList.forEach(eventoEntity -> eventos.add(toDomain(eventoEntity)));
        return eventos;
    }
}
