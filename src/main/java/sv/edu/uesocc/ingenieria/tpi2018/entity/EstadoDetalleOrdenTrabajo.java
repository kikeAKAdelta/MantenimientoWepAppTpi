package sv.edu.uesocc.ingenieria.tpi2018.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "estado_detalle_orden_trabajo")
@XmlRootElement
public class EstadoDetalleOrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EstadoDetalleOrdenTrabajoPK estadoDetalleOrdenTrabajoPK;
    
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estado estado;
    
    @JoinColumn(name = "id_detalle_orden_trabajo", referencedColumnName = "id_detalle_orden_trabajo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleOrdenTrabajo detalleOrdenTrabajo;
    
    public EstadoDetalleOrdenTrabajo(){}

    public EstadoDetalleOrdenTrabajo(EstadoDetalleOrdenTrabajoPK estadoDetalleOrdenTrabajoPK) {
        this.estadoDetalleOrdenTrabajoPK = estadoDetalleOrdenTrabajoPK;
    }

    public EstadoDetalleOrdenTrabajoPK getEstadoDetalleOrdenTrabajoPK() {
        return estadoDetalleOrdenTrabajoPK;
    }

    public void setEstadoDetalleOrdenTrabajoPK(EstadoDetalleOrdenTrabajoPK estadoDetalleOrdenTrabajoPK) {
        this.estadoDetalleOrdenTrabajoPK = estadoDetalleOrdenTrabajoPK;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public DetalleOrdenTrabajo getDetalleOrdenTrabajo() {
        return detalleOrdenTrabajo;
    }

    public void setDetalleOrdenTrabajo(DetalleOrdenTrabajo detalleOrdenTrabajo) {
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoDetalleOrdenTrabajoPK != null ? estadoDetalleOrdenTrabajoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDetalleOrdenTrabajo)) {
            return false;
        }
        EstadoDetalleOrdenTrabajo other = (EstadoDetalleOrdenTrabajo) object;
        if ((this.estadoDetalleOrdenTrabajoPK == null && other.estadoDetalleOrdenTrabajoPK != null) || (this.estadoDetalleOrdenTrabajoPK != null && !this.estadoDetalleOrdenTrabajoPK.equals(other.estadoDetalleOrdenTrabajoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entity.EstadoDetalleOrdenTrabajo[ estadoDetalleOrdenTrabajoPK=" + estadoDetalleOrdenTrabajoPK + " ]";
    }
    
}
