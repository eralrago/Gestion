package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.ferbo.util.JPAEntity;
import mx.com.ferbo.model.Planta;

import mx.com.ferbo.util.JPAEntity;
import mx.com.ferbo.model.Posicion;

public class chequesDevueltosDAO {
	
	EntityManager entity = JPAEntity.getEntity().createEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Posicion> findAll(){
		List<Posicion> posiciones;
		Query sql = entity.createNamedQuery("Posicion.findAll", Posicion.class);
		posiciones = sql.getResultList();
		System.out.println(posiciones + "*****************************************************");
		return posiciones;
	}
	
	public List<Posicion> findIdPosicion() {
		List<Posicion> idPosiciones = null;
		Query sqlId = entity.createNamedQuery("Posicion.findByIdPosicion", Posicion.class);
		return idPosiciones;
	}
	
	 
}