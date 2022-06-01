package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Municipios;
import mx.com.ferbo.util.EntityManagerUtil;

public class MunicipiosDAO extends IBaseDAO<Municipios, Integer> {

	@Override
	public Municipios buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Municipios> buscarTodos() {
		List<Municipios> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Municipios.findAll", Municipios.class).getResultList();
		return listado;
	}

	@Override
	public List<Municipios> buscarPorCriterios(Municipios e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(Municipios e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Municipios e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(Municipios e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<Municipios> listado) {
		// TODO Auto-generated method stub
		return null;
	}

	}
