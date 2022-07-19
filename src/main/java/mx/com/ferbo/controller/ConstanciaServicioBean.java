package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.model.Cliente;

@Named
@ViewScoped
public class ConstanciaServicioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Cliente> listaClientes;
	
	private ClienteDAO clienteDao;
	
	private int idCliente;
	
	public ConstanciaServicioBean() {
		clienteDao = new ClienteDAO();
		listaClientes = new ArrayList<>();
	}
	
	@PostConstruct
	public void init() {
		listaClientes = clienteDao.buscarTodos();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	
	
	
}
