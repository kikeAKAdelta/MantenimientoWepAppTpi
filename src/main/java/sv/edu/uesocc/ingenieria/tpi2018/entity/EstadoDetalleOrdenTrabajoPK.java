package sv.edu.uesocc.ingenieria.tpi2018.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ricky
 */
@Embeddable
public class EstadoDetalleOrdenTrabajoPK implements Serializable {


    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado")
    private int idEstado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle_orden_trabajo")
    private int idDetalleOrdenTrabajo;

    public EstadoDetalleOrdenTrabajoPK(){}

    public EstadoDetalleOrdenTrabajoPK(int idEstado, int idDetalleOrdenTrabajo) {
        this.idEstado = idEstado;
        this.idDetalleOrdenTrabajo = idDetalleOrdenTrabajo;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdDetalleOrdenTrabajo() {
        return idDetalleOrdenTrabajo;
    }

    public void setIdDetalleOrdenTrabajo(int idDetalleOrdenTrabajo) {
        this.idDetalleOrdenTrabajo = idDetalleOrdenTrabajo;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstado;
        hash += (int) idDetalleOrdenTrabajo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDetalleOrdenTrabajoPK)) {
            return false;
        }
        EstadoDetalleOrdenTrabajoPK other = (EstadoDetalleOrdenTrabajoPK) object;
        if (this.idEstado != other.idEstado) {
            return false;
        }
        if (this.idDetalleOrdenTrabajo != other.idDetalleOrdenTrabajo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entity.EstadoDetalleOrdenTrabajoPK[ idEstado=" + idEstado + ", idDetalleOrdenTrabajo=" + idDetalleOrdenTrabajo + " ]";
    }
    
}