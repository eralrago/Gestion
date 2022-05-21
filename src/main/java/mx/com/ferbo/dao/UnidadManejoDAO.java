package mx.com.ferbo.dao;

import java.util.List;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.UnidadDeManejo;

public class UnidadManejoDAO extends IBaseDAO<UnidadDeManejo, Integer>{

	@Override
	public UnidadDeManejo buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnidadDeManejo> buscarTodos() {
		List<UnidadDeManejo> listado = null;
		listado = em.createNamedQuery("UnidadDeManejo.findAll", UnidadDeManejo.class).getResultList();
		return listado;
	}

	@Override
	public List<UnidadDeManejo> buscarPorCriterios(UnidadDeManejo e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(UnidadDeManejo e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(UnidadDeManejo e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(UnidadDeManejo e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<UnidadDeManejo> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
