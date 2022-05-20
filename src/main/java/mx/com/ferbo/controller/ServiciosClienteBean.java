package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.List;

import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.dao.ProductoClienteDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.ProductoPorCliente;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ServiciosClienteBean implements Serializable {

	private static final long serialVersionUID = -5768146106301267486L;

	private List<Cliente> lstClientes;
	private List<ProductoPorCliente> lstProductoCliente;

	private ClienteDAO clienteDAO;
	private ProductoClienteDAO productoClienteDAO;

	public ServiciosClienteBean() {
		clienteDAO = new ClienteDAO();
		productoClienteDAO = new ProductoClienteDAO();
	}

	@PostConstruct
	public void init() {
		lstClientes = clienteDAO.buscarTodos();
		lstProductoCliente = productoClienteDAO.buscarTodos();
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

}
