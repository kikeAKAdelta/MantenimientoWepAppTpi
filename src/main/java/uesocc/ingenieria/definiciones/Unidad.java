/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ingenieria.definiciones;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "unidad")
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Unidad c")
    , @NamedQuery(name = "Calendario.findByIdUnidad", query = "SELECT c FROM Unidad c WHERE c.idUnidad = :idUnidad")
    , @NamedQuery(name = "Calendario.findByNombreUnidad", query = "SELECT c FROM Unidad c WHERE c.nombreUnidad = :nombreUnidad")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad", nullable = false)
    private Integer idUnidad;
    
    @NotNull
    @Basic(optional = false)
    @Size(max = 300)
    @Column(name = "nombre_unidad", length = 300)
    private String nombreUnidad;

    public Unidad(){}

    public Unidad(Integer idUnidad, String nombreUnidad) {
        this.idUnidad = idUnidad;
        this.nombreUnidad = nombreUnidad;
    }    
    
    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.ingenieria.definiciones.Unidad[ id=" + idUnidad + " ]";
    }
    
}
