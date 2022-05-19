/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ferbo.model;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
@Entity
@Table(name = "UNIDAD_DE_MANEJO")
@NamedQueries({
    @NamedQuery(name = "UnidadDeManejo.findAll", query = "SELECT u FROM UnidadDeManejo u"),
    @NamedQuery(name = "UnidadDeManejo.findByUnidadDeManejoCve", query = "SELECT u FROM UnidadDeManejo u WHERE u.unidadDeManejoCve = :unidadDeManejoCve"),
    @NamedQuery(name = "UnidadDeManejo.findByUnidadDeManejoDs", query = "SELECT u FROM UnidadDeManejo u WHERE u.unidadDeManejoDs = :unidadDeManejoDs")})
public class UnidadDeManejo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UNIDAD_DE_MANEJO_CVE")
    private Integer unidadDeManejoCve;
    @Size(max = 100)
    @Column(name = "UNIDAD_DE_MANEJO_DS")
    private String unidadDeManejoDs;
    @OneToMany(mappedBy = "uMedidaCve")
    private List<DetallePartida> detallePartidaList;
    @OneToMany(mappedBy = "unidadDeCobro")
    private List<Partida> partidaList;
    @OneToMany(mappedBy = "unidadDeManejoCve")
    private List<PartidaServicio> partidaServicioList;
    @OneToMany(mappedBy = "unidadDeCobro")
    private List<PartidaServicio> partidaServicioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadDeManejoCve")
    private List<UnidadDeProducto> unidadDeProductoList;

    public UnidadDeManejo() {
    }

    public UnidadDeManejo(Integer unidadDeManejoCve) {
        this.unidadDeManejoCve = unidadDeManejoCve;
    }

    public Integer getUnidadDeManejoCve() {
        return unidadDeManejoCve;
    }

    public void setUnidadDeManejoCve(Integer unidadDeManejoCve) {
        this.unidadDeManejoCve = unidadDeManejoCve;
    }

    public String getUnidadDeManejoDs() {
        return unidadDeManejoDs;
    }

    public void setUnidadDeManejoDs(String unidadDeManejoDs) {
        this.unidadDeManejoDs = unidadDeManejoDs;
    }

    public List<DetallePartida> getDetallePartidaList() {
        return detallePartidaList;
    }

    public void setDetallePartidaList(List<DetallePartida> detallePartidaList) {
        this.detallePartidaList = detallePartidaList;
    }

    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    public List<PartidaServicio> getPartidaServicioList() {
        return partidaServicioList;
    }

    public void setPartidaServicioList(List<PartidaServicio> partidaServicioList) {
        this.partidaServicioList = partidaServicioList;
    }

    public List<PartidaServicio> getPartidaServicioList1() {
        return partidaServicioList1;
    }

    public void setPartidaServicioList1(List<PartidaServicio> partidaServicioList1) {
        this.partidaServicioList1 = partidaServicioList1;
    }

    public List<UnidadDeProducto> getUnidadDeProductoList() {
        return unidadDeProductoList;
    }

    public void setUnidadDeProductoList(List<UnidadDeProducto> unidadDeProductoList) {
        this.unidadDeProductoList = unidadDeProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadDeManejoCve != null ? unidadDeManejoCve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadDeManejo)) {
            return false;
        }
        UnidadDeManejo other = (UnidadDeManejo) object;
        if ((this.unidadDeManejoCve == null && other.unidadDeManejoCve != null) || (this.unidadDeManejoCve != null && !this.unidadDeManejoCve.equals(other.unidadDeManejoCve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.UnidadDeManejo[ unidadDeManejoCve=" + unidadDeManejoCve + " ]";
    }
    
}
