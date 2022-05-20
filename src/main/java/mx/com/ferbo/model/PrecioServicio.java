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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "precio_servicio")
@NamedQueries({
    @NamedQuery(name = "PrecioServicio.findAll", query = "SELECT p FROM PrecioServicio p"),
    @NamedQuery(name = "PrecioServicio.findById", query = "SELECT p FROM PrecioServicio p WHERE p.id = :id"),
    @NamedQuery(name = "PrecioServicio.findByUnidad", query = "SELECT p FROM PrecioServicio p WHERE p.unidad = :unidad"),
    @NamedQuery(name = "PrecioServicio.findByPrecio", query = "SELECT p FROM PrecioServicio p WHERE p.precio = :precio")})
public class PrecioServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidad")
    private int unidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "cliente", referencedColumnName = "CTE_CVE")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "servicio", referencedColumnName = "SERVICIO_CVE")
    @ManyToOne(optional = false)
    private Servicio servicio;
    @JoinColumn(name = "aviso_cve", referencedColumnName = "aviso_cve")
    @ManyToOne(optional = false)
    private Aviso avisoCve;

    public PrecioServicio() {
    }

    public PrecioServicio(Integer id) {
        this.id = id;
    }

    public PrecioServicio(Integer id, int unidad, BigDecimal precio) {
        this.id = id;
        this.unidad = unidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Aviso getAvisoCve() {
        return avisoCve;
    }

    public void setAvisoCve(Aviso avisoCve) {
        this.avisoCve = avisoCve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioServicio)) {
            return false;
        }
        PrecioServicio other = (PrecioServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.PrecioServicio[ id=" + id + " ]";
    }
    
}
