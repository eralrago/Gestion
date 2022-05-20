package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.dao.ProductoClienteDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.ProductoPorCliente;
import mx.com.ferbo.model.Servicio;
import mx.com.ferbo.model.UnidadDeManejo;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ServiciosClienteBean implements Serializable {

	private static final long serialVersionUID = -5768146106301267486L;

	private List<Cliente> lstClientes;
	private List<UnidadDeManejo> lstUnidadManejo;
	private List<Servicio> lstServicio;
//	TODO:Revisar regla de negocio en la base de datos
//	private List<PrecioServicio> lstPrecioServicio;

	private Cliente clienteSelected;

	private ClienteDAO clienteDAO;

	public ServiciosClienteBean() {
		clienteDAO = new ClienteDAO();
	}

	@PostConstruct
	public void init() {
		lstClientes = clienteDAO.buscarTodos();
	}
	
	public void filtaListado() {
		
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

	public Cliente getClienteSelected() {
		return clienteSelected;
	}

	public void setClienteSelected(Cliente clienteSelected) {
		this.clienteSelected = clienteSelected;
	}

	
	
	

}
