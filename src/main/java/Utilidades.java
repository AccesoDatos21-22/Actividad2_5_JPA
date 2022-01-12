import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
/**
 * Responsable de crear un objeto sesion (gestiona la conexion a BD de forma transparente
 * @author Laura y Carlos
 *
 */
public class Utilidades {
	
	 
	    //Factoria de sesion para crear objeto sesion a partir de XML
	    private static SessionFactory sessionFactory;
	    
		private static EntityManagerFactory emf;
		
		private static EntityManagerFactory buildEntityManagerFactory(){

			emf = Persistence.createEntityManagerFactory("persistence");
			
			return emf;
		}
		/*
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Creamos una factoria de sesiones con los datos de hibernate.cfg.xml
	            Configuration configuration = new Configuration();
	            //configuration.configure("hibernate.cfg.xml");
				configuration.configure("persistence.xml");
	            System.out.println("Configuracion de Hibernate Cargada");
	             
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	            System.out.println("Servicio de registro de Hibernate Realizado");
	             
	            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	             
	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // En un caso real se registra en un log
	            System.err.println("Fallo la creacion de la factoria de sesiones inicial." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    */

	    /*
	    public static SessionFactory getSessionFactory() {
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }
*/

	    /*
	     * Metodo estatico (Fachada) para crear la factoia de Entidades
	     */
	    public static EntityManagerFactory getEntityManagerFactory() {

	        if(emf == null) emf = buildEntityManagerFactory();
	        return emf;
	    }



}
