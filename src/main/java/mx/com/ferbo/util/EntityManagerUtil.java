package mx.com.ferbo.util;

import javax.persistence.*;

/**
 *
 * @author Gabriel Moreno <gabrielmos0309@gmail.com>
 */
public class EntityManagerUtil {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionPU");

    public static EntityManager getEntityManager() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gestionPU");
//        EntityManager manager = factory.createEntityManager();
//        return manager;
        return emf.createEntityManager();
    }
}
