package org.myaplication.application.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import org.myaplication.domain.ports.out.InstituicaoPersistancePort;
import org.myaplication.infrastructure.db.entity.InstituicaoEntity;
import org.myaplication.infrastructure.db.repositories.InstituicaoRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class InstituicaoPersistance implements InstituicaoPersistancePort {

    @Inject
    InstituicaoRepository instituicaoRepository;

    @Override
    public List<InstituicaoEntity> listarInstituicoes() {
        return instituicaoRepository.findAll().list();
    }

    @Override
    public Optional<InstituicaoEntity> buscarInstituicaoPorId(Integer id) {
        return instituicaoRepository.findByIdOptional(id);
    }
}
