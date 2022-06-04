package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Domicilios;
import mx.com.ferbo.util.EntityManagerUtil;

public class DomiciliosDAO extends IBaseDAO<Domicilios, Integer> {

	@Override
	public Domicilios buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Domicilios> buscarTodos() {
		List<Domicilios> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Domicilios.findAll", Domicilios.class).getResultList();
		return listado;
	}

	@Override
	public List<Domicilios> buscarPorCriterios(Domicilios e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(Domicilios dom) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.createQuery(
					"update Domicilios as dm  set dm.ciudades.ciudadesPK.ciudadCve = :ciudadCve, dm.ciudades.municipios.estados.estadosPK.estadoCve = :estadoCve ,dm.ciudades.municipios.municipiosPK.municipioCve = :municipioCve, dm.paisCved.paisCve = :paisCve"
							+ ",dm.domicilioCalle= :domicilioCalle, dm.domicilioColonia=:domicilioColonia, dm.domicilioCp= :domicilioCp , dm.domicilioFax = :domicilioFax"
							+ ",dm.domicilioNumExt = :domicilioNumExt , dm.domicilioNumInt = :domicilioNumInt , dm.domicilioTel1 =:domicilioTel1"
							+ ",dm.domicilioTel2 = :domicilioTel2, dm.domicilioTipoCve.domicilioTipoCve = :domicilioTipoCve where dm.domCve=:domCve")
					.setParameter("ciudadCve", dom.getCiudades().getCiudadesPK().getCiudadCve())
					.setParameter("estadoCve",
							dom.getCiudades().getMunicipios().getEstados().getEstadosPK().getEstadoCve())
					.setParameter("municipioCve", dom.getCiudades().getMunicipios().getMunicipiosPK().getMunicipioCve())
					.setParameter("paisCve", dom.getPaisCved().getPaisCve())
					.setParameter("domicilioCalle", dom.getDomicilioCalle())
					.setParameter("domicilioColonia", dom.getDomicilioColonia())
					.setParameter("domicilioCp", dom.getDomicilioCp())
					.setParameter("domicilioFax", dom.getDomicilioFax())
					.setParameter("domicilioNumExt", dom.getDomicilioNumExt())
					.setParameter("domicilioNumInt", dom.getDomicilioNumInt())
					.setParameter("domicilioTel1", dom.getDomicilioTel1())
					.setParameter("domicilioTel2", dom.getDomicilioTel2())
					.setParameter("domicilioTipoCve", dom.getDomicilioTipoCve().getDomicilioTipoCve())
					.setParameter("domCve", dom.getDomCve());
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String guardar(Domicilios dom) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(dom);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminar(Domicilios e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<Domicilios> listado) {
		// TODO Auto-generated method stub
		return null;
	}

	}
