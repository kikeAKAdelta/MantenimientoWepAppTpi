
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
    public <T> int getEntidad(@QueryParam("entidadGet") T entidad){
        
        if (entidad != null) {
            return Response.Status.OK.getStatusCode();
        }
        return Response.Status.NOT_FOUND.getStatusCode();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public <T> int postEntidad(@QueryParam("entidadPut")T entidad){
        
        if (entidad !=null ) {
            return Response.Status.CREATED.getStatusCode();
        }
        return Response.Status.NOT_IMPLEMENTED.getStatusCode();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public <T> int putEntidad(@QueryParam("entidadPut") T entidad){
        
        if (entidad !=null ) {
              return Response.Status.CREATED.getStatusCode();
        }
        return Response.Status.NOT_MODIFIED.getStatusCode(); 
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public <T> int deleteEntidad(@QueryParam("entidadDelete") T entidad){
        
        if (entidad !=null ) {
            return Response.Status.OK.getStatusCode();
        }
        
        return Response.Status.NOT_FOUND.getStatusCode();
    }
    
}
