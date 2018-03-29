
package uesocc.ingenieria.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calendario")
public class Calendario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_calendario", nullable = false)
    private Integer idCalendario;
    
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @Column(name = "descripcion", length = 150)
    private String descripcion;
    
    public Calendario(){
        
    }

    public Calendario(Integer idCalendario, Date fecha, String calendario) {
        this.idCalendario = idCalendario;
        this.fecha = fecha;
        this.descripcion = calendario;
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCalendario() {
        return descripcion;
    }

    public void setCalendario(String calendario) {
        this.descripcion = calendario;
    }

    @Override
    public String toString() {
        return "Calendario{" + "idCalendario=" + idCalendario + ", fecha=" + fecha + ", calendario=" + descripcion + '}';
    }
    
    
    
}
