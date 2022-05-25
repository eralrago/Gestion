package mx.com.ferbo.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import mx.com.ferbo.dao.BancoDAO;
import mx.com.ferbo.model.Bancos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class BancosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Bancos> listaBancos;

	private List<Bancos> listaBancosSelected;

	private Bancos bancoSelect;

	private BancoDAO bancoDao;

	/**
	 * Se inicializan las variables
	 */
	public BancosBean() {
		bancoDao = new BancoDAO();
		listaBancosSelected = new ArrayList<>();
	}

	/**
	 * En caso de ser necesario se asignan datos
	 */
	@PostConstruct
	public void init() {
		listaBancos = bancoDao.buscarTodos();
	}

	public void nuevoBanco() {
		this.bancoSelect = new Bancos();
	}

	public void guardarBanco() {
		if (this.bancoSelect.getId() == null) {
			if (bancoDao.guardar(bancoSelect) == null) {
				this.listaBancos.add(this.bancoSelect);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Banco Agregado"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ocurrió un error al intentar guardar el Banco"));
			}
		} else {
			if (bancoDao.actualizar(bancoSelect) == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Banco Actualizado"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ocurrió un error al intentar actualizar el Banco"));
			}
		}
		PrimeFaces.current().executeScript("PF('nuevoBancoDialog').hide()");
		PrimeFaces.current().ajax().update("form");
	}

	public void eliminandoBanco() {
		if (bancoDao.eliminar(bancoSelect) == null) {
			this.listaBancos.remove(this.bancoSelect);
//			this.listaBancos = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Banco Eliminado"));
			PrimeFaces.current().ajax().update("form:messages", "form:dt-bancos");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Ocurrió un error al intentar eliminar el Banco"));
		}
		PrimeFaces.current().executeScript("PF('deleteBancosDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages");
	}

	public List<Bancos> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<Bancos> listaBancos) {
		this.listaBancos = listaBancos;
	}

	public List<Bancos> getListaBancosSelected() {
		return listaBancosSelected;
	}

	public void setListaBancosSelected(List<Bancos> listaBancosSelected) {
		this.listaBancosSelected = listaBancosSelected;
	}

	public Bancos getBancoSelect() {
		return bancoSelect;
	}

	public void setBancoSelect(Bancos bancoSelect) {
		this.bancoSelect = bancoSelect;
	}

}
