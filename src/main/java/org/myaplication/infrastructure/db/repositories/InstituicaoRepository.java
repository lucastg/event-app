package org.myaplication.infrastructure.db.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.myaplication.infrastructure.db.entity.InstituicaoEntity;

@ApplicationScoped
public class InstituicaoRepository implements PanacheRepositoryBase<InstituicaoEntity, Integer> {

}
