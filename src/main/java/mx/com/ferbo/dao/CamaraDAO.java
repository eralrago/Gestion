package mx.com.ferbo.dao;

import java.util.List;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Camara;

public class CamaraDAO extends IBaseDAO<Camara, Integer> {

	@Override
	public Camara buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Camara> buscarTodos() {
		List<Camara> listado = null;
		listado = em.createNamedQuery("Camara.findAll", Camara.class).getResultList();
		return listado;
	}

	@Override
	public List<Camara> buscarPorCriterios(Camara e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(Camara camara) {
		try {
			em.getTransaction().begin();
			em.merge(camara);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String guardar(Camara camara) {
		try {
			em.getTransaction().begin();
			em.persist(camara);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminar(Camara camara) {
		try {
			em.getTransaction().begin();
			em.remove(em.merge(camara));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminarListado(List<Camara> listado) {
		try {
			em.getTransaction().begin();
			for (Camara camara : listado) {
				em.remove(em.merge(camara));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

}
