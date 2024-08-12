package org.myaplication.application.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.myaplication.domain.ports.in.BuscarInstituicaoPorIdUseCasePort;
import org.myaplication.domain.ports.in.ListarInstituicoesUseCasePort;

import java.util.NoSuchElementException;

@Path("/app/v1/instituicao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstituicaoController {

    @Inject
    ListarInstituicoesUseCasePort listarInstituicoesUseCasePort;

    @Inject
    BuscarInstituicaoPorIdUseCasePort buscarInstituicaoPorIdUseCasePort;

    @GET
    @Path("")
    @Transactional
    public Response listarInstituicoes(){
        try {
            return Response.ok(listarInstituicoesUseCasePort.listarInstituicoes()).build();

        } catch (NoSuchElementException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro inesperado: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Response buscarInstituicaoPorId(@PathParam(value = "id") Integer id){
        try {
            return Response.ok(buscarInstituicaoPorIdUseCasePort.buscarInstituicaoPorId(id)).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (NoSuchElementException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro inesperado: " + e.getMessage()).build();
        }
    }
}
