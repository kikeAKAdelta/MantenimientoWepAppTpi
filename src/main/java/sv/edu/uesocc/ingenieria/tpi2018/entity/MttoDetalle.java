/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "mtto_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MttoDetalle.findAll", query = "SELECT m FROM MttoDetalle m")
    , @NamedQuery(name = "MttoDetalle.findByIdMttoDetalle", query = "SELECT m FROM MttoDetalle m WHERE m.idMttoDetalle = :idMttoDetalle")})
public class MttoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mtto_detalle")
    private Integer idMttoDetalle;
    @OneToMany(mappedBy = "idMttoDetalle")
    private Collection<DetalleOrdenTrabajo> detalleOrdenTrabajoCollection;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;
    @JoinColumn(name = "id_parte", referencedColumnName = "id_parte")
    @ManyToOne
    private Parte idParte;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne
    private Responsable idResponsable;

    public MttoDetalle() {
    }

    public MttoDetalle(Integer idMttoDetalle) {
        this.idMttoDetalle = idMttoDetalle;
    }

    public Integer getIdMttoDetalle() {
        return idMttoDetalle;
    }

    public void setIdMttoDetalle(Integer idMttoDetalle) {
        this.idMttoDetalle = idMttoDetalle;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<DetalleOrdenTrabajo> getDetalleOrdenTrabajoCollection() {
        return detalleOrdenTrabajoCollection;
    }

    public void setDetalleOrdenTrabajoCollection(Collection<DetalleOrdenTrabajo> detalleOrdenTrabajoCollection) {
        this.detalleOrdenTrabajoCollection = detalleOrdenTrabajoCollection;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Parte getIdParte() {
        return idParte;
    }

    public void setIdParte(Parte idParte) {
        this.idParte = idParte;
    }

    public Responsable getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsable idResponsable) {
        this.idResponsable = idResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMttoDetalle != null ? idMttoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MttoDetalle)) {
            return false;
        }
        MttoDetalle other = (MttoDetalle) object;
        if ((this.idMttoDetalle == null && other.idMttoDetalle != null) || (this.idMttoDetalle != null && !this.idMttoDetalle.equals(other.idMttoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MttoDetalle[ idMttoDetalle=" + idMttoDetalle + " ]";
    }
    
}
