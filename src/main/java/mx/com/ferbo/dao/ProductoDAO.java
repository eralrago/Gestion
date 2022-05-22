package mx.com.ferbo.dao;

import java.util.List;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Producto;
/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
public class ProductoDAO extends IBaseDAO<Producto, Integer> {

	@Override
	public Producto buscarPorId(Integer id) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public List<Producto> buscarTodos() {
		List<Producto> listado = null;
		listado = em.createNamedQuery("Producto.findAll", Producto.class).getResultList();
		return listado;
	}

	@Override
	public List<Producto> buscarPorCriterios(Producto e) {
		return null;
	}

	@Override
	public String actualizar(Producto producto) {
		try {
			em.getTransaction().begin();
			em.merge(producto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String guardar(Producto persona) {
		try {
			em.getTransaction().begin();
			em.persist(persona);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminar(Producto persona) {
		try {
			em.getTransaction().begin();
			em.remove(em.merge(persona));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminarListado(List<Producto> listado) {
		try {
			em.getTransaction().begin();
			for (Producto producto : listado) {
				em.remove(em.merge(producto));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

}
