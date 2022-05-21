/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ferbo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
@Entity
@Table(name = "medio_cnt")
@NamedQueries({
    @NamedQuery(name = "MedioCnt.findAll", query = "SELECT m FROM MedioCnt m"),
    @NamedQuery(name = "MedioCnt.findByIdMedio", query = "SELECT m FROM MedioCnt m WHERE m.medioCntPK.idMedio = :idMedio"),
    @NamedQuery(name = "MedioCnt.findByTpMedio", query = "SELECT m FROM MedioCnt m WHERE m.medioCntPK.tpMedio = :tpMedio"),
    @NamedQuery(name = "MedioCnt.findByStMedio", query = "SELECT m FROM MedioCnt m WHERE m.stMedio = :stMedio"),
    @NamedQuery(name = "MedioCnt.findByIdContacto", query = "SELECT m FROM MedioCnt m WHERE m.idContacto = :idContacto")})
public class MedioCnt implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedioCntPK medioCntPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "st_medio")
    private boolean stMedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contacto")
    private int idContacto;

    public MedioCnt() {
    }

    public MedioCnt(MedioCntPK medioCntPK) {
        this.medioCntPK = medioCntPK;
    }

    public MedioCnt(MedioCntPK medioCntPK, boolean stMedio, int idContacto) {
        this.medioCntPK = medioCntPK;
        this.stMedio = stMedio;
        this.idContacto = idContacto;
    }

    public MedioCnt(int idMedio, String tpMedio) {
        this.medioCntPK = new MedioCntPK(idMedio, tpMedio);
    }

    public MedioCntPK getMedioCntPK() {
        return medioCntPK;
    }

    public void setMedioCntPK(MedioCntPK medioCntPK) {
        this.medioCntPK = medioCntPK;
    }

    public boolean getStMedio() {
        return stMedio;
    }

    public void setStMedio(boolean stMedio) {
        this.stMedio = stMedio;
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
        hash += (medioCntPK != null ? medioCntPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioCnt)) {
            return false;
        }
        MedioCnt other = (MedioCnt) object;
        if ((this.medioCntPK == null && other.medioCntPK != null) || (this.medioCntPK != null && !this.medioCntPK.equals(other.medioCntPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.MedioCnt[ medioCntPK=" + medioCntPK + " ]";
    }
    
}
