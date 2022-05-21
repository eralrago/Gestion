/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ferbo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
@Entity
@Table(name = "cliente_contacto")
@NamedQueries({
    @NamedQuery(name = "ClienteContacto.findAll", query = "SELECT c FROM ClienteContacto c"),
    @NamedQuery(name = "ClienteContacto.findByIdCliente", query = "SELECT c FROM ClienteContacto c WHERE c.clienteContactoPK.idCliente = :idCliente"),
    @NamedQuery(name = "ClienteContacto.findByIdContacto", query = "SELECT c FROM ClienteContacto c WHERE c.clienteContactoPK.idContacto = :idContacto"),
    @NamedQuery(name = "ClienteContacto.findByStHabilitado", query = "SELECT c FROM ClienteContacto c WHERE c.stHabilitado = :stHabilitado"),
    @NamedQuery(name = "ClienteContacto.findByNbUsuario", query = "SELECT c FROM ClienteContacto c WHERE c.nbUsuario = :nbUsuario"),
    @NamedQuery(name = "ClienteContacto.findByNbPassword", query = "SELECT c FROM ClienteContacto c WHERE c.nbPassword = :nbPassword"),
    @NamedQuery(name = "ClienteContacto.findByStUsuario", query = "SELECT c FROM ClienteContacto c WHERE c.stUsuario = :stUsuario"),
    @NamedQuery(name = "ClienteContacto.findByFhAlta", query = "SELECT c FROM ClienteContacto c WHERE c.fhAlta = :fhAlta"),
    @NamedQuery(name = "ClienteContacto.findByFhCadPasswd", query = "SELECT c FROM ClienteContacto c WHERE c.fhCadPasswd = :fhCadPasswd"),
    @NamedQuery(name = "ClienteContacto.findByFhUltAcceso", query = "SELECT c FROM ClienteContacto c WHERE c.fhUltAcceso = :fhUltAcceso")})
public class ClienteContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteContactoPK clienteContactoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "st_habilitado")
    private boolean stHabilitado;
    @Size(max = 50)
    @Column(name = "nb_usuario")
    private String nbUsuario;
    @Size(max = 1024)
    @Column(name = "nb_password")
    private String nbPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "st_usuario")
    private String stUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fh_alta")
    @Temporal(TemporalType.DATE)
    private Date fhAlta;
    @Column(name = "fh_cad_passwd")
    @Temporal(TemporalType.DATE)
    private Date fhCadPasswd;
    @Column(name = "fh_ult_acceso")
    @Temporal(TemporalType.DATE)
    private Date fhUltAcceso;

    public ClienteContacto() {
    }

    public ClienteContacto(ClienteContactoPK clienteContactoPK) {
        this.clienteContactoPK = clienteContactoPK;
    }

    public ClienteContacto(ClienteContactoPK clienteContactoPK, boolean stHabilitado, String stUsuario, Date fhAlta) {
        this.clienteContactoPK = clienteContactoPK;
        this.stHabilitado = stHabilitado;
        this.stUsuario = stUsuario;
        this.fhAlta = fhAlta;
    }

    public ClienteContacto(int idCliente, int idContacto) {
        this.clienteContactoPK = new ClienteContactoPK(idCliente, idContacto);
    }

    public ClienteContactoPK getClienteContactoPK() {
        return clienteContactoPK;
    }

    public void setClienteContactoPK(ClienteContactoPK clienteContactoPK) {
        this.clienteContactoPK = clienteContactoPK;
    }

    public boolean getStHabilitado() {
        return stHabilitado;
    }

    public void setStHabilitado(boolean stHabilitado) {
        this.stHabilitado = stHabilitado;
    }

    public String getNbUsuario() {
        return nbUsuario;
    }

    public void setNbUsuario(String nbUsuario) {
        this.nbUsuario = nbUsuario;
    }

    public String getNbPassword() {
        return nbPassword;
    }

    public void setNbPassword(String nbPassword) {
        this.nbPassword = nbPassword;
    }

    public String getStUsuario() {
        return stUsuario;
    }

    public void setStUsuario(String stUsuario) {
        this.stUsuario = stUsuario;
    }

    public Date getFhAlta() {
        return fhAlta;
    }

    public void setFhAlta(Date fhAlta) {
        this.fhAlta = fhAlta;
    }

    public Date getFhCadPasswd() {
        return fhCadPasswd;
    }

    public void setFhCadPasswd(Date fhCadPasswd) {
        this.fhCadPasswd = fhCadPasswd;
    }

    public Date getFhUltAcceso() {
        return fhUltAcceso;
    }

    public void setFhUltAcceso(Date fhUltAcceso) {
        this.fhUltAcceso = fhUltAcceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteContactoPK != null ? clienteContactoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteContacto)) {
            return false;
        }
        ClienteContacto other = (ClienteContacto) object;
        if ((this.clienteContactoPK == null && other.clienteContactoPK != null) || (this.clienteContactoPK != null && !this.clienteContactoPK.equals(other.clienteContactoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.ClienteContacto[ clienteContactoPK=" + clienteContactoPK + " ]";
    }
    
}
