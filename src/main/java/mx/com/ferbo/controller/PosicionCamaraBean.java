package mx.com.ferbo.controller;

import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.ferbo.dao.PosicionCamaraDAO;
import mx.com.ferbo.model.Posicion;

@Named
@ViewScoped
public class PosicionCamaraBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1407228410828190333L;
	
	private PosicionCamaraDAO dataPosicion;
	private List<Posicion> posiciones;
	
	public List<Posicion> getAll(){
		return dataPosicion.findAllPlantas();
	}
	
	
	
	public PosicionCamaraDAO getDataPosicion() {
		return dataPosicion;
	}
	public void setDataPosicion(PosicionCamaraDAO dataPosicion) {
		this.dataPosicion = dataPosicion;
	}
	public List<Posicion> getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(List<Posicion> posiciones) {
		this.posiciones = posiciones;
	}
	
	

}
