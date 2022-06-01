package mx.com.ferbo.dao;

import java.util.List;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Estados;
import mx.com.ferbo.model.Paises;

public class EstadosDAO extends IBaseDAO<Estados, Integer>{

	@Override
	public Estados buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estados> buscarTodos() {
		List<Estados> listado = null;
		listado = em.createNamedQuery("Estados.findAll", Estados.class).getResultList();
		return listado;
	}

	@Override
	public List<Estados> buscarPorCriterios(Estados e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(Estados e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Estados e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(Estados e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<Estados> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
