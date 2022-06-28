package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.dao.ProductoClienteDAO;
import mx.com.ferbo.dao.ProductoDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.Producto;
import mx.com.ferbo.model.ProductoPorCliente;

@Named
@ViewScoped
public class ProdClienteBean implements Serializable {

	/**
	 * @author Juan_Cervantes
	 */

	private static final long serialVersionUID = -626048119540963939L;

	/**
	 * Objetos para clientes
	 */
	private List<Cliente> lstClientes;
	private Cliente clienteSelected;
	private ClienteDAO clienteDAO;

	/**
	 * Objetos para Productos
	 */
	private List<Producto> listProducto;
	private Producto productoSelected;
	private ProductoDAO productoDAO;

	/**
	 * Objetos para Productos por Cliente
	 */
	private List<ProductoPorCliente> lstProductosClienteFiltered;
	private List<ProductoPorCliente> lstProductosCliente;
	private ProductoPorCliente prodClienteSelected;
	private ProductoClienteDAO productoPorClienteDAO;

	/**
	 * Constructores
	 */

	public ProdClienteBean() {
		clienteDAO = new ClienteDAO();
		productoDAO = new ProductoDAO();
		productoPorClienteDAO = new ProductoClienteDAO();
		lstProductosClienteFiltered = new ArrayList<>();
		lstProductosCliente = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		lstClientes = clienteDAO.buscarTodos();
		lstProductosCliente = productoPorClienteDAO.buscarTodos();
		listProducto = productoDAO.buscarTodos();
	}

	/**
	 * Método para filtrar del listado original por clave de cliente
	 */
	public void filtraListado() {
		lstProductosClienteFiltered.clear();
		lstProductosClienteFiltered = lstProductosCliente.stream()
				.filter(ps -> clienteSelected != null
						? (ps.getCteCve().getCteCve().intValue() == clienteSelected.getCteCve().intValue())
						: false)
				.collect(Collectors.toList());
		System.out.println("Productos Cliente Filtrados:" + lstProductosClienteFiltered.toString());
	}

	/**
	 * Métodos para guardar objeto tipo ProductoCliente
	 */
	public void nuevoProductoCliente() {
		prodClienteSelected = new ProductoPorCliente();
		prodClienteSelected.setCteCve(clienteSelected);
		prodClienteSelected.setProductoCve(new Producto());
	}

	public void guardaProductoCliente() {
		prodClienteSelected.setProdXCteCve(null);
		prodClienteSelected.setProductoCve(productoSelected);
		if (productoPorClienteDAO.guardar(prodClienteSelected) == null) {
			lstProductosClienteFiltered.add(prodClienteSelected);
			lstProductosCliente.add(prodClienteSelected);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado"));
			PrimeFaces.current().ajax().update("form:messages", "form:dt-productosCliente");

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Ocurrió un error al intentar guardar el Producto"));
		}

		prodClienteSelected = new ProductoPorCliente();
		PrimeFaces.current().executeScript("PF('productoClienteDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-productosCliente");

	}

	/**
	 * Método para actualizar objeto tipo ProductoCliente
	 */
	public void actualizaProductoCliente() {
		prodClienteSelected.setCteCve(clienteSelected);
		prodClienteSelected.setProductoCve(productoSelected);
		System.out.println(prodClienteSelected.toString());

		if (productoPorClienteDAO.actualizar(prodClienteSelected) == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Actualizado"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Ocurrió un error al intentar actualizar el Producto"));
		}

		PrimeFaces.current().executeScript("PF('productoClienteActDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-productosCliente");
	}

	/**
	 * Método para eliminar objeto tipo PrecioServicio
	 */

	public void eliminarProductoCliente() {
		if (productoPorClienteDAO.eliminar(prodClienteSelected) == null) {
			lstProductosClienteFiltered.remove(this.prodClienteSelected);
			lstProductosCliente.remove(prodClienteSelected);
			prodClienteSelected = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
			PrimeFaces.current().ajax().update("form:messages", "form:dt-productosCliente");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Ocurrió un error al intentar eliminar el Producto"));
			PrimeFaces.current().ajax().update("form:messages");
		}

	}

	/**
	 * Getters y Setters
	 */
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

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public List<Producto> getListProducto() {
		return listProducto;
	}

	public void setListProducto(List<Producto> listProducto) {
		this.listProducto = listProducto;
	}

	public Producto getProductoSelected() {
		return productoSelected;
	}

	public void setProductoSelected(Producto productoSelected) {
		this.productoSelected = productoSelected;
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public List<ProductoPorCliente> getLstProductosClienteFiltered() {
		return lstProductosClienteFiltered;
	}

	public void setLstProductosClienteFiltered(List<ProductoPorCliente> lstProductosClienteFiltered) {
		this.lstProductosClienteFiltered = lstProductosClienteFiltered;
	}

	public List<ProductoPorCliente> getLstProductosCliente() {
		return lstProductosCliente;
	}

	public void setLstProductosCliente(List<ProductoPorCliente> lstProductosCliente) {
		this.lstProductosCliente = lstProductosCliente;
	}

	public ProductoPorCliente getProdClienteSelected() {
		return prodClienteSelected;
	}

	public void setProdClienteSelected(ProductoPorCliente prodClienteSelected) {
		this.prodClienteSelected = prodClienteSelected;
	}

	public ProductoClienteDAO getProductoPorClienteDAO() {
		return productoPorClienteDAO;
	}

	public void setProductoPorClienteDAO(ProductoClienteDAO productoPorClienteDAO) {
		this.productoPorClienteDAO = productoPorClienteDAO;
	}
}