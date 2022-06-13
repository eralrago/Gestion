package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Ciudades;
import mx.com.ferbo.util.EntityManagerUtil;

public class CiudadesDAO extends IBaseDAO<Ciudades, Integer> {

	@Override
	public Ciudades buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudades> buscarTodos() {
		List<Ciudades> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Ciudades.findAll", Ciudades.class).getResultList();
		return listado;
	}

	@Override
	public List<Ciudades> buscarPorCriterios(Ciudades e) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerUtil.getEntityManager();
		if (e.getMunicipios().getMunicipiosPK().getMunicipioCve() > 0) {
			TypedQuery<Ciudades> consEstados = em.createNamedQuery("Ciudades.findByMunicipioCve", Ciudades.class);
			consEstados.setParameter("municipioCve", e.getMunicipios().getMunicipiosPK().getMunicipioCve());
			List<Ciudades> listado = consEstados.getResultList();
			return listado;
		} else {
			return null;
		}
	}

	@Override
	public String actualizar(Ciudades e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Ciudades e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(Ciudades e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<Ciudades> listado) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ciudades> buscaPorId(Integer id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		return em.createNamedQuery("Ciudades.findByCiudadCve", Ciudades.class)
				.setParameter("ciudadCve", id).getResultList();
	}
}
