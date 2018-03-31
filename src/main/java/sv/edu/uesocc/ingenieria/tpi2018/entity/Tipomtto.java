/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "tipomtto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomtto.findAll", query = "SELECT t FROM Tipomtto t")
    , @NamedQuery(name = "Tipomtto.findByIdTipomtto", query = "SELECT t FROM Tipomtto t WHERE t.idTipomtto = :idTipomtto")
    , @NamedQuery(name = "Tipomtto.findByDescripcion", query = "SELECT t FROM Tipomtto t WHERE t.descripcion = :descripcion")})
public class Tipomtto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipomtto")
    private Integer idTipomtto;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idTipomtto")
    private Collection<OrdenTrabajo> ordenTrabajoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipomtto")
    private Collection<SubtipoMtto> subtipoMttoCollection;

    public Tipomtto() {
    }

    public Tipomtto(Integer idTipomtto) {
        this.idTipomtto = idTipomtto;
    }

    public Integer getIdTipomtto() {
        return idTipomtto;
    }

    public void setIdTipomtto(Integer idTipomtto) {
        this.idTipomtto = idTipomtto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<OrdenTrabajo> getOrdenTrabajoCollection() {
        return ordenTrabajoCollection;
    }

    public void setOrdenTrabajoCollection(Collection<OrdenTrabajo> ordenTrabajoCollection) {
        this.ordenTrabajoCollection = ordenTrabajoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<SubtipoMtto> getSubtipoMttoCollection() {
        return subtipoMttoCollection;
    }

    public void setSubtipoMttoCollection(Collection<SubtipoMtto> subtipoMttoCollection) {
        this.subtipoMttoCollection = subtipoMttoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipomtto != null ? idTipomtto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomtto)) {
            return false;
        }
        Tipomtto other = (Tipomtto) object;
        if ((this.idTipomtto == null && other.idTipomtto != null) || (this.idTipomtto != null && !this.idTipomtto.equals(other.idTipomtto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tipomtto[ idTipomtto=" + idTipomtto + " ]";
    }
    
}
