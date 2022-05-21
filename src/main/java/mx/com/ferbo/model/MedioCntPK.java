/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ferbo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
@Embeddable
public class MedioCntPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medio")
    private int idMedio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tp_medio")
    private String tpMedio;

    public MedioCntPK() {
    }

    public MedioCntPK(int idMedio, String tpMedio) {
        this.idMedio = idMedio;
        this.tpMedio = tpMedio;
    }

    public int getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(int idMedio) {
        this.idMedio = idMedio;
    }

    public String getTpMedio() {
        return tpMedio;
    }

    public void setTpMedio(String tpMedio) {
        this.tpMedio = tpMedio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMedio;
        hash += (tpMedio != null ? tpMedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioCntPK)) {
            return false;
        }
        MedioCntPK other = (MedioCntPK) object;
        if (this.idMedio != other.idMedio) {
            return false;
        }
        if ((this.tpMedio == null && other.tpMedio != null) || (this.tpMedio != null && !this.tpMedio.equals(other.tpMedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.MedioCntPK[ idMedio=" + idMedio + ", tpMedio=" + tpMedio + " ]";
    }
    
}
