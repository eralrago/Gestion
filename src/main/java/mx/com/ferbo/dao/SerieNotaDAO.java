package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.ferbo.model.SerieNota;
import mx.com.ferbo.model.StatusSerie;
import mx.com.ferbo.util.EntityManagerUtil;

public class SerieNotaDAO {

	public List<SerieNota> findAll() {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		List<SerieNota> list = null;
		list = entity.createNamedQuery("SerieNota.findAll", SerieNota.class).getResultList();
		return list;
	};

	public List<StatusSerie> findStatus() {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		List<StatusSerie> list = null;
		list = entity.createNamedQuery("StatusSerie.findAll", StatusSerie.class).getResultList();
		return list;
	};

	public String save(SerieNota sN) {
		try {
			EntityManager entity = EntityManagerUtil.getEntityManager();
			entity.getTransaction().begin();
			entity.persist(sN);
			entity.getTransaction().commit();
			entity.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	};

	public String update(SerieNota sN) {
		try {
			EntityManager entity = EntityManagerUtil.getEntityManager();
			entity.getTransaction().begin();
			entity.merge(sN);
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
		Query sql = entity.createNativeQuery("update SERIE_NOTA set STATUS_SERIE = 3 where ID = ?;");
		sql.setParameter(1, id);
		sql.executeUpdate();
		entity.getTransaction().commit();
		entity.close();
		return null;
	};

	public String delete(SerieNota sN) {
		try {
			EntityManager entity = EntityManagerUtil.getEntityManager();
			entity.getTransaction().begin();
			entity.remove(entity.merge(sN));
			entity.getTransaction().commit();
			entity.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	};

}
