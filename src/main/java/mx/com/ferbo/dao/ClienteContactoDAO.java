package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.ClienteContacto;
import mx.com.ferbo.util.EntityManagerUtil;

public class ClienteContactoDAO extends IBaseDAO<ClienteContacto, Integer>{

	@Override
	public ClienteContacto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteContacto> buscarTodos() {
		List<ClienteContacto> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("ClienteContacto.findAll", ClienteContacto.class).getResultList();
		return listado;
	}

	@Override
	public List<ClienteContacto> buscarPorCriterios(ClienteContacto e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(ClienteContacto e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(ClienteContacto e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(ClienteContacto e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<ClienteContacto> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
