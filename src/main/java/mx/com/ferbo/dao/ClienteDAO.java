package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.util.EntityManagerUtil;

public class ClienteDAO extends IBaseDAO<Cliente, Integer> {

	@Override
	public Cliente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		List<Cliente> listado = null;
		listado = em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
		return listado;
	}

	@Override
	public List<Cliente> buscarPorCriterios(Cliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(Cliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Cliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(Cliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<Cliente> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
