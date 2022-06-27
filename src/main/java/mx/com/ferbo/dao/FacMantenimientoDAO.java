package mx.com.ferbo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mx.com.ferbo.model.Cliente;
import mx.com.ferbo.model.Factura;
import mx.com.ferbo.model.StatusFactura;
import mx.com.ferbo.util.EntityManagerUtil;

public class FacMantenimientoDAO {

	public List<Factura> findDacturas(Cliente c) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		@SuppressWarnings("unchecked")
		List<Factura> list = entity.createQuery("SELECT f FROM Factura f WHERE f.cliente = :cliente AND f.status = 1")
				.setParameter("cliente", c).getResultList();
		return list;
	};

	public String update(Factura f) {
		StatusFactura s = new StatusFactura();
		s.setId(2);
		f.setStatus(s);
		try {
			EntityManager entity = EntityManagerUtil.getEntityManager();
			entity.getTransaction().begin();
			entity.merge(f);
			entity.getTransaction().commit();
			entity.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	};
}
