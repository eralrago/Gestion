package mx.com.ferbo.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import mx.com.ferbo.dao.chequesDevueltosDAO;
import mx.com.ferbo.dao.notaCreditoDAO;
import mx.com.ferbo.model.ChequeDevuelto;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.NotaCredito;

@Named
@ViewScoped
public class notaCreditoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private notaCreditoDAO result;
	private List<NotaCredito> notasCredito;
	private Cliente notaClienteSelect;
	
	


	public notaCreditoBean() {
		result = new notaCreditoDAO();
		this.notasCredito = result.findAll();
	}


	public List<NotaCredito> findAll() {
		return result.findAll();
	}


	public notaCreditoDAO getResult() {
		return result;
	}


	public void setResult(notaCreditoDAO result) {
		this.result = result;
	}


	public List<NotaCredito> getNotasCredito() {
		return notasCredito;
	}


	public void setNotasCredito(List<NotaCredito> notasCredito) {
		this.notasCredito = notasCredito;
	}


	public Cliente getNotaClienteSelect() {
		return notaClienteSelect;
	}


	public void setNotaClienteSelect(Cliente notaClienteSelect) {
		this.notaClienteSelect = notaClienteSelect;
	}
	
	

	

	
	
	




	


	
}
