package mx.com.ferbo.dao;

import static mx.com.ferbo.util.EntityManagerUtil.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.TipoCobro;

public class TipoCobroDAO extends IBaseDAO<TipoCobro, Integer> {

	@Override
	public TipoCobro buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoCobro> buscarTodos() {
		EntityManager em = getEntityManager();
		List<TipoCobro> listado = null;
		listado = em.createNamedQuery("TipoCobro.findAll", TipoCobro.class).getResultList();
		return listado;
	}

	@Override
	public List<TipoCobro> buscarPorCriterios(TipoCobro e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(TipoCobro e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(TipoCobro e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(TipoCobro e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<TipoCobro> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
