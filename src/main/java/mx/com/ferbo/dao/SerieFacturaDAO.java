package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.ferbo.model.SerieFactura;
import mx.com.ferbo.model.StatusSerie;
import mx.com.ferbo.util.EntityManagerUtil;

public class SerieFacturaDAO {

	public List<SerieFactura> findAll() {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		List<SerieFactura> list = null;
		list = entity.createNamedQuery("SerieFactura.findAll", SerieFactura.class).getResultList();
		return list;
	};

	public List<StatusSerie> findStatus() {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		List<StatusSerie> list = null;
		list = entity.createNamedQuery("StatusSerie.findAll", StatusSerie.class).getResultList();
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
	};

	public String cancelar(int id) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		entity.getTransaction().begin();
		Query sql = entity.createNativeQuery("update serie_factura set status_serie = 3 where id = ?;");
		sql.setParameter(1, id);
		sql.executeUpdate();
		entity.getTransaction().commit();
		entity.close();
		return null;
	};

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
