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
@Table(name = "diagnostico_parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticoParte.findAll", query = "SELECT d FROM DiagnosticoParte d")
    , @NamedQuery(name = "DiagnosticoParte.findByIdDiagnostico", query = "SELECT d FROM DiagnosticoParte d WHERE d.diagnosticoPartePK.idDiagnostico = :idDiagnostico")
    , @NamedQuery(name = "DiagnosticoParte.findByIdParte", query = "SELECT d FROM DiagnosticoParte d WHERE d.diagnosticoPartePK.idParte = :idParte")
    , @NamedQuery(name = "DiagnosticoParte.findByDescripcion", query = "SELECT d FROM DiagnosticoParte d WHERE d.descripcion = :descripcion")})
public class DiagnosticoParte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticoPartePK diagnosticoPartePK;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id_diagnostico", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diagnostico diagnostico;
    @JoinColumn(name = "id_parte", referencedColumnName = "id_parte", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parte parte;

    public DiagnosticoParte() {
    }

    public DiagnosticoParte(DiagnosticoPartePK diagnosticoPartePK) {
        this.diagnosticoPartePK = diagnosticoPartePK;
    }

    public DiagnosticoParte(int idDiagnostico, int idParte) {
        this.diagnosticoPartePK = new DiagnosticoPartePK(idDiagnostico, idParte);
    }

    public DiagnosticoPartePK getDiagnosticoPartePK() {
        return diagnosticoPartePK;
    }

    public void setDiagnosticoPartePK(DiagnosticoPartePK diagnosticoPartePK) {
        this.diagnosticoPartePK = diagnosticoPartePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Parte getParte() {
        return parte;
    }

    public void setParte(Parte parte) {
        this.parte = parte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoPartePK != null ? diagnosticoPartePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoParte)) {
            return false;
        }
        DiagnosticoParte other = (DiagnosticoParte) object;
        if ((this.diagnosticoPartePK == null && other.diagnosticoPartePK != null) || (this.diagnosticoPartePK != null && !this.diagnosticoPartePK.equals(other.diagnosticoPartePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entity.DiagnosticoParte[ diagnosticoPartePK=" + diagnosticoPartePK + " ]";
    }
    
}
