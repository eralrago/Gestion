package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.dao.PrecioServicioDAO;
import mx.com.ferbo.dao.ServicioDAO;
import mx.com.ferbo.dao.UnidadManejoDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.PrecioServicio;
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
	private List<PrecioServicio> lstPrecioServicio;
	private List<PrecioServicio> lstPrecioServicioFiltered;

	private Cliente clienteSelected;

	private ClienteDAO clienteDAO;
	private UnidadManejoDAO unidadManejoDAO;
	private ServicioDAO servicioDAO;
	private PrecioServicioDAO precioServicioDAO;

	public ServiciosClienteBean() {
		clienteDAO = new ClienteDAO();
		unidadManejoDAO = new UnidadManejoDAO();
		servicioDAO = new ServicioDAO();
		precioServicioDAO = new PrecioServicioDAO();
		lstPrecioServicioFiltered = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		lstClientes = clienteDAO.buscarTodos();
		lstUnidadManejo = unidadManejoDAO.buscarTodos();
		lstServicio = servicioDAO.buscarTodos();
		lstPrecioServicio = precioServicioDAO.buscarTodos();
	}

	public void filtaListado() {
		lstPrecioServicioFiltered = lstPrecioServicio.stream()
				.filter(ps -> clienteSelected != null
						? (ps.getCliente().getCteCve().intValue() == clienteSelected.getCteCve().intValue())
						: false)
				.collect(Collectors.toList());
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

	public List<UnidadDeManejo> getLstUnidadManejo() {
		return lstUnidadManejo;
	}

	public void setLstUnidadManejo(List<UnidadDeManejo> lstUnidadManejo) {
		this.lstUnidadManejo = lstUnidadManejo;
	}

	public List<Servicio> getLstServicio() {
		return lstServicio;
	}

	public void setLstServicio(List<Servicio> lstServicio) {
		this.lstServicio = lstServicio;
	}

	public List<PrecioServicio> getLstPrecioServicioFiltered() {
		return lstPrecioServicioFiltered;
	}

	public void setLstPrecioServicioFiltered(List<PrecioServicio> lstPrecioServicioFiltered) {
		this.lstPrecioServicioFiltered = lstPrecioServicioFiltered;
	}

}
