package org.myaplication.application.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.ports.in.*;

import java.util.NoSuchElementException;

@Path("/app/v1/evento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventoController {

    @Inject
    CriarEventoUseCasePort criarEventoUseCasePort;

    @Inject
    ListarEventosUseCasePort listarEventosUseCasePort;

    @Inject
    BuscarEventoPorIdUseCasePort buscarEventoPorIdUseCasePort;

    @Inject
    AlterarEventoUseCasePort alterarEventoUseCasePort;

    @Inject
    DeletarEventoUseCasePort deletarEventoUseCasePort;


    @GET
    @Path("")
    @Transactional
    public Response listarEventos() throws RuntimeException {
        try {
            return Response.ok(listarEventosUseCasePort.listarEventos()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Sem Registros!").build();
        }
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Response buscarEventoPorId(@PathParam(value = "id") Integer id) throws RuntimeException {
        try {
            return Response.ok(buscarEventoPorIdUseCasePort.buscarEventoPorId(id)).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (NoSuchElementException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro inesperado: " + e.getMessage()).build();
        }
    }

    @POST
    @Path("")
    @Transactional
    public Response criarEvento(@Valid EventoDto request) throws IllegalArgumentException {
        try {
            criarEventoUseCasePort.criarEvento(request);
            return Response.ok().entity("Evento criado com sucesso!").build();

        } catch (IllegalStateException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro inesperado: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response alterarEvento(@PathParam(value = "id") Integer id, @Valid EventoDto request) {
        try {
            alterarEventoUseCasePort.alterarEvento(id,request);
            return Response.ok().entity("Evento editado com sucesso!").build();

        } catch (IllegalStateException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro inesperado: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarEvento(@PathParam(value = "id") Integer id) {
        try {
            deletarEventoUseCasePort.deletarEvento(id);
            return Response.ok().entity("Deletado com sucesso!").build();

        } catch (NoSuchElementException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro inesperado: " + e.getMessage()).build();
        }
    }

}