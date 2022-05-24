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

@Named(value = "mbBanco")
@ViewScoped
public class BancosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Bancos> listaBancos;
	private List<Bancos> listaBancosSelected;
	private Bancos bancoSelect;
	private Bancos bancoModificate;
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
    
    public void modificandoBanco() {
//    	Bancos bancoModificado = new Bancos();
    	Integer idBancoModificado = this.bancoModificate.getId();
    	System.out.println(idBancoModificado);
    }
    
    public void guardarBanco() {
    	if(this.bancoSelect.getId() == null) {
    		if(bancoDao.guardar(bancoSelect) == null) {
    			this.listaBancos.add(this.bancoSelect);
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Banco Agregado"));
    		} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ocurrió un error al intentar guardar el Banco"));
			}
    		PrimeFaces.current().executeScript("PF('nuevoBancoDialog').hide()");
    	} else {
			if (bancoDao.actualizar(bancoSelect) == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Banco Actualizado"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ocurrió un error al intentar actualizar el Banco"));
			}
			PrimeFaces.current().executeScript("PF('modificarBancoDialog').hide()");
		}
    	PrimeFaces.current().ajax().update("form");
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

	public Bancos getBancoModificate() {
		return bancoModificate;
	}

	public void setBancoModificate(Bancos bancoModificate) {
		this.bancoModificate = bancoModificate;
	}
    
}
