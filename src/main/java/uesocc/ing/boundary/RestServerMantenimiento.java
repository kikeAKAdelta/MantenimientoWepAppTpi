
package uesocc.ing.boundary;

import java.io.Serializable;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import uesocc.ingenieria.pojosMantenimiento.*;

/**
 *
 * @author enrique
 */
@Path("restserver")
public class RestServerMantenimiento implements Serializable {
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public <T> Response getEntidad(@QueryParam("entidad") T entidad){
        
        if (entidad !=null ) {
            Response.status(200).entity(entidad).build();
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public <T> Response postEntidad(@QueryParam("entidad")T entidad){
        
        if (entidad !=null ) {
            return Response.status(Response.Status.CREATED).entity(entidad).build();
        }
        
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public <T> Response putEntidad(@QueryParam("entidad") T entidad){
        
        if (entidad !=null ) {
            Response.status(Response.Status.OK).entity(entidad).build();
        }
        
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public <T> Response deleteEntidad(@QueryParam("entidad") T entidad){
        
        if (entidad !=null ) {
            return Response.status(Response.Status.OK).entity(entidad).build();
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
}
