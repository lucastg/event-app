package org.myaplication.domain.usecases.instituicao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.myaplication.application.presenters.mappers.InstituicaoMapper;
import org.myaplication.domain.entities.Instituicao;
import org.myaplication.domain.ports.in.ListarInstituicoesUseCasePort;
import org.myaplication.domain.ports.out.InstituicaoPersistancePort;

import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class ListarInstituicoesUseCase implements ListarInstituicoesUseCasePort {

    @Inject
    InstituicaoPersistancePort instituicaoPersistancePort;

    @Inject
    InstituicaoMapper instituicaoMapper;

    @Override
    public List<Instituicao> listarInstituicoes() {
        var result = instituicaoPersistancePort.listarInstituicoes();
        if (result == null) {
            throw new NoSuchElementException("Sem Registros");
        }
        return instituicaoMapper.toDomain(result);
    }
}
