package org.myaplication.domain.ports.in;

import org.myaplication.domain.entities.Instituicao;

import java.util.List;

public interface ListarInstituicoesUseCasePort {

    List<Instituicao> listarInstituicoes();
}
