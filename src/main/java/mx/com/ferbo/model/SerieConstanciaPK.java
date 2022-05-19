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
public class SerieConstanciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tp_serie")
    private String tpSerie;

    public SerieConstanciaPK() {
    }

    public SerieConstanciaPK(int idCliente, String tpSerie) {
        this.idCliente = idCliente;
        this.tpSerie = tpSerie;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTpSerie() {
        return tpSerie;
    }

    public void setTpSerie(String tpSerie) {
        this.tpSerie = tpSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCliente;
        hash += (tpSerie != null ? tpSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SerieConstanciaPK)) {
            return false;
        }
        SerieConstanciaPK other = (SerieConstanciaPK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if ((this.tpSerie == null && other.tpSerie != null) || (this.tpSerie != null && !this.tpSerie.equals(other.tpSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.SerieConstanciaPK[ idCliente=" + idCliente + ", tpSerie=" + tpSerie + " ]";
    }
    
}
