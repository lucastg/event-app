package org.myaplication.domain.ports.out;

import org.myaplication.infrastructure.db.entity.InstituicaoEntity;

import java.util.List;
import java.util.Optional;

public interface InstituicaoPersistancePort {

    List<InstituicaoEntity> listarInstituicoes();

    Optional<InstituicaoEntity> buscarInstituicaoPorId(Integer id);

}
