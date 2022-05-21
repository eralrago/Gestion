/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ferbo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
@Entity
@Table(name = "CONSTANCIA_DEPOSITO_DETALLE")
@NamedQueries({
    @NamedQuery(name = "ConstanciaDepositoDetalle.findAll", query = "SELECT c FROM ConstanciaDepositoDetalle c"),
    @NamedQuery(name = "ConstanciaDepositoDetalle.findByConstanciaDepositoDetalleCve", query = "SELECT c FROM ConstanciaDepositoDetalle c WHERE c.constanciaDepositoDetalleCve = :constanciaDepositoDetalleCve"),
    @NamedQuery(name = "ConstanciaDepositoDetalle.findByServicioCantidad", query = "SELECT c FROM ConstanciaDepositoDetalle c WHERE c.servicioCantidad = :servicioCantidad")})
public class ConstanciaDepositoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSTANCIA_DEPOSITO_DETALLE_CVE")
    private Integer constanciaDepositoDetalleCve;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "servicio_cantidad")
    private BigDecimal servicioCantidad;
    @JoinColumn(name = "FOLIO", referencedColumnName = "FOLIO")
    @ManyToOne(optional = false)
    private ConstanciaDeDeposito folio;
    @JoinColumn(name = "SERVICIO_CVE", referencedColumnName = "SERVICIO_CVE")
    @ManyToOne
    private Servicio servicioCve;

    public ConstanciaDepositoDetalle() {
    }

    public ConstanciaDepositoDetalle(Integer constanciaDepositoDetalleCve) {
        this.constanciaDepositoDetalleCve = constanciaDepositoDetalleCve;
    }

    public Integer getConstanciaDepositoDetalleCve() {
        return constanciaDepositoDetalleCve;
    }

    public void setConstanciaDepositoDetalleCve(Integer constanciaDepositoDetalleCve) {
        this.constanciaDepositoDetalleCve = constanciaDepositoDetalleCve;
    }

    public BigDecimal getServicioCantidad() {
        return servicioCantidad;
    }

    public void setServicioCantidad(BigDecimal servicioCantidad) {
        this.servicioCantidad = servicioCantidad;
    }

    public ConstanciaDeDeposito getFolio() {
        return folio;
    }

    public void setFolio(ConstanciaDeDeposito folio) {
        this.folio = folio;
    }

    public Servicio getServicioCve() {
        return servicioCve;
    }

    public void setServicioCve(Servicio servicioCve) {
        this.servicioCve = servicioCve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (constanciaDepositoDetalleCve != null ? constanciaDepositoDetalleCve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstanciaDepositoDetalle)) {
            return false;
        }
        ConstanciaDepositoDetalle other = (ConstanciaDepositoDetalle) object;
        if ((this.constanciaDepositoDetalleCve == null && other.constanciaDepositoDetalleCve != null) || (this.constanciaDepositoDetalleCve != null && !this.constanciaDepositoDetalleCve.equals(other.constanciaDepositoDetalleCve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.ConstanciaDepositoDetalle[ constanciaDepositoDetalleCve=" + constanciaDepositoDetalleCve + " ]";
    }
    
}
