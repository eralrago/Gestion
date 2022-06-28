package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.TipoTelefono;
import mx.com.ferbo.util.EntityManagerUtil;

public class TipoTelefonoDAO extends IBaseDAO<TipoTelefono, Integer> {

	@Override
	public TipoTelefono buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoTelefono> buscarTodos() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		List<TipoTelefono> listado = null;
		listado = em.createNamedQuery("TipoTelefono.findAll", TipoTelefono.class).getResultList();
		return listado;
	}

	@Override
	public List<TipoTelefono> buscarPorCriterios(TipoTelefono e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(TipoTelefono e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(TipoTelefono e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(TipoTelefono e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<TipoTelefono> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
