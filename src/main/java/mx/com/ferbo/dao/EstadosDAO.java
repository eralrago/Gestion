package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Estados;
import mx.com.ferbo.model.Paises;
import mx.com.ferbo.util.EntityManagerUtil;

public class EstadosDAO extends IBaseDAO<Estados, Integer>{

	@Override
	public Estados buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estados> buscarTodos() {
		List<Estados> listado = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Estados.findAll", Estados.class).getResultList();
		return listado;
	}

	@Override
	public List<Estados> buscarPorCriterios(Estados e) {
		List<Estados> listado = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Estados.findByPaisCve", Estados.class).setParameter("paisCve", e.getEstadosPK().getPaisCve()).getResultList();
		return listado;
	}

	@Override
	public String actualizar(Estados estados) {
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(estados);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR actualizando Estado" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String guardar(Estados estados) {
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(estados);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR guardando Estado" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminar(Estados estados) {
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(estados));
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminarListado(List<Estados> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
