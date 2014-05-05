package util;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	public static void main(String[] args)
	{
		Session session = null;
		try
		{
		try
		{
		//Se instancia la configuración
		Configuration cfg = new Configuration();
		//Se configura hibernate tomando el archivo de configuracion
		cfg.configure("hibernate/hibernate.cfg.xml");
		//se crea el sessionFactory para poder crear la sesion y asi persisitir
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		}
		catch (Throwable ex)
		{
		System.err.println("Failed to create sessionFactory object."+ ex);
		throw new ExceptionInInitializerError(ex);
		}
		//Se inicia la sesion
		session = sessionFactory.openSession();
		//Se crea la clase alumno
		Usuario usuario = new Usuario();
		usuario.setEmail("soyyo@lala2.com");
		
		System.out.println("Insertando un usuario");
		//Se inicia la transacción
		Transaction tx = session.beginTransaction();
		//Se persiste el objeto
		session.save(usuario);
		//Se cierra la transaccion
		tx.commit();
		System.out.println("Vamos los pibes");
		} catch (Exception e) {
		System.out.println(e.getMessage());
		} finally {
		//Se cierra la sesion
		session.close();
		}
		
		
	}
	
	
}
