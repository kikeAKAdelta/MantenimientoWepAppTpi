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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parte.findAll", query = "SELECT p FROM Parte p")
    , @NamedQuery(name = "Parte.findByIdParte", query = "SELECT p FROM Parte p WHERE p.idParte = :idParte")
    , @NamedQuery(name = "Parte.findByNumeroInventario", query = "SELECT p FROM Parte p WHERE p.numeroInventario = :numeroInventario")
    , @NamedQuery(name = "Parte.findByMarca", query = "SELECT p FROM Parte p WHERE p.marca = :marca")
    , @NamedQuery(name = "Parte.findByModelo", query = "SELECT p FROM Parte p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Parte.findByDescripcion", query = "SELECT p FROM Parte p WHERE p.descripcion = :descripcion")})
public class Parte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parte")
    private Integer idParte;
    @Column(name = "numero_inventario")
    private Integer numeroInventario;
    @Size(max = 100)
    @Column(name = "marca")
    private String marca;
    @Size(max = 100)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parte")
    private Collection<DiagnosticoParte> diagnosticoParteCollection;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne
    private Equipo idEquipo;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    @ManyToOne
    private Unidad idUnidad;
    @OneToMany(mappedBy = "idParte")
    private Collection<MttoDetalle> mttoDetalleCollection;

    public Parte() {
    }

    public Parte(Integer idParte) {
        this.idParte = idParte;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public Integer getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(Integer numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<DiagnosticoParte> getDiagnosticoParteCollection() {
        return diagnosticoParteCollection;
    }

    public void setDiagnosticoParteCollection(Collection<DiagnosticoParte> diagnosticoParteCollection) {
        this.diagnosticoParteCollection = diagnosticoParteCollection;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MttoDetalle> getMttoDetalleCollection() {
        return mttoDetalleCollection;
    }

    public void setMttoDetalleCollection(Collection<MttoDetalle> mttoDetalleCollection) {
        this.mttoDetalleCollection = mttoDetalleCollection;
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
        return "sv.edu.uesocc.ingenieria.tpi2018.entity.Parte[ idParte=" + idParte + " ]";
    }
    
}
