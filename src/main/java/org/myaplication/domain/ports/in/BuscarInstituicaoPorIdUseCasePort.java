package org.myaplication.domain.ports.in;

import org.myaplication.domain.entities.Instituicao;

public interface BuscarInstituicaoPorIdUseCasePort {

   Instituicao buscarInstituicaoPorId(Integer id);
}
