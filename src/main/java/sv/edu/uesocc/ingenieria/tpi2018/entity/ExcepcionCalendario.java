/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "excepcion_calendario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExcepcionCalendario.findAll", query = "SELECT e FROM ExcepcionCalendario e")
    , @NamedQuery(name = "ExcepcionCalendario.findByIdExcepcion", query = "SELECT e FROM ExcepcionCalendario e WHERE e.idExcepcion = :idExcepcion")
    , @NamedQuery(name = "ExcepcionCalendario.findByFecha", query = "SELECT e FROM ExcepcionCalendario e WHERE e.fecha = :fecha")})
public class ExcepcionCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_excepcion")
    private Integer idExcepcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public ExcepcionCalendario() {
    }

    public ExcepcionCalendario(Integer idExcepcion) {
        this.idExcepcion = idExcepcion;
    }

    public Integer getIdExcepcion() {
        return idExcepcion;
    }

    public void setIdExcepcion(Integer idExcepcion) {
        this.idExcepcion = idExcepcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExcepcion != null ? idExcepcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExcepcionCalendario)) {
            return false;
        }
        ExcepcionCalendario other = (ExcepcionCalendario) object;
        if ((this.idExcepcion == null && other.idExcepcion != null) || (this.idExcepcion != null && !this.idExcepcion.equals(other.idExcepcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entity.ExcepcionCalendario[ idExcepcion=" + idExcepcion + " ]";
    }
    
}
