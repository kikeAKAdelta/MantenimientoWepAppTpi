
package uesocc.ing.boundary;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("mantenimiento")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.CalendarioFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.DetalleOrdenTrabajoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.DiagnosticoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.DiagnosticoParteFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.EquipoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.EstadoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.ExcepcionCalendarioFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.MttoDetalleFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.OrdenTrabajoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.ParteFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.PasosFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.PrioridadFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.ProcedimientoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.ResponsableFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.SolicitudFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.SubtipoMttoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.TipomttoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.entity.service.UnidadFacadeREST.class);
        resources.add(uesocc.ing.boundary.RestServerMantenimiento.class);
        
    }
}
