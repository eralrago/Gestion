package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.model.Cliente;

@Named
@ViewScoped
public class ClientesBean implements Serializable{
	
	private static final long serialVersionUID = 8438449261015571241L;
	
	private List<Cliente> lstClientes;
	
	private ClienteDAO clienteDAO;

	public ClientesBean() {
		clienteDAO = new ClienteDAO();
	}
	
	@PostConstruct
	public void init() {
		lstClientes = clienteDAO.buscarTodos();
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}
	
	

}
