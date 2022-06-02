package mx.com.ferbo.controller;

import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import mx.com.ferbo.dao.CamaraDAO;
import mx.com.ferbo.dao.PlantaDAO;
import mx.com.ferbo.dao.PosicionCamaraDAO;
import mx.com.ferbo.model.Camara;
import mx.com.ferbo.model.Planta;
import mx.com.ferbo.model.Posicion;

@Named
@ViewScoped
public class PosicionCamaraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PosicionCamaraDAO result;
	private List<Posicion> posiciones;
	private Posicion selectPosicion;
	
	private List<Planta> plantas;
	private PlantaDAO plantasDao;
	private CamaraDAO camaraDao;
	private List<Camara> camaras;
	private Camara camaraSelect;
	private Planta plantaSelect;
	private List<Camara> camaraPorPlanta;
	private List<Posicion> listaPosiciones;
	
	
	public PosicionCamaraBean() {
		plantasDao = new PlantaDAO();
		camaraDao = new CamaraDAO();
		result = new PosicionCamaraDAO();
		this.posiciones = result.findAll();
		plantas = plantasDao.findall();
		camaras = camaraDao.buscarTodos();
		camaraPorPlanta = new ArrayList<Camara>();
		listaPosiciones = new ArrayList<Posicion>();
	}
	
	public void filtraListado() {
		camaraPorPlanta.clear();
		camaraPorPlanta = camaras.stream()
				.filter(ps -> plantaSelect != null
						? (ps.getPlantaCve().getPlantaCve().intValue() == plantaSelect.getPlantaCve().intValue())
						: false)
				.collect(Collectors.toList());
		System.out.println("Productos Cliente Filtrados:" + camaraPorPlanta.toString());
	}
	
	public void filtrarPosiciones() {
		listaPosiciones.clear();
		listaPosiciones = posiciones.stream()
				.filter(cs -> camaraSelect != null
				? (cs.getIdCamara() == camaraSelect.getCamaraCve())
				: false)
		.collect(Collectors.toList()); 
		
		PrimeFaces.current().ajax().update("form:dt-posiciones");
	}

	
	
	
	public List<Posicion> getListaPosiciones() {
		return listaPosiciones;
	}

	public void setListaPosiciones(List<Posicion> listaPosiciones) {
		this.listaPosiciones = listaPosiciones;
	}

	public List<Camara> getCamaraPorPlanta() {
		return camaraPorPlanta;
	}

	public void setCamaraPorPlanta(List<Camara> camaraPorPlanta) {
		this.camaraPorPlanta = camaraPorPlanta;
	}
		

	public PlantaDAO getPlantasDao() {
		return plantasDao;
	}

	public void setPlantasDao(PlantaDAO plantasDao) {
		this.plantasDao = plantasDao;
	}

	public CamaraDAO getCamaraDao() {
		return camaraDao;
	}

	public void setCamaraDao(CamaraDAO camaraDao) {
		this.camaraDao = camaraDao;
	}

	public List<Planta> getPlantas() {
		return plantas;
	}


	public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}


	public List<Camara> getCamaras() {
		return camaras;
	}


	public void setCamaras(List<Camara> camaras) {
		this.camaras = camaras;
	}


	public Camara getCamaraSelect() {
		return camaraSelect;
	}


	public void setCamaraSelect(Camara camaraSelect) {
		this.camaraSelect = camaraSelect;
	}


	public Planta getPlantaSelect() {
		return plantaSelect;
	}


	public void setPlantaSelect(Planta plantaSelect) {
		this.plantaSelect = plantaSelect;
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
