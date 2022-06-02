package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.Paises;
import mx.com.ferbo.util.EntityManagerUtil;

public class PaisesDAO extends IBaseDAO<Paises, Integer> {

	@Override
	public Paises buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paises> buscarTodos() {
		List<Paises> listado = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Paises.findAll", Paises.class).getResultList();
		return listado;
	}

	@Override
	public List<Paises> buscarPorCriterios(Paises e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(Paises e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Paises e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(Paises e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<Paises> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
