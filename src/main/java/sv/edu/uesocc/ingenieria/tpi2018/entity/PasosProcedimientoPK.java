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
public class PasosProcedimientoPK implements Serializable {


    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pasos")
    private int idPasos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procedimiento")
    private int idProcedimiento;

    public PasosProcedimientoPK(){}

    public PasosProcedimientoPK(int idPasos, int idProcedimiento) {
        this.idPasos = idPasos;
        this.idProcedimiento = idProcedimiento;
    }

    public int getIdPasos() {
        return idPasos;
    }

    public void setIdPasos(int idPasos) {
        this.idPasos = idPasos;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPasos;
        hash += (int) idProcedimiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasosProcedimientoPK)) {
            return false;
        }
        PasosProcedimientoPK other = (PasosProcedimientoPK) object;
        if (this.idPasos != other.idPasos) {
            return false;
        }
        if (this.idProcedimiento != other.idProcedimiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entity.PasosProcedimientoPK[ idPasos=" + idPasos + ", idProcedimiento=" + idProcedimiento + " ]";
    }
    
}