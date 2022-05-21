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

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
@Embeddable
public class ClienteContactoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contacto")
    private int idContacto;

    public ClienteContactoPK() {
    }

    public ClienteContactoPK(int idCliente, int idContacto) {
        this.idCliente = idCliente;
        this.idContacto = idContacto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCliente;
        hash += (int) idContacto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteContactoPK)) {
            return false;
        }
        ClienteContactoPK other = (ClienteContactoPK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idContacto != other.idContacto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.ClienteContactoPK[ idCliente=" + idCliente + ", idContacto=" + idContacto + " ]";
    }
    
}
