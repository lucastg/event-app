package org.myaplication.application.presenters.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.myaplication.domain.entities.Instituicao;
import org.myaplication.infrastructure.db.entity.InstituicaoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class InstituicaoMapper {

    public InstituicaoEntity toEntity(Instituicao instituicao) {
        return new InstituicaoEntity(
                instituicao.getId(),
                instituicao.getNome(),
                instituicao.getTipo()
        );
    }

    public Instituicao toDomain(InstituicaoEntity instituicaoEntity) {
        return new Instituicao(
                instituicaoEntity.getId(),
                instituicaoEntity.getNome(),
                instituicaoEntity.getTipo()
        );
    }

    public List<Instituicao> toDomain(List<InstituicaoEntity> instituicaoEntityList) {
        var instituicaoList = new ArrayList<Instituicao>();
        instituicaoEntityList.forEach(instituicaoEntity -> instituicaoList.add(toDomain(instituicaoEntity)));
        return instituicaoList;
    }

    public Instituicao toDomain(Optional<InstituicaoEntity> instituicaoEntity) {
        return new Instituicao(
                instituicaoEntity.get().getId(),
                instituicaoEntity.get().getNome(),
                instituicaoEntity.get().getTipo()
        );
    }
}
