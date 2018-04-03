/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity.service;

import java.util.Collections;
import sv.edu.uesocc.ingenieria.tpi2018.entity.DiagnosticoParte;
import sv.edu.uesocc.ingenieria.tpi2018.entity.DiagnosticoPartePK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author ricky
 */
@Stateless
@Path("entity.diagnosticoparte")
public class DiagnosticoParteFacadeREST extends AbstractFacade<DiagnosticoParte> {

    @PersistenceContext(unitName = "Mantenimiento")
    private EntityManager em;

    private DiagnosticoPartePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idDiagnostico=idDiagnosticoValue;idParte=idParteValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        sv.edu.uesocc.ingenieria.tpi2018.entity.DiagnosticoPartePK key = new sv.edu.uesocc.ingenieria.tpi2018.entity.DiagnosticoPartePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idDiagnostico = map.get("idDiagnostico");
        if (idDiagnostico != null && !idDiagnostico.isEmpty()) {
            key.setIdDiagnostico(new java.lang.Integer(idDiagnostico.get(0)));
        }
        java.util.List<String> idParte = map.get("idParte");
        if (idParte != null && !idParte.isEmpty()) {
            key.setIdParte(new java.lang.Integer(idParte.get(0)));
        }
        return key;
    }

    public DiagnosticoParteFacadeREST() {
        super(DiagnosticoParte.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DiagnosticoParte entity) {
        if (entity != null) {
            super.create(entity);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, DiagnosticoParte entity) {
        if (id != null && entity != null) {
            DiagnosticoPartePK nuevoPK=getPrimaryKey(id);
            nuevoPK.hashCode();
            if (nuevoPK.equals(entity)) {
                super.edit(entity);
            }
        }
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        if (id != null) {
            sv.edu.uesocc.ingenieria.tpi2018.entity.DiagnosticoPartePK key = getPrimaryKey(id);
            super.remove(super.find(key));
        }
        
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DiagnosticoParte find(@PathParam("id") PathSegment id) {
        if (id != null) {
            sv.edu.uesocc.ingenieria.tpi2018.entity.DiagnosticoPartePK key = getPrimaryKey(id);
            return super.find(key);            
        }
        return null;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiagnosticoParte> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiagnosticoParte> findRange(@PathParam("from") @DefaultValue("1") Integer from, @PathParam("to") @DefaultValue("1") Integer to) {
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
