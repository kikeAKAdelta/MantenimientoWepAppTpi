/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "subtipo_mtto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubtipoMtto.findAll", query = "SELECT s FROM SubtipoMtto s")
    , @NamedQuery(name = "SubtipoMtto.findByIdsubtipoMtto", query = "SELECT s FROM SubtipoMtto s WHERE s.subtipoMttoPK.idsubtipoMtto = :idsubtipoMtto")
    , @NamedQuery(name = "SubtipoMtto.findByIdTipomtto", query = "SELECT s FROM SubtipoMtto s WHERE s.subtipoMttoPK.idTipomtto = :idTipomtto")
    , @NamedQuery(name = "SubtipoMtto.findByDescripcion", query = "SELECT s FROM SubtipoMtto s WHERE s.descripcion = :descripcion")})
public class SubtipoMtto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubtipoMttoPK subtipoMttoPK;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_tipomtto", referencedColumnName = "id_tipomtto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipomtto tipomtto;

    public SubtipoMtto() {
    }

    public SubtipoMtto(SubtipoMttoPK subtipoMttoPK) {
        this.subtipoMttoPK = subtipoMttoPK;
    }

    public SubtipoMtto(int idsubtipoMtto, int idTipomtto) {
        this.subtipoMttoPK = new SubtipoMttoPK(idsubtipoMtto, idTipomtto);
    }

    public SubtipoMttoPK getSubtipoMttoPK() {
        return subtipoMttoPK;
    }

    public void setSubtipoMttoPK(SubtipoMttoPK subtipoMttoPK) {
        this.subtipoMttoPK = subtipoMttoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipomtto getTipomtto() {
        return tipomtto;
    }

    public void setTipomtto(Tipomtto tipomtto) {
        this.tipomtto = tipomtto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subtipoMttoPK != null ? subtipoMttoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubtipoMtto)) {
            return false;
        }
        SubtipoMtto other = (SubtipoMtto) object;
        if ((this.subtipoMttoPK == null && other.subtipoMttoPK != null) || (this.subtipoMttoPK != null && !this.subtipoMttoPK.equals(other.subtipoMttoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SubtipoMtto[ subtipoMttoPK=" + subtipoMttoPK + " ]";
    }
    
}
