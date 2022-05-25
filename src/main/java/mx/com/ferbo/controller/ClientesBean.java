package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.ferbo.dao.ClienteContactoDAO;
import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.ClienteContacto;
import mx.com.ferbo.model.Contacto;

@Named
@ViewScoped
public class ClientesBean implements Serializable {

	private static final long serialVersionUID = 8438449261015571241L;

	private List<Cliente> lstClientes;
	private List<Cliente> lstClientesSelected;
	private List<ClienteContacto> lstClienteContactoSelected;

	private Cliente clienteSelected;
	private ClienteContacto clienteContactoSelected;
	private Contacto contactoSelected;

	private ClienteDAO clienteDAO;
	private ClienteContactoDAO clienteContactoDAO;

	public ClientesBean() {
		lstClienteContactoSelected = new ArrayList<>();
		lstClientesSelected = new ArrayList<>();
		clienteDAO = new ClienteDAO();
		clienteContactoDAO = new ClienteContactoDAO();
	}

	@PostConstruct
	public void init() {
		lstClientes = clienteDAO.buscarTodos();
	}

	/**
	 * Método para consultar mensaje de eliminación para botón eliminar varios
	 */
	public String getConsultaMensajeBtn() {
		if (clienteSeleccionado()) {
			int size = this.lstClientesSelected.size();
			return size > 1 ? size + " clientes seleccionados" : "1 cliente seleccionado";
		}

		return "Eliminar";
	}

	/**
	 * Método para validar si se ha seleccionado uno o varios objetos tipo Cliente
	 */
	public boolean clienteSeleccionado() {
		return this.lstClientesSelected != null && !this.lstClientesSelected.isEmpty();
	}
	
	
	public void guardarCliente(){
		
	}
	
	public void guardarContacto() {
		
	}
	
	
	

	/**
	 * Getters & Setters
	 */
	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

	public List<Cliente> getLstClientesSelected() {
		return lstClientesSelected;
	}

	public void setLstClientesSelected(List<Cliente> lstClientesSelected) {
		this.lstClientesSelected = lstClientesSelected;
	}

	public List<ClienteContacto> getLstClienteContactoSelected() {
		return lstClienteContactoSelected;
	}

	public void setLstClienteContactoSelected(List<ClienteContacto> lstClienteContactoSelected) {
		this.lstClienteContactoSelected = lstClienteContactoSelected;
	}

	public Cliente getClienteSelected() {
		return clienteSelected;
	}

	public void setClienteSelected(Cliente clienteSelected) {
		this.clienteSelected = clienteSelected;
	}

	public ClienteContacto getClienteContactoSelected() {
		return clienteContactoSelected;
	}

	public void setClienteContactoSelected(ClienteContacto clienteContactoSelected) {
		this.clienteContactoSelected = clienteContactoSelected;
	}

	public Contacto getContactoSelected() {
		return contactoSelected;
	}

	public void setContactoSelected(Contacto contactoSelected) {
		this.contactoSelected = contactoSelected;
	}

}
