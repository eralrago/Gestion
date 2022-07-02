package mx.com.ferbo.util;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.ferbo.model.ConstanciaDeDeposito;
import mx.com.ferbo.model.DetalleConstanciaSalida;

@Named
@ViewScoped
public class KardexTotalsBean implements Serializable {

	/**
	 * @author Juan_Cervantes
	 */
	private static final long serialVersionUID = 7564968189228115544L;
	
	/**
	 * Objetos para Detalle de Constancia de Salida
	 */
	private DetalleConstanciaSalida detalleSalidaSelected;
	
	/**
	 * Objetos para Constancia Deposito
	 */
	private ConstanciaDeDeposito consDepKardex;
	
	/**
	 * Objetos para totales
	 */
	private Integer cantidadSalida;
	private BigDecimal pesoSalida;
	
	/**
	 * constructor
	 */
	public KardexTotalsBean() {
		detalleSalidaSelected = new DetalleConstanciaSalida();
		consDepKardex = new ConstanciaDeDeposito();
	}
	
	public DetalleConstanciaSalida getDetalleSalidaSelected() {
		return detalleSalidaSelected;
	}
	public void setDetalleSalidaSelected(DetalleConstanciaSalida detalleSalidaSelected) {
		this.detalleSalidaSelected = detalleSalidaSelected;
	}
	public Integer getCantidadSalida() {
		return cantidadSalida;
	}
	public void setCantidadSalida(Integer cantidadSalida) {
		this.cantidadSalida = cantidadSalida;
	}
	public BigDecimal getPesoSalida() {
		return pesoSalida;
	}
	public void setPesoSalida(BigDecimal pesoSalida) {
		this.pesoSalida = pesoSalida;
	}

	public ConstanciaDeDeposito getConsDepKardex() {
		return consDepKardex;
	}

	public void setConsDepKardex(ConstanciaDeDeposito consDepKardex) {
		this.consDepKardex = consDepKardex;
	}		

}