package mx.com.ferbo.dao;

import java.util.List;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.PrecioServicio;

public class PrecioServicioDAO extends IBaseDAO<PrecioServicio, Integer> {

	@Override
	public PrecioServicio buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrecioServicio> buscarTodos() {
		List<PrecioServicio> listado;
		listado = em.createNamedQuery("PrecioServicio.findAll", PrecioServicio.class).getResultList();
		return listado;
	}

	@Override
	public List<PrecioServicio> buscarPorCriterios(PrecioServicio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(PrecioServicio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(PrecioServicio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(PrecioServicio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<PrecioServicio> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
