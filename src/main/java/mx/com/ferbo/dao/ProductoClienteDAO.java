package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.ProductoPorCliente;
import mx.com.ferbo.util.EntityManagerUtil;

public class ProductoClienteDAO extends IBaseDAO<ProductoPorCliente, Integer> {

	@Override
	public ProductoPorCliente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoPorCliente> buscarTodos() {
		List<ProductoPorCliente> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("ProductoPorCliente.findAll", ProductoPorCliente.class).getResultList();
		return listado;
	}

	@Override
	public List<ProductoPorCliente> buscarPorCriterios(ProductoPorCliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(ProductoPorCliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(ProductoPorCliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(ProductoPorCliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarListado(List<ProductoPorCliente> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
