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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "unidad")
public class Parte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parte", nullable = false)
    private Integer idParte;
    
    @Column(name = "numero_inventario")
    private Integer numeroInventario;
    
    @Size(max = 300)
    @NotNull
    @Basic(optional = false)
    @Column(name = "marca", length = 300)
    private String marca;
    
    @Size(max = 300)
    @NotNull
    @Basic(optional = false)
    @Column(name = "modelo", length = 300)
    private String modelo;
    
    @Size(max = 10485760)
    @Column(name = "descripcion", length = 10485760)
    private String descripcion;
    
    
            
    

    public Integer getId() {
        return idParte;
    }

    public void setId(Integer id) {
        this.idParte = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParte != null ? idParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parte)) {
            return false;
        }
        Parte other = (Parte) object;
        if ((this.idParte == null && other.idParte != null) || (this.idParte != null && !this.idParte.equals(other.idParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.ingenieria.definiciones.Parte[ id=" + idParte + " ]";
    }
    
}
