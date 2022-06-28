package mx.com.ferbo.dao;

import java.util.List;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.Paises;

public class PaisesDAO extends IBaseDAO<Paises, Integer> {

	@Override
	public Paises buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paises> buscarTodos() {
		//TODO ESTEBAN. de manera temporal se inhabilitó esta parte de código para facilitar la compilación de las ramas,
		//ya que la línea em.createNamedQuery(...) no tiene definido el objeto em.
		//List<Paises> listado = null;
		//listado = em.createNamedQuery("Paises.findAll", Paises.class).getResultList();
		//return listado;
		return null;
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
