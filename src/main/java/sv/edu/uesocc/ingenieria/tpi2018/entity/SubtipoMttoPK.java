/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity;

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
public class SubtipoMttoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idsubtipo_mtto")
    private int idsubtipoMtto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipomtto")
    private int idTipomtto;

    public SubtipoMttoPK() {
    }

    public SubtipoMttoPK(int idsubtipoMtto, int idTipomtto) {
        this.idsubtipoMtto = idsubtipoMtto;
        this.idTipomtto = idTipomtto;
    }

    public int getIdsubtipoMtto() {
        return idsubtipoMtto;
    }

    public void setIdsubtipoMtto(int idsubtipoMtto) {
        this.idsubtipoMtto = idsubtipoMtto;
    }

    public int getIdTipomtto() {
        return idTipomtto;
    }

    public void setIdTipomtto(int idTipomtto) {
        this.idTipomtto = idTipomtto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idsubtipoMtto;
        hash += (int) idTipomtto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubtipoMttoPK)) {
            return false;
        }
        SubtipoMttoPK other = (SubtipoMttoPK) object;
        if (this.idsubtipoMtto != other.idsubtipoMtto) {
            return false;
        }
        if (this.idTipomtto != other.idTipomtto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entity.SubtipoMttoPK[ idsubtipoMtto=" + idsubtipoMtto + ", idTipomtto=" + idTipomtto + " ]";
    }
    
}
