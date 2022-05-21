package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.ferbo.util.JPAEntity;
import mx.com.ferbo.model.Planta;

public class PlantaDAO {

	EntityManager entity = JPAEntity.getEntity().createEntityManager();

	@SuppressWarnings("unchecked")
	public List<Planta> findall() {
		List<Planta> plantas = null;
		Query sql = entity.createNamedQuery("Planta.findAll", Planta.class);
		plantas = sql.getResultList();
		return plantas;
	}
	
	public void save(Planta p) {
		entity.getTransaction().begin();
		entity.persist(p);
		entity.getTransaction().commit();
		JPAEntity.shutdown();
	}
	
	public void update(Planta p) {
		entity.getTransaction().begin();
		entity.merge(p);
		entity.getTransaction().commit();
		JPAEntity.shutdown();
	}
	
	public void delete(Planta p) {
		entity.getTransaction().begin();
		entity.remove(entity.merge(p));
		entity.getTransaction().commit();
		
	}
	
	public Planta findOne(int id) {
		Planta p = new Planta();
		p = entity.find(Planta.class, id);
		//JPAEntity.shutdown();
		return p;
	}
}
