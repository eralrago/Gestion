package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.model.SerieFactura;
import mx.com.ferbo.util.EntityManagerUtil;

public class SerieFacturaDAO {

	public List<SerieFactura> findAll() {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		List<SerieFactura> list = null;
		list = entity.createNamedQuery("SerieFactura.findAll", SerieFactura.class).getResultList();
		return list;
	};

	public String save(SerieFactura sF) {
		try {
			EntityManager entity = EntityManagerUtil.getEntityManager();
			entity.getTransaction().begin();
			entity.persist(sF);
			entity.getTransaction().commit();
			entity.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	};

	public String update(SerieFactura sF) {
		try {
			EntityManager entity = EntityManagerUtil.getEntityManager();
			entity.getTransaction().begin();
			entity.merge(sF);
			entity.getTransaction().commit();
			entity.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	}

	public String delete(SerieFactura sF) {
		try {
			EntityManager entity = EntityManagerUtil.getEntityManager();
			entity.getTransaction().begin();
			entity.remove(entity.merge(sF));
			entity.getTransaction().commit();
			entity.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	};

}
