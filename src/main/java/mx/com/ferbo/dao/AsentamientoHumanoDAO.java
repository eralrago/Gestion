package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.AsentamientoHumano;
import mx.com.ferbo.model.Ciudades;
import mx.com.ferbo.util.EntityManagerUtil;

public class AsentamientoHumanoDAO extends IBaseDAO<AsentamientoHumano, Integer> {

	@Override
	public AsentamientoHumano buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsentamientoHumano> buscarTodos() {
		List<AsentamientoHumano> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("AsentamientoHumano.findAll", AsentamientoHumano.class).getResultList();
		return listado;
	}

	@Override
	public List<AsentamientoHumano> buscarPorCriterios(AsentamientoHumano e) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerUtil.getEntityManager();
		if (e.getAsentamientoHumanoPK().getCiudadCve() > 0) {
			TypedQuery<AsentamientoHumano> consEstados = em.createNamedQuery("AsentamientoHumano.findByCiudadCve", AsentamientoHumano.class);
			consEstados.setParameter("ciudadCve", e.getAsentamientoHumanoPK().getCiudadCve());
			List<AsentamientoHumano> listado = consEstados.getResultList();
			return listado;
		} else {
			return null;
		}
	}

	@Override
	public String actualizar(AsentamientoHumano e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(AsentamientoHumano e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(AsentamientoHumano e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<AsentamientoHumano> listado) {
		// TODO Auto-generated method stub
		return null;
	}

	}
