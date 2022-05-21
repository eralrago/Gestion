package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.ferbo.util.JPAEntity;
import mx.com.ferbo.model.Planta;

import mx.com.ferbo.util.JPAEntity;
import mx.com.ferbo.model.Posicion;

public class PosicionCamaraDAO {
	
	EntityManager entity = JPAEntity.getEntity().createEntityManager();
	
	public List<Posicion> findAllPlantas(){
		
	}
}