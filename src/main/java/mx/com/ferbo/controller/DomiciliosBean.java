package mx.com.ferbo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.com.ferbo.dao.AsentamientoHumanoDAO;
import mx.com.ferbo.dao.CiudadesDAO;
import mx.com.ferbo.dao.ClienteDAO;
import mx.com.ferbo.dao.ClienteDomiciliosDAO;
import mx.com.ferbo.dao.DomiciliosDAO;
import mx.com.ferbo.dao.EstadosDAO;
import mx.com.ferbo.dao.MunicipiosDAO;
import mx.com.ferbo.dao.PaisesDAO;
import mx.com.ferbo.dao.PrecioServicioDAO;
import mx.com.ferbo.dao.ProductoClienteDAO;
import mx.com.ferbo.dao.ProductoDAO;
import mx.com.ferbo.dao.ServicioDAO;
import mx.com.ferbo.dao.TiposDomicilioDAO;
import mx.com.ferbo.dao.UnidadManejoDAO;
import mx.com.ferbo.model.AsentamientoHumano;
import mx.com.ferbo.model.Aviso;
import mx.com.ferbo.model.Ciudades;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.ClienteDomicilios;
import mx.com.ferbo.model.Domicilios;
import mx.com.ferbo.model.Estados;
import mx.com.ferbo.model.Municipios;
import mx.com.ferbo.model.Paises;
import mx.com.ferbo.model.PrecioServicio;
import mx.com.ferbo.model.Producto;
import mx.com.ferbo.model.ProductoPorCliente;
import mx.com.ferbo.model.Servicio;
import mx.com.ferbo.model.TiposDomicilio;
import mx.com.ferbo.model.UnidadDeManejo;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class DomiciliosBean implements Serializable {

	/**
	 * @author Juan_Cervantes
	 */

	private static final long serialVersionUID = 4150584435387992139L;


	/**
	 * Objetos para clientes
	 */
	private List<Cliente> lstClientes;
	private Cliente clienteSelected;
	private ClienteDAO clienteDAO;
	
	/**
	 * Objetos para domicilio_cliente
	 */
	private List<ClienteDomicilios> lstClienteDomicilios;
	private List<ClienteDomicilios> lstClienteDomiciliosFiltered;
	private ClienteDomicilios clienteDomicilioSelected;
	private ClienteDomiciliosDAO clienteDomiciliosDAO;
		
	/**
	 * Objetos para tipos_domicilio
	 */
	private List<TiposDomicilio> lstTiposDomicilio;
	private TiposDomicilio tipoDomicilioSelected;
	private TiposDomicilioDAO tiposDomicilioDAO;
	
	/**
	 * Objetos para domicilio
	 */
	private List<Domicilios> lstDomicilios;
	private List<Domicilios> lstDomiciliosFiltered;
	private Domicilios domicilioSelected;
	private DomiciliosDAO domiciliosDAO;
	
	/**
	 * Objetos para Paises
	 */
	private List<Paises> lstPaises;
	private List<Paises> lstPaisesFiltered;
	private Paises paisSelected;
	private PaisesDAO paisesDAO;
	
	/**
	 * Objetos para Estados
	 */	
	private List<Estados> lstEstados;
	private List<Estados> lstEstadosFiltered;
	private Estados estadoSelected;
	private EstadosDAO estadosDAO;
	
	/**
	 * Objetos para Municipios
	 */
	private List<Municipios> lstMunicipios;
	private List<Municipios> lstMunicipiosFiltered;
	private Municipios municipioSelected;
	private MunicipiosDAO municipiosDAO;
	
	/**
	 * Objetos para Ciudades
	 */
	private List<Ciudades> lstCiudades;
	private List<Ciudades> lstCiudadesFiltered;
	private Ciudades ciudadSelected;
	private CiudadesDAO ciudadesDAO;
	
	/**
	 * Objetos para Asentamiento Humano
	 */
	private List<AsentamientoHumano> lstAsentamientoHumano;
	private List<AsentamientoHumano> lstAsentamientoHumanoFiltered;
	private AsentamientoHumano asentamientoHumanoSelected;
	private AsentamientoHumanoDAO asentamientoHumanoDAO;
	
	/**
	 * Constructores
	 */

	public DomiciliosBean() {
		clienteDAO = new ClienteDAO();
		tiposDomicilioDAO = new TiposDomicilioDAO();
		clienteDomiciliosDAO = new ClienteDomiciliosDAO();
		domiciliosDAO = new DomiciliosDAO();
		paisesDAO = new PaisesDAO();
		estadosDAO = new EstadosDAO();
		municipiosDAO = new MunicipiosDAO();
		ciudadesDAO = new CiudadesDAO();
		asentamientoHumanoDAO = new AsentamientoHumanoDAO();
		lstClienteDomiciliosFiltered = new ArrayList<>();
		lstDomiciliosFiltered = new ArrayList<>();
		lstPaisesFiltered = new ArrayList<>();
		lstEstadosFiltered = new ArrayList<>();
		lstMunicipiosFiltered = new ArrayList<>();
		lstCiudadesFiltered = new ArrayList<>();
		lstAsentamientoHumanoFiltered = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		lstClientes = clienteDAO.buscarTodos();
		lstTiposDomicilio = tiposDomicilioDAO.buscarTodos();
		lstClienteDomicilios = clienteDomiciliosDAO.buscarTodos();
		lstDomicilios = domiciliosDAO.buscarTodos();
		lstPaises = paisesDAO.buscarTodos();
		lstEstados = new ArrayList<>();
		lstMunicipios = new ArrayList<>();
		lstCiudades = new ArrayList<>();
		lstAsentamientoHumano = new ArrayList<>();
	}

	/**
	 * Método para filtrar del listado original por clave de cliente
	 */
	public void filtraListado() {
		lstClienteDomiciliosFiltered.clear();
		lstClienteDomiciliosFiltered = lstClienteDomicilios.stream()
				.filter(ps -> clienteSelected != null
						? (ps.getCteCve().getCteCve().intValue() == clienteSelected.getCteCve().intValue())
						: false)
				.collect(Collectors.toList());
		System.out.println("Productos Cliente Filtrados:" + lstClienteDomiciliosFiltered.toString());
	}
	
	/**
	 * Método para filtrar del listado original de paises por paiscve
	 */
	public void filtraListadoPaises() {
		lstPaisesFiltered.clear();
		lstPaisesFiltered = lstPaises.stream()
				.filter(pa -> paisSelected != null
				? (pa.getPaisCve().intValue() == paisSelected.getPaisCve().intValue())
						: false)
				.collect(Collectors.toList());
	}
	/**
	 * Método para filtrar del listado original de estados por paisCve
	 */
	public void filtraListadoEstados() {
		Estados estadoAux = new Estados();
		estadoAux.setPaises(paisSelected);
		lstEstados = estadosDAO.buscarPorCriterios(estadoAux);
		lstEstadosFiltered.clear();
		lstEstadosFiltered = lstEstados.stream()
				.filter(es -> paisSelected != null
				? (es.getPaises().getPaisCve() == paisSelected.getPaisCve().intValue())
						: false)
				.collect(Collectors.toList());
	}
	/**
	 * Método para filtrar del listado original de municipios por estadoCve
	 */
	public void filtraListadoMunicipios() {
		lstMunicipios = municipiosDAO.buscarPorCriterios(municipioSelected);
		lstMunicipiosFiltered.clear();
		lstMunicipiosFiltered = lstMunicipios.stream()
				.filter(es -> estadoSelected != null
				? (es.getEstados().getEstadosPK().getEstadoCve() == estadoSelected.getEstadosPK().getEstadoCve())
						: false)
				.collect(Collectors.toList());
	}
	/**
	 * Método para filtrar del listado original de ciudades por municipioCve
	 */
	public void filtraListadoCiudades() {
		lstCiudades = ciudadesDAO.buscarPorCriterios(ciudadSelected);
		lstCiudadesFiltered.clear();
		lstCiudadesFiltered = lstCiudades.stream()
				.filter(mu -> municipioSelected != null
				? (mu.getMunicipios().getMunicipiosPK().getMunicipioCve() == municipioSelected.getMunicipiosPK().getMunicipioCve())
						: false)
				.collect(Collectors.toList());
	}
	/**
	 * Método para filtrar del listado original de asentamientos Humanos por ciudadCve
	 */
	public void filtraListadoAsentamientoHumano() {
		lstAsentamientoHumano = asentamientoHumanoDAO.buscarPorCriterios(asentamientoHumanoSelected);
		lstAsentamientoHumanoFiltered.clear();
		lstAsentamientoHumanoFiltered = lstAsentamientoHumano.stream()
				.filter(ah -> asentamientoHumanoSelected != null
				? (ah.getAsentamientoHumanoPK().getCiudadCve() == asentamientoHumanoSelected.getAsentamientoHumanoPK().getCiudadCve())
						: false)
				.collect(Collectors.toList());
	}

	
	/**
	 * Métodos para guardar objeto tipo ProductoCliente
	 */
public void nuevoClienteDomicilio() {
	clienteDomicilioSelected = new ClienteDomicilios();
	clienteDomicilioSelected.setCteCve(clienteSelected);
	clienteDomicilioSelected.setDomicilios(new Domicilios());
}
public void guardaClienteDomicilio() {
	clienteDomicilioSelected.getDomicilios();
	
}

/*
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
*/
	/**
	 * Método para actualizar objeto tipo ProductoCliente
	 */
/*	public void actualizaProductoCliente() {
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
*/
	/**
	 * Método para eliminar objeto tipo PrecioServicio
	 */

/*	public void eliminarProductoCliente() {
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
*/
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

	public List<TiposDomicilio> getLstTiposDomicilio() {
		return lstTiposDomicilio;
	}

	public void setLstTiposDomicilio(List<TiposDomicilio> lstTiposDomicilio) {
		this.lstTiposDomicilio = lstTiposDomicilio;
	}

	public TiposDomicilio getTipoDomicilioSelected() {
		return tipoDomicilioSelected;
	}

	public void setTipoDomicilioSelected(TiposDomicilio tipoDomicilioSelected) {
		this.tipoDomicilioSelected = tipoDomicilioSelected;
	}

	public TiposDomicilioDAO getTiposDomicilioDAO() {
		return tiposDomicilioDAO;
	}

	public void setTiposDomicilioDAO(TiposDomicilioDAO tiposDomicilioDAO) {
		this.tiposDomicilioDAO = tiposDomicilioDAO;
	}

	public List<ClienteDomicilios> getLstClienteDomicilios() {
		return lstClienteDomicilios;
	}

	public void setLstClienteDomicilios(List<ClienteDomicilios> lstClienteDomicilios) {
		this.lstClienteDomicilios = lstClienteDomicilios;
	}

	public List<ClienteDomicilios> getLstClienteDomiciliosFiltered() {
		return lstClienteDomiciliosFiltered;
	}

	public void setLstClienteDomiciliosFiltered(List<ClienteDomicilios> lstClienteDomiciliosFiltered) {
		this.lstClienteDomiciliosFiltered = lstClienteDomiciliosFiltered;
	}

	public ClienteDomicilios getClienteDomicilioSelected() {
		return clienteDomicilioSelected;
	}

	public void setClienteDomicilioSelected(ClienteDomicilios clienteDomicilioSelected) {
		this.clienteDomicilioSelected = clienteDomicilioSelected;
	}

	public ClienteDomiciliosDAO getClienteDomiciliosDAO() {
		return clienteDomiciliosDAO;
	}

	public void setClienteDomiciliosDAO(ClienteDomiciliosDAO clienteDomiciliosDAO) {
		this.clienteDomiciliosDAO = clienteDomiciliosDAO;
	}

	public List<Domicilios> getLstDomicilios() {
		return lstDomicilios;
	}

	public void setLstDomicilios(List<Domicilios> lstDomicilios) {
		this.lstDomicilios = lstDomicilios;
	}

	public List<Domicilios> getLstDomiciliosFiltered() {
		return lstDomiciliosFiltered;
	}

	public void setLstDomiciliosFiltered(List<Domicilios> lstDomiciliosFiltered) {
		this.lstDomiciliosFiltered = lstDomiciliosFiltered;
	}

	public Domicilios getDomicilioSelected() {
		return domicilioSelected;
	}

	public void setDomicilioSelected(Domicilios domicilioSelected) {
		this.domicilioSelected = domicilioSelected;
	}

	public DomiciliosDAO getDomiciliosDAO() {
		return domiciliosDAO;
	}

	public void setDomiciliosDAO(DomiciliosDAO domiciliosDAO) {
		this.domiciliosDAO = domiciliosDAO;
	}

	public List<Paises> getLstPaises() {
		return lstPaises;
	}

	public void setLstPaises(List<Paises> lstPaises) {
		this.lstPaises = lstPaises;
	}

	public List<Paises> getLstPaisesFiltered() {
		return lstPaisesFiltered;
	}

	public void setLstPaisesFiltered(List<Paises> lstPaisesFiltered) {
		this.lstPaisesFiltered = lstPaisesFiltered;
	}

	public Paises getPaisSelected() {
		return paisSelected;
	}

	public void setPaisSelected(Paises paisSelected) {
		this.paisSelected = paisSelected;
	}

	public PaisesDAO getPaisesDAO() {
		return paisesDAO;
	}

	public void setPaisesDAO(PaisesDAO paisesDAO) {
		this.paisesDAO = paisesDAO;
	}

	public List<Estados> getLstEstados() {
		return lstEstados;
	}

	public void setLstEstados(List<Estados> lstEstados) {
		this.lstEstados = lstEstados;
	}

	public List<Estados> getLstEstadosFiltered() {
		return lstEstadosFiltered;
	}

	public void setLstEstadosFiltered(List<Estados> lstEstadosFiltered) {
		this.lstEstadosFiltered = lstEstadosFiltered;
	}

	public Estados getEstadoSelected() {
		return estadoSelected;
	}

	public void setEstadoSelected(Estados estadoSelected) {
		this.estadoSelected = estadoSelected;
	}

	public EstadosDAO getEstadosDAO() {
		return estadosDAO;
	}

	public void setEstadosDAO(EstadosDAO estadosDAO) {
		this.estadosDAO = estadosDAO;
	}
		
	public List<Municipios> getLstMunicipios() {
		return lstMunicipios;
	}

	public void setLstMunicipios(List<Municipios> lstMunicipios) {
		this.lstMunicipios = lstMunicipios;
	}

	public List<Municipios> getLstMunicipiosFiltered() {
		return lstMunicipiosFiltered;
	}

	public void setLstMunicipiosFiltered(List<Municipios> lstMunicipiosFiltered) {
		this.lstMunicipiosFiltered = lstMunicipiosFiltered;
	}

	public Municipios getMunicipioSelected() {
		return municipioSelected;
	}

	public void setMunicipioSelected(Municipios municipioSelected) {
		this.municipioSelected = municipioSelected;
	}

	public MunicipiosDAO getMunicipiosDAO() {
		return municipiosDAO;
	}

	public void setMunicipiosDAO(MunicipiosDAO municipiosDAO) {
		this.municipiosDAO = municipiosDAO;
	}

	public List<Ciudades> getLstCiudades() {
		return lstCiudades;
	}

	public void setLstCiudades(List<Ciudades> lstCiudades) {
		this.lstCiudades = lstCiudades;
	}

	public List<Ciudades> getLstCiudadesFiltered() {
		return lstCiudadesFiltered;
	}

	public void setLstCiudadesFiltered(List<Ciudades> lstCiudadesFiltered) {
		this.lstCiudadesFiltered = lstCiudadesFiltered;
	}

	public Ciudades getCiudadSelected() {
		return ciudadSelected;
	}

	public void setCiudadSelected(Ciudades ciudadSelected) {
		this.ciudadSelected = ciudadSelected;
	}

	public CiudadesDAO getCiudadesDAO() {
		return ciudadesDAO;
	}

	public void setCiudadesDAO(CiudadesDAO ciudadesDAO) {
		this.ciudadesDAO = ciudadesDAO;
	}

	public List<AsentamientoHumano> getLstAsentamientoHumano() {
		return lstAsentamientoHumano;
	}

	public void setLstAsentamientoHumano(List<AsentamientoHumano> lstAsentamientoHumano) {
		this.lstAsentamientoHumano = lstAsentamientoHumano;
	}

	public List<AsentamientoHumano> getLstAsentamientoHumanoFiltered() {
		return lstAsentamientoHumanoFiltered;
	}

	public void setLstAsentamientoHumanoFiltered(List<AsentamientoHumano> lstAsentamientoHumanoFiltered) {
		this.lstAsentamientoHumanoFiltered = lstAsentamientoHumanoFiltered;
	}

	public AsentamientoHumano getAsentamientoHumanoSelected() {
		return asentamientoHumanoSelected;
	}

	public void setAsentamientoHumanoSelected(AsentamientoHumano asentamientoHumanoSelected) {
		this.asentamientoHumanoSelected = asentamientoHumanoSelected;
	}

	public AsentamientoHumanoDAO getAsentamientoHumanoDAO() {
		return asentamientoHumanoDAO;
	}

	public void setAsentamientoHumanoDAO(AsentamientoHumanoDAO asentamientoHumanoDAO) {
		this.asentamientoHumanoDAO = asentamientoHumanoDAO;
	}
	
	
	


}