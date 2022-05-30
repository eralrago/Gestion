package mx.com.ferbo.controller;

import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import mx.com.ferbo.dao.PosicionCamaraDAO;
import mx.com.ferbo.model.Posicion;

@Named
@ViewScoped
public class PosicionCamaraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PosicionCamaraDAO result;
	private List<Posicion> posiciones;
	private Posicion selectPosicion;
	
	


	public PosicionCamaraBean() {
		result = new PosicionCamaraDAO();
		this.posiciones = result.findAll();
	}


	public List<Posicion> getAll() {
		return result.findAll();
	}


	public PosicionCamaraDAO getResult() {
		return result;
	}


	public void setResult(PosicionCamaraDAO result) {
		this.result = result;
	}


	public List<Posicion> getPosiciones() {
		return posiciones;
	}


	public void setPosiciones(List<Posicion> posiciones) {
		this.posiciones = posiciones;
	}


	public Posicion getSelectPosicion() {
		return selectPosicion;
	}


	public void setSelectPosicion(Posicion selectPosicion) {
		this.selectPosicion = selectPosicion;
	}


	
	
	
	

	/*public Planta getOne(int id) {
		Planta p = new Planta();
		p = result.findOne(id);

		System.out.println("---------------------------------");
		System.out.println(p.getPlantaDs());

		return p;
	}

	public void deleteOne(Planta p) {
		result.delete(p);
		principal.remove(p);
		// return "/protected/catalogos/plantas.xhtml";
	}

	public List<Planta> getPrincipal() {
		return principal;
	}

	public void setPrincipal(List<Planta> principal) {
		this.principal = principal;
	}*/
}
