package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.ferbo.dao.PaisesDAO;
import mx.com.ferbo.model.Estados;
import mx.com.ferbo.model.Municipios;
import mx.com.ferbo.model.Paises;

@Named
@ViewScoped
public class LocalizacionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Paises> listaPaises;
	
	private PaisesDAO paisesDao;
	
	public LocalizacionBean() {
		paisesDao = new PaisesDAO();
		listaPaises = new ArrayList<>();
	}
	
	@PostConstruct
	public void init() {
		listaPaises = paisesDao.buscarTodos();
	}

	public List<Paises> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<Paises> listaPaises) {
		this.listaPaises = listaPaises;
	}

	public PaisesDAO getPaisesDao() {
		return paisesDao;
	}

	public void setPaisesDao(PaisesDAO paisesDao) {
		this.paisesDao = paisesDao;
	}
	
	
}
