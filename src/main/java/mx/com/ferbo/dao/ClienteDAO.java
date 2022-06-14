package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.util.EntityManagerUtil;

public class ClienteDAO extends IBaseDAO<Cliente, Integer> {

	@Override
	public Cliente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		List<Cliente> listado = null;
		listado = em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
		return listado;
	}

	@Override
	public List<Cliente> buscarPorCriterios(Cliente e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(Cliente cliente) {
		EntityManager em = null;
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}finally {
			if(em.isOpen()) {
				try {
					em.close();
				}catch (Exception e) {
					System.out.println("ERROR" + e.getMessage());
					return "ERROR";
				}
			}
		}
		return null;
	}

	@Override
	public String guardar(Cliente cliente) {
		EntityManager em = null;
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}finally {
			if(em.isOpen()) {
				try {
					em.close();
				}catch (Exception e) {
					System.out.println("ERROR" + e.getMessage());
					return "ERROR";
				}
			}
		}
		return null;
	}

	@Override
	public String eliminar(Cliente cliente) {
		EntityManager em = null;
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(cliente));
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}finally {
			if(em.isOpen()) {
				try {
					em.close();
				}catch (Exception e) {
					System.out.println("ERROR" + e.getMessage());
					return "ERROR";
				}
			}
		}
		return null;
	}

	@Override
	public String eliminarListado(List<Cliente> listado) {
		EntityManager em = null;
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			for (Cliente cliente : listado) {
				em.remove(em.merge(cliente));
			}
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}finally {
			if(em.isOpen()) {
				try {
					em.close();
				}catch (Exception e) {
					System.out.println("ERROR" + e.getMessage());
					return "ERROR";
				}
			}
		}
		return null;
	}

}
