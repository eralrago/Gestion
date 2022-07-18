package mx.com.ferbo.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import mx.com.ferbo.dao.EntidadPostalDAO;
import mx.com.ferbo.model.EntidadPostal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class EntidadPostalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EntidadPostal> listaEntidadPostal;

	private List<EntidadPostal> listaEntidadPostalSelected;

	private EntidadPostal entidadPostalSelect;

	private EntidadPostalDAO entidadPostalDAO;

	/**
	 * Se inicializan las variables
	 */
	public EntidadPostalBean() {
		entidadPostalDAO = new EntidadPostalDAO();
		listaEntidadPostalSelected = new ArrayList<>();
	}

	/**
	 * En caso de ser necesario se asignan datos
	 */
	@PostConstruct
	public void init() {
		listaEntidadPostal = entidadPostalDAO.buscarTodos();
	}

	public void nuevoEntidadPostal() {
		this.entidadPostalSelect = new EntidadPostal();
	}

	public void guardarEntidadPostal() {
		if (this.entidadPostalSelect.getEntidadpostalCve() == null) {
			List<EntidadPostal> listaTmpEntidadPostal = entidadPostalDAO.buscarTodos();
			int tamanioListaEntidadPostal = listaTmpEntidadPostal.size();
			entidadPostalSelect.setEntidadpostalCve(tamanioListaEntidadPostal);
			if (entidadPostalDAO.guardar(entidadPostalSelect) == null) {
				this.listaEntidadPostal.add(this.entidadPostalSelect);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entidad Postal Agregado"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ocurrió un error al intentar guardar la Entidad Postal"));
			}
		} else {
			if (entidadPostalDAO.actualizar(entidadPostalSelect) == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entidad Postal Actualizado"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ocurrió un error al intentar actualizar la Entidad Postal"));
			}
		}
		PrimeFaces.current().executeScript("PF('nuevoEntidadPostalDialog').hide()");
		PrimeFaces.current().ajax().update("form");
	}

	public void eliminandoEntidadPostal() {
		if (entidadPostalDAO.eliminar(entidadPostalSelect) == null) {
			this.listaEntidadPostal.remove(this.entidadPostalSelect);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de Asentamiento Eliminado"));
			PrimeFaces.current().ajax().update("form:messages", "form:dt-EntidadPostal");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Ocurrió un error al intentar eliminar el Tipo de Asentamiento"));
		}
		PrimeFaces.current().executeScript("PF('deleteEntidadPostalDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages");
	}

	public List<EntidadPostal> getListaEntidadPostal() {
		return listaEntidadPostal;
	}

	public void setListaEntidadPostal(List<EntidadPostal> listaEntidadPostal) {
		this.listaEntidadPostal = listaEntidadPostal;
	}

	public List<EntidadPostal> getListaEntidadPostalSelected() {
		return listaEntidadPostalSelected;
	}

	public void setListaEntidadPostalSelected(List<EntidadPostal> listaEntidadPostalSelected) {
		this.listaEntidadPostalSelected = listaEntidadPostalSelected;
	}

	public EntidadPostal getEntidadPostalSelect() {
		return entidadPostalSelect;
	}

	public void setEntidadPostalSelect(EntidadPostal entidadPostalSelect) {
		this.entidadPostalSelect = entidadPostalSelect;
	}

}
