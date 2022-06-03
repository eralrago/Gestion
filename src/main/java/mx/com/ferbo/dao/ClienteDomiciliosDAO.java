package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.commons.dao.IBaseDAO;
import mx.com.ferbo.model.ClienteDomicilios;
import mx.com.ferbo.util.EntityManagerUtil;

public class ClienteDomiciliosDAO extends IBaseDAO<ClienteDomicilios, Integer> {

	@Override
	public ClienteDomicilios buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDomicilios> buscarTodos() {
		List<ClienteDomicilios> listado;
		EntityManager em = EntityManagerUtil.getEntityManager();
		listado = em.createNamedQuery("ClienteDomicilios.findAll", ClienteDomicilios.class).getResultList();
		return listado;
	}

	@Override
	public List<ClienteDomicilios> buscarPorCriterios(ClienteDomicilios e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizar(ClienteDomicilios clienteDomicilio) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(clienteDomicilio);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}		
		return null;
	}

	@Override
	public String guardar(ClienteDomicilios clienteDomicilio) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(clienteDomicilio);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			return "ERROR";
		}
		return null;
	}

	@Override
	public String eliminar(ClienteDomicilios prodCliente) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String eliminarListado(List<ClienteDomicilios> listado) {
		// TODO Auto-generated method stub
		return null;
	}

}
