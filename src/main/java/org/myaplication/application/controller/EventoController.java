package org.myaplication.application.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.myaplication.application.presenters.requests.EventoDto;
import org.myaplication.domain.ports.in.AlterarEventoUseCasePort;
import org.myaplication.domain.ports.in.CriarEventoUseCasePort;
import org.myaplication.domain.ports.in.BuscarEventoPorIdUseCasePort;
import org.myaplication.domain.ports.in.ListarEventosUseCasePort;

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
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Registro nao encontrado com id:" + id).build();
        }
    }

    @POST
    @Path("")
    @Transactional
    public Response criarEvento(@Valid EventoDto request) throws RuntimeException {
        try {
            criarEventoUseCasePort.criarEvento(request);
            return Response.ok().entity("Evento criado com sucesso!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Não foi possivel cadastrar o evento!").build();
        }
    }

    @PUT
    @Path("")
    @Transactional
    public Response alterarEvento(@Valid EventoDto request) {
        alterarEventoUseCasePort.alterarEvento(request);
        return null;
    }

}
