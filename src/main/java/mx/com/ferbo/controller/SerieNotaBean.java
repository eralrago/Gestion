package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import mx.com.ferbo.dao.SerieNotaDAO;
import mx.com.ferbo.model.SerieNota;
import mx.com.ferbo.model.StatusSerie;

@Named
@ViewScoped
public class SerieNotaBean implements Serializable {

	private static final long serialVersionUID = 1;

	private List<SerieNota> listSerie;
	private List<StatusSerie> status;

	private SerieNota nuevo;
	private SerieNota seleccion;

	private SerieNotaDAO daoSerie;

	public SerieNotaBean() {
		daoSerie = new SerieNotaDAO();
		listSerie = daoSerie.findAll();
		status = daoSerie.findStatus();
		seleccion = new SerieNota();
	};

	public void openNew() {
		nuevo = new SerieNota();
	};

	public void save() {
		PrimeFaces.current().executeScript("PF('dg-agrega').hide()");
		String message = daoSerie.save(nuevo);

		if (message == null) {
			listSerie.clear();
			listSerie = daoSerie.findAll();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Serie Factura Agregada ", null));
			PrimeFaces.current().ajax().update("form:messages", "form:dtSerieFac");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar serie", message));
			PrimeFaces.current().ajax().update("form:messages");
		}
		nuevo = new SerieNota();
	};

	public void update() {
		PrimeFaces.current().executeScript("PF('dg-modifica').hide()");
		String message = daoSerie.update(seleccion);

		if (message == null) {
			listSerie.clear();
			listSerie = daoSerie.findAll();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Serie Modificada", null));
			PrimeFaces.current().ajax().update("form:messages", "form:dtSerieFac");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar", message));
			PrimeFaces.current().ajax().update("form:messages");
		}
		this.seleccion = new SerieNota();
	};

	public void cancelar() {
		PrimeFaces.current().executeScript("PF('dg-delete').hide()");
		String message = daoSerie.cancelar(seleccion.getId());

		if (message == null) {
			listSerie.clear();
			listSerie = daoSerie.findAll();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Serie Cancelada", null));
			PrimeFaces.current().ajax().update("form:messages", "form:dtSerieFac");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al cancelar", message));
			PrimeFaces.current().ajax().update("form:messages");
		}
		this.seleccion = new SerieNota();
	};

	public List<SerieNota> getListSerie() {
		return listSerie;
	};

	public void setListSerie(List<SerieNota> listSerie) {
		this.listSerie = listSerie;
	};

	public SerieNota getNuevo() {
		return nuevo;
	};

	public void setNuevo(SerieNota nuevo) {
		this.nuevo = nuevo;
	};

	public List<StatusSerie> getStatus() {
		return status;
	};

	public SerieNota getSeleccion() {
		return seleccion;
	};

	public void setSeleccion(SerieNota seleccion) {
		this.seleccion = seleccion;
	};

}
