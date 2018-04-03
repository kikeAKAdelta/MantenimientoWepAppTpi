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
public class DiagnosticoPartePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_diagnostico")
    private int idDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parte")
    private int idParte;

    public DiagnosticoPartePK() {
    }

    public DiagnosticoPartePK(int idDiagnostico, int idParte) {
        this.idDiagnostico = idDiagnostico;
        this.idParte = idParte;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDiagnostico;
        hash += (int) idParte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoPartePK)) {
            return false;
        }
        DiagnosticoPartePK other = (DiagnosticoPartePK) object;
        if (this.idDiagnostico != other.idDiagnostico) {
            return false;
        }
        if (this.idParte != other.idParte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DiagnosticoPartePK[ idDiagnostico=" + idDiagnostico + ", idParte=" + idParte + " ]";
    }
    
}
