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
@Table(name = "mail")
@NamedQueries({
    @NamedQuery(name = "Mail.findAll", query = "SELECT m FROM Mail m"),
    @NamedQuery(name = "Mail.findByIdMedio", query = "SELECT m FROM Mail m WHERE m.idMedio = :idMedio"),
    @NamedQuery(name = "Mail.findByNbMail", query = "SELECT m FROM Mail m WHERE m.nbMail = :nbMail"),
    @NamedQuery(name = "Mail.findByStPrincipal", query = "SELECT m FROM Mail m WHERE m.stPrincipal = :stPrincipal"),
    @NamedQuery(name = "Mail.findByTpMail", query = "SELECT m FROM Mail m WHERE m.tpMail = :tpMail")})
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medio")
    private Integer idMedio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nb_mail")
    private String nbMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "st_principal")
    private boolean stPrincipal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tp_mail")
    private short tpMail;

    public Mail() {
    }

    public Mail(Integer idMedio) {
        this.idMedio = idMedio;
    }

    public Mail(Integer idMedio, String nbMail, boolean stPrincipal, short tpMail) {
        this.idMedio = idMedio;
        this.nbMail = nbMail;
        this.stPrincipal = stPrincipal;
        this.tpMail = tpMail;
    }

    public Integer getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Integer idMedio) {
        this.idMedio = idMedio;
    }

    public String getNbMail() {
        return nbMail;
    }

    public void setNbMail(String nbMail) {
        this.nbMail = nbMail;
    }

    public boolean getStPrincipal() {
        return stPrincipal;
    }

    public void setStPrincipal(boolean stPrincipal) {
        this.stPrincipal = stPrincipal;
    }

    public short getTpMail() {
        return tpMail;
    }

    public void setTpMail(short tpMail) {
        this.tpMail = tpMail;
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
        if (!(object instanceof Mail)) {
            return false;
        }
        Mail other = (Mail) object;
        if ((this.idMedio == null && other.idMedio != null) || (this.idMedio != null && !this.idMedio.equals(other.idMedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.Mail[ idMedio=" + idMedio + " ]";
    }
    
}
