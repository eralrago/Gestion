/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ferbo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
@Entity
@Table(name = "telefono")
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdMedio", query = "SELECT t FROM Telefono t WHERE t.idMedio = :idMedio"),
    @NamedQuery(name = "Telefono.findByNbTelefono", query = "SELECT t FROM Telefono t WHERE t.nbTelefono = :nbTelefono"),
    @NamedQuery(name = "Telefono.findByStPrincipal", query = "SELECT t FROM Telefono t WHERE t.stPrincipal = :stPrincipal"),
    @NamedQuery(name = "Telefono.findByTpTelefono", query = "SELECT t FROM Telefono t WHERE t.tpTelefono = :tpTelefono")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medio")
    private Integer idMedio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nb_telefono")
    private String nbTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "st_principal")
    private boolean stPrincipal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tp_telefono")
    private short tpTelefono;

    public Telefono() {
    }

    public Telefono(Integer idMedio) {
        this.idMedio = idMedio;
    }

    public Telefono(Integer idMedio, String nbTelefono, boolean stPrincipal, short tpTelefono) {
        this.idMedio = idMedio;
        this.nbTelefono = nbTelefono;
        this.stPrincipal = stPrincipal;
        this.tpTelefono = tpTelefono;
    }

    public Integer getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Integer idMedio) {
        this.idMedio = idMedio;
    }

    public String getNbTelefono() {
        return nbTelefono;
    }

    public void setNbTelefono(String nbTelefono) {
        this.nbTelefono = nbTelefono;
    }

    public boolean getStPrincipal() {
        return stPrincipal;
    }

    public void setStPrincipal(boolean stPrincipal) {
        this.stPrincipal = stPrincipal;
    }

    public short getTpTelefono() {
        return tpTelefono;
    }

    public void setTpTelefono(short tpTelefono) {
        this.tpTelefono = tpTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedio != null ? idMedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.idMedio == null && other.idMedio != null) || (this.idMedio != null && !this.idMedio.equals(other.idMedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.Telefono[ idMedio=" + idMedio + " ]";
    }
    
}
