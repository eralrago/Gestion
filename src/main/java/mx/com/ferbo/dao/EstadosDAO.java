package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Estados;
import mx.com.ferbo.util.EntityManagerUtil;

public class EstadosDAO extends IBaseDAO<Estados, Integer> {

	@Override
	public Estados buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estados> buscarTodos() {
		List<Estados> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("Estados.findAll", Estados.class).getResultList();
		return listado;
	}

	@Override
	public List<Estados> buscarPorCriterios(Estados e) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerUtil.getEntityManager();
		if (e.getPaises().getPaisCve() != null) {
			TypedQuery<Estados> consEstados = em.createNamedQuery("Estados.findByPaisCve", Estados.class);
			consEstados.setParameter("paisCve", e.getPaises().getPaisCve());
			List<Estados> listado = consEstados.getResultList();
			return listado;
		} else {
			return null;
		}
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

	public List<Estados> buscaPorId(Integer id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		return em.createNamedQuery("Estados.findByEstadoCve", Estados.class)
				.setParameter("estadoCve", id).getResultList();
	}

}
