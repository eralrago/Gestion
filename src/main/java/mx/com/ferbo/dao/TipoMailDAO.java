package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.TipoMail;
import mx.com.ferbo.util.EntityManagerUtil;

public class TipoMailDAO extends IBaseDAO<TipoMail, Integer> {

	@Override
	public TipoMail buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoMail> buscarTodos() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		List<TipoMail> listado = null;
		listado = em.createNamedQuery("TipoMail.findAll", TipoMail.class).getResultList();
		return listado;
	}

	@Override
	public List<TipoMail> buscarPorCriterios(TipoMail e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(TipoMail e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(TipoMail e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(TipoMail e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<TipoMail> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
