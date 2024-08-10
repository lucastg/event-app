package org.myaplication.infrastructure.db.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.myaplication.infrastructure.db.entity.EventoEntity;

import java.util.Optional;

@ApplicationScoped
public class EventoRepository implements PanacheRepositoryBase<EventoEntity, Integer> {

    @PersistenceContext
    EntityManager em;

    public Optional<EventoEntity> findByNome(String nome) {
        return find("nome", nome).firstResultOptional();
    }
}
