package org.myaplication.infrastructure.db.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.myaplication.infrastructure.db.entity.EventoEntity;

import java.util.List;

@ApplicationScoped
public class EventoRepository implements PanacheRepositoryBase<EventoEntity, Integer> {

    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public EventoEntity findNomeByNativeQuery(String nome) {
        String sql = "SELECT nome FROM tb_eventos WHERE nome = :nome";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nome", nome);

        return (EventoEntity) query.getResultList();
    }
}
