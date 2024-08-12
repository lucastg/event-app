package org.myaplication.domain.usecases.instituicao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.mappers.InstituicaoMapper;
import org.myaplication.domain.entities.Instituicao;
import org.myaplication.domain.ports.in.BuscarInstituicaoPorIdUseCasePort;
import org.myaplication.domain.ports.out.InstituicaoPersistancePort;

import java.util.NoSuchElementException;

@ApplicationScoped
public class BuscarInstituicaoPorIdUseCase implements BuscarInstituicaoPorIdUseCasePort {

    @Inject
    InstituicaoPersistancePort instituicaoPersistancePort;

    @Inject
    InstituicaoMapper instituicaoMapper;

    @Override
    public Instituicao buscarInstituicaoPorId(Integer id) {
        var result = instituicaoPersistancePort.buscarInstituicaoPorId(id);
        if (result.isEmpty()) {
            throw new NoSuchElementException("Sem Registros");
        }
        return instituicaoMapper.toDomain(result);
    }
}
