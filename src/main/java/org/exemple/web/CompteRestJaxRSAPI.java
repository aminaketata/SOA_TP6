package org.exemple.web;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.exemple.entities.Compte;
import org.exemple.repositories.CompteRepository;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI
{
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional
    public List<Compte> compteList()
    {
        return compteRepository.findAll();
    }
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id") Long id)
    {
        return compteRepository.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte)
    {
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update (Compte compte,@PathParam("id") Long id)
    {
        compte.setId(id);
        return compteRepository.save(compte);
    }
}
