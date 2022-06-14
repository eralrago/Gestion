package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Estados;
import mx.com.ferbo.model.Ciudades;
import mx.com.ferbo.util.EntityManagerUtil;

public class CiudadesDAO extends IBaseDAO<Ciudades, Integer> {

	@Override
	public Ciudades buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudades> buscarTodos() {
		List<Ciudades> listado = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Ciudades.findAll", Ciudades.class).getResultList();
		return listado;
	}

	@Override
	public List<Ciudades> buscarPorCriterios(Ciudades e) {
		List<Ciudades> listado = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Ciudades.findByPaisCveEstadoCveMunicipioCve", Ciudades.class).setParameter("paisCve", e.getCiudadesPK().getPaisCve()).setParameter("estadoCve", e.getCiudadesPK().getEstadoCve()).setParameter("municipioCve", e.getCiudadesPK().getMunicipioCve())
		.getResultList();
		return listado;
	}

	@Override
	public String actualizar(Ciudades ciudades) {
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(ciudades);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR guardando Municipio" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String guardar(Ciudades ciudades) {
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(ciudades);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR guardando Municipio" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminar(Ciudades ciudades) {
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(ciudades));
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminarListado(List<Ciudades> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
