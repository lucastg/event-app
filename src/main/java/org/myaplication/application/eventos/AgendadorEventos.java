package org.myaplication.application.eventos;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.myaplication.domain.usecases.eventos.VerificarEAtualizarStatusEventoUseCase;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@ApplicationScoped
public class AgendadorEventos {

    @Inject
    VerificarEAtualizarStatusEventoUseCase verificarEAtualizarStatusEventoUseCase;

    @Scheduled(every = "1m", delay = 50, delayUnit = TimeUnit.SECONDS)
    public void agregarEvento() {
        log.info("Agregar evento: {}", LocalDateTime.now());
        verificarEAtualizarStatusEventoUseCase.atualizarStatusEvento();

    }
}

