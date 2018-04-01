/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import sv.edu.uesocc.ingenieria.tpi2018.entity.PasosProcedimiento;
import sv.edu.uesocc.ingenieria.tpi2018.entity.PasosProcedimientoPK;

/**
 *
 * @author ricky
 */
@Stateless
@Path("sv.edu.uesocc.ingenieria.tpi2018.entity.pasosprocedimiento")
public class PasosProcedimientoFacadeREST extends AbstractFacade<PasosProcedimiento> {

    @PersistenceContext(unitName = "Mantenimiento")
    private EntityManager em;

    private PasosProcedimientoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idPasos=idPasosValue;idProcedimiento=idProcedimientoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        sv.edu.uesocc.ingenieria.tpi2018.entity.PasosProcedimientoPK key = new sv.edu.uesocc.ingenieria.tpi2018.entity.PasosProcedimientoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idPasos = map.get("idPasos");
        if (idPasos != null && !idPasos.isEmpty()) {
            key.setIdPasos(new java.lang.Integer(idPasos.get(0)));
        }
        java.util.List<String> idProcedimiento = map.get("idProcedimiento");
        if (idProcedimiento != null && !idProcedimiento.isEmpty()) {
            key.setIdProcedimiento(new java.lang.Integer(idProcedimiento.get(0)));
        }
        return key;
    }

    public PasosProcedimientoFacadeREST() {
        super(PasosProcedimiento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PasosProcedimiento entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, PasosProcedimiento entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        sv.edu.uesocc.ingenieria.tpi2018.entity.PasosProcedimientoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PasosProcedimiento find(@PathParam("id") PathSegment id) {
        sv.edu.uesocc.ingenieria.tpi2018.entity.PasosProcedimientoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PasosProcedimiento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PasosProcedimiento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
