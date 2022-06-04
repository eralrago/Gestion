package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.ferbo.dao.SerieFacturaDAO;
import mx.com.ferbo.model.SerieFactura;

@Named
@ViewScoped
public class SerieFacturaBean implements Serializable {

	private static final long serialVersionUID = 1;

	private List<SerieFactura> listSerie;

	private SerieFacturaDAO daoSerie;

	public SerieFacturaBean() {
		daoSerie = new SerieFacturaDAO();
		listSerie = daoSerie.findAll();
	};
	
	public void save() {
		
	};

	public List<SerieFactura> getListSerie() {
		return listSerie;
	};

	public void setListSerie(List<SerieFactura> listSerie) {
		this.listSerie = listSerie;
	};
}
