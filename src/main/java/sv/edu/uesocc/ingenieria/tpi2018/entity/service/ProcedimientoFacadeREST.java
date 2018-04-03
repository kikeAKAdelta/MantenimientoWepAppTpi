/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity.service;

import java.util.Collections;
import sv.edu.uesocc.ingenieria.tpi2018.entity.Procedimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ricky
 */
@Stateless
@Path("entity.procedimiento")
public class ProcedimientoFacadeREST extends AbstractFacade<Procedimiento> {

    @PersistenceContext(unitName = "Mantenimiento")
    private EntityManager em;

    public ProcedimientoFacadeREST() {
        super(Procedimiento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Procedimiento entity) {
        if (entity != null) {
            super.create(entity);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id) {
        if (id>0) {
            Procedimiento procedimiento=new Procedimiento();
            procedimiento=super.find(id);
            if (procedimiento != null) {
                super.edit(procedimiento);
            }
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        if (id>0) {
            Procedimiento procedimiento=new Procedimiento();
            procedimiento=super.find(id);
            if (procedimiento != null) {
                super.remove(procedimiento);
            }
        }
        
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Procedimiento find(@PathParam("id") Integer id) {
        if (id>0) {
            return super.find(id);
        }
        return null;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Procedimiento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Procedimiento> findRange(@PathParam("from") @DefaultValue("1") Integer from, @PathParam("to") @DefaultValue("50") Integer to) {
        boolean validado=from>0 && to>0;
        if (validado) {
            return super.findRange(new int[]{from, to});
        }
        return Collections.EMPTY_LIST;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
