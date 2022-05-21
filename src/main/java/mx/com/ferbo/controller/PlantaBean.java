package mx.com.ferbo.controller;

import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import mx.com.ferbo.dao.PlantaDAO;
import mx.com.ferbo.model.Planta;

@Named
@ViewScoped
public class PlantaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PlantaDAO result;
	private List<Planta> principal;
	private Planta selectPlanta;

	public Planta getSelectPlanta() {
		return selectPlanta;
	}

	public void setSelectPlanta(Planta selectPlanta) {
		this.selectPlanta = selectPlanta;
	}
	
	public void RowSelected(int id) {
		this.selectPlanta = result.findOne(id);
	}

	public PlantaBean() {
		this.result = new PlantaDAO();
		principal = result.findall();
	}

	public List<Planta> getAll() {
		return result.findall();
	}

	public Planta getOne(int id) {
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
	}
}
