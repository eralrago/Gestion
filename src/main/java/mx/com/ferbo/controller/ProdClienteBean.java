package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.dao.PrecioServicioDAO;
import mx.com.ferbo.dao.ProductoClienteDAO;
import mx.com.ferbo.dao.ProductoDAO;
import mx.com.ferbo.dao.ServicioDAO;
import mx.com.ferbo.dao.UnidadManejoDAO;
import mx.com.ferbo.model.Aviso;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.PrecioServicio;
import mx.com.ferbo.model.Producto;
import mx.com.ferbo.model.ProductoPorCliente;
import mx.com.ferbo.model.Servicio;
import mx.com.ferbo.model.UnidadDeManejo;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class ProdClienteBean implements Serializable {


	/**
	 * @author Juan Cervantes
	 */
	
	private static final long serialVersionUID = -626048119540963939L;
	
	//Objetos para clientes
	private List<Cliente> lstClientes;
	private Cliente clienteSelected;
	private ClienteDAO clienteDAO;
	
	//Objetos para Productos
	private List<Producto> listProducto;
	private Producto productoSelected;
	private ProductoDAO productoDAO;
	private List<Producto> listProductoFiltered;
	
	//Objetos para Productos por cliente
	private List<ProductoPorCliente> lstProductosClienteFiltered;
	private List<ProductoPorCliente> lstProductosCliente;
	private List<ProductoPorCliente> lstProdPorCliente;
	private ProductoPorCliente prodClienteSelected;
	private ProductoClienteDAO productoPorClienteDAO;
	
	

	public ProdClienteBean() {
		clienteDAO = new ClienteDAO();
		productoDAO = new ProductoDAO();
		productoPorClienteDAO = new ProductoClienteDAO();
		lstProductosClienteFiltered = new ArrayList<>();
		lstProductosCliente = new ArrayList<>();
		listProductoFiltered = new ArrayList<>();
		lstProdPorCliente = new ArrayList<>();
		
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
		listProductoFiltered.clear();
		lstProductosClienteFiltered = lstProductosCliente.stream()
				.filter(ps -> clienteSelected != null
						? (ps.getCteCve().getCteCve().intValue() == clienteSelected.getCteCve().intValue())
						: false)
				.collect(Collectors.toList());
		System.out.println(lstProductosClienteFiltered.toString());
		
		for(int indProd=0; indProd<listProducto.size();indProd++) {
			for(int indProdClien = 0; indProdClien< lstProductosClienteFiltered.size(); indProdClien++) {
				if(lstProductosClienteFiltered.get(indProdClien).getProductoCve()==listProducto.get(indProd).getProductoCve()) {
					listProductoFiltered.add(listProducto.get(indProd));
				}
			}
		}
		
		System.out.println(listProductoFiltered.toString());		
		}

	/**
	 * Método para filtrar del listado original por clave de cliente
	 */
	public void nuevoProductoCliente() {		
		prodClienteSelected = new ProductoPorCliente();
		prodClienteSelected.setCteCve(clienteSelected);
		prodClienteSelected.setProductoCve(0);
	}

	/**
	 * Método para guardar objeto tipo ProductoCliente
	 */
	
	public void guardaProductoCliente() {		
		if (prodClienteSelected.getProdXCteCve() == null) {
			prodClienteSelected.setCteCve(clienteSelected);
			prodClienteSelected.setProductoCve(productoSelected.getProductoCve());
			if (productoPorClienteDAO.guardar(prodClienteSelected) == null) {
				lstProductosClienteFiltered.add(prodClienteSelected);
				lstProductosCliente.add(prodClienteSelected);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado"));
				PrimeFaces.current().ajax().update("form:messages", "form:dt-productosCliente");

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Ocurrió un error al intentar guardar el Producto"));
			}
		}
		PrimeFaces.current().executeScript("PF('productoClienteDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-productosCliente");
	}
	
	/**
	 * Método para actualizar objeto tipo ProductoCliente
	 */	
	public void actualizaProductoCliente() {
		prodClienteSelected.getProdXCteCve();
		prodClienteSelected.setCteCve(clienteSelected);
		prodClienteSelected.setProductoCve(productoSelected.getProductoCve());
		System.out.println(		prodClienteSelected.getProdXCteCve());
		
		if (productoPorClienteDAO.actualizar(prodClienteSelected) == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Actualizado"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error", "Ocurrió un error al intentar actualizar el Producto"));
		}	
		
		PrimeFaces.current().executeScript("PF('productoClienteActDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-productosCliente");
	}
	
	

	/**
	 * Método para eliminar objeto tipo PrecioServicio
	 */
	public void eliminarPrecioServicio() {
		if (productoPorClienteDAO.eliminar(prodClienteSelected) == null) {
			lstProductosClienteFiltered.remove(this.prodClienteSelected);
			lstProductosCliente.remove(prodClienteSelected);
			prodClienteSelected = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Servicio Eliminado"));
			PrimeFaces.current().ajax().update("form:messages", "form:dt-servicios");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Ocurrió un error al intentar eliminar el Servicio"));
			PrimeFaces.current().ajax().update("form:messages");
		}
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

	public List<ProductoPorCliente> getLstProductosCliente() {
		return lstProductosCliente;
	}

	public void setLstProductosCliente(List<ProductoPorCliente> lstProductosCliente) {
		this.lstProductosCliente = lstProductosCliente;
	}

	public List<Producto> getlistProductoFiltered() {
		return listProductoFiltered;
	}

	public void setlistProductoFiltered(List<Producto> listProductoFiltered) {
		this.listProductoFiltered = listProductoFiltered;
	}

	public List<Producto> getListProductoFiltered() {
		return listProductoFiltered;
	}

	public void setListProductoFiltered(List<Producto> listProductoFiltered) {
		this.listProductoFiltered = listProductoFiltered;
	}

	public List<ProductoPorCliente> getLstProdPorCliente() {
		return lstProdPorCliente;
	}

	public void setLstProdPorCliente(List<ProductoPorCliente> lstProdPorCliente) {
		this.lstProdPorCliente = lstProdPorCliente;
	}
	
	
	
	

}
