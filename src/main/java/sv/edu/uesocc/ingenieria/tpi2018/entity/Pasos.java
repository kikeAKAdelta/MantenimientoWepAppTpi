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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "pasos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasos.findAll", query = "SELECT p FROM Pasos p")
    , @NamedQuery(name = "Pasos.findByIdPasos", query = "SELECT p FROM Pasos p WHERE p.idPasos = :idPasos")
    , @NamedQuery(name = "Pasos.findByDescripcion", query = "SELECT p FROM Pasos p WHERE p.descripcion = :descripcion")})
public class Pasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pasos")
    private Integer idPasos;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "pasos_procedimiento", joinColumns = {
        @JoinColumn(name = "id_pasos", referencedColumnName = "id_pasos")}, inverseJoinColumns = {
        @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento")})
    @ManyToMany
    private Collection<Procedimiento> procedimientoCollection;

    public Pasos() {
    }

    public Pasos(Integer idPasos) {
        this.idPasos = idPasos;
    }

    public Integer getIdPasos() {
        return idPasos;
    }

    public void setIdPasos(Integer idPasos) {
        this.idPasos = idPasos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Procedimiento> getProcedimientoCollection() {
        return procedimientoCollection;
    }

    public void setProcedimientoCollection(Collection<Procedimiento> procedimientoCollection) {
        this.procedimientoCollection = procedimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasos != null ? idPasos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasos)) {
            return false;
        }
        Pasos other = (Pasos) object;
        if ((this.idPasos == null && other.idPasos != null) || (this.idPasos != null && !this.idPasos.equals(other.idPasos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pasos[ idPasos=" + idPasos + " ]";
    }
    
}
