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
	public String actualizar(Domicilios e) {
		// TODO Auto-generated method stub
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
