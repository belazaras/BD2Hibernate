package hibernate;

import java.text.*;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import model.*;

public class Queries {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Session session = null;
	
	public static void main(String[] args) throws ParseException  {
		//Session session = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");
			serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			}
		catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
        listarSeries();
        seriesConSecuencia("Sim");
        cincoEpisodiosMasVistos(); 
        peliMasVista("2013");
		masPeliculas(10);
        //usuariosMenos65();
		}
	
	private static void listarSeries() {
		session = sessionFactory.openSession();
		Query series = session.createQuery("from Serie");
		try	{
		  session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  Iterator<?> s = series.iterate();
		  tx.rollback();
		  System.out.println("----------------------------------------------------------------------");
		  System.out.println("Listar el nombre de todas las series del sistema. Imprimir en consola: \"Título de la Serie: \"");
		  System.out.println("----------------------------------------------------------------------");
		  while (s.hasNext()) {
			Serie serie = (Serie) s.next();
			System.out.println("Título de la Serie: " + serie.getTitulo());  
		    }
		  System.out.println("=======================================================================");
		  } 
		  catch (Exception e) {
		  System.out.println(e.getMessage());
		  } 
		  finally {
		    session.close();
		    }	
	}

	private static void seriesConSecuencia(String sec) {
		String queryString = "from Serie s where s.titulo like :sec";
		session = sessionFactory.openSession();
		Query seriesSec = session.createQuery(queryString).setString("sec", "%"+sec+"%");
		try	{
		  Transaction tx = session.beginTransaction();
		  Iterator<?> s = seriesSec.iterate();
		  tx.rollback();
		  System.out.println("----------------------------------------------------------------------");
		  System.out.println("Listar las series cuyo título contenga una secuencia de caracteres (la secuencia es un parámetro). Imprimir en consola: \"Título de la Serie: \"");
		  System.out.println("Parámetro: \""+ sec +"\"");
		  System.out.println("----------------------------------------------------------------------");
		  while (s.hasNext()) {
			Serie serie = (Serie) s.next();
			System.out.println("Título de la Serie: " + serie.getTitulo());  
		    }
		  System.out.println("=======================================================================");
		  } 
		  catch (Exception e) {
		  System.out.println(e.getMessage());
		  } 
		  finally {
		    session.close();
		    }
		
	}	
	
	private static void cincoEpisodiosMasVistos() {
		
		String queryString ="SELECT r, count(idReproducible) as cant "
						  + "FROM Reproduccion r "
						  + "WHERE r.reproducible.class ='model.Episodio' "
						  + "GROUP BY idReproducible "
						  + "ORDER BY cant desc";
		session = sessionFactory.openSession();
		Query result = session.createQuery(queryString);
		result.setMaxResults(5);
		try{
			Transaction tx = session.beginTransaction();
			Iterator<?> r = result.iterate();
			tx.rollback();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Listar los 5 episodios de series más vistos en el sistema.");
			System.out.println("----------------------------------------------------------------------");
			while(r.hasNext()){
				Object[] objects = (Object[]) r.next();
				Reproduccion repro = (Reproduccion) objects[0];
				Long cant = (Long) objects[1]; 
				System.out.println("Episodio:"+repro.getReproducible().getTitulo()+" ha sido visto "+cant+" veces");
			}

			System.out.println("=======================================================================");
			
		  }
		  
		catch (Exception e) {
		  System.out.println(e.getMessage());
		  } 
		  
		finally {
		    session.close();
		  }
			
		
	}
	
	
	private static void peliMasVista(String year) throws ParseException { 
		
		String queryString ="SELECT r, count(idReproducible) as cant "
				  + "FROM Reproduccion r "
				  + "WHERE r.reproducible.class ='model.Pelicula' and r.fecha between :ini and :fin "
				  + "GROUP BY idReproducible "
				  + "ORDER BY cant DESC";
		
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaIni = df.parse("01-01-"+year);
		Date fechaFin = df.parse("31-12-"+year);
		session = sessionFactory.openSession();
		try	{
		  Transaction tx = session.beginTransaction();
		  Query result = session.createQuery(queryString).setDate("ini", fechaIni).setDate("fin", fechaFin).setMaxResults(1);
		  System.out.println("-------------------------------------------------------------------");
		  System.out.println("Informar la película más vista en un determinado año (donde el año es parametrizable).");
		  System.out.println("Parámetro: \""+ year +"\"");
		    
		  Iterator<?> r = result.iterate();
		  tx.rollback();
		  //Impresión del resultado.
		  while(r.hasNext()){
			  Object[] objects = (Object[]) r.next();
			  Reproduccion repro = (Reproduccion) objects[0];
			  Long cant = (Long) objects[1]; 
			  System.out.println("----------------------------------------------------------------------");
			  System.out.println("Película más vista en el año: "+year+" es: "+ repro.getReproducible().getTitulo()+"("+cant+" reproducciones)" );
			  System.out.println("=======================================================================");
			 
			}  
		  } 
		  catch (Exception e) {
		  System.out.println(e.getMessage());
		  } 
		  finally {
		    session.close();
		    }
		
	}	
	
	private static void masPeliculas(int _cantidadPeliculas) {
		
		
		String queryString = "SELECT user,count(user.idUsuario) AS cantidadReproducciones "
							 +"FROM Usuario user INNER JOIN user.gestor g "
							 +"INNER JOIN g.reproducciones r "
							 +"WHERE r.reproducible.class='model.Pelicula'"
							 +"GROUP BY (user.idUsuario) "
							 +"HAVING count(user.idUsuario) > :cantidadPeliculas "
							 +"ORDER BY cantidadReproducciones DESC";
		Session session = sessionFactory.openSession();
		try{
			Transaction tx = session.beginTransaction();
			List result = session.createQuery(queryString).setInteger("cantidadPeliculas", _cantidadPeliculas).list();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Listar los usuarios que reprodujeron más de n películas (donde n es parametrizable).");
			System.out.println("Parámetro: \""+ _cantidadPeliculas +"\"");
			System.out.println("-------------------------------------------------------------------");
			Iterator<?> ite = result.iterator();
			tx.rollback();
			while(ite.hasNext()){
				Object [] objects = (Object []) ite.next();
				Usuario user =(Usuario) objects[0];
				Long reproducciones =(Long) objects[1];
				System.out.println("Usuario "+user.getEmail()+" ha realizado "+reproducciones+" reproducciones.");
			}
			System.out.println("-------------------------------------------------------------------");
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		finally {
			session.close();
		}
		
		
	}
	/**
	private static void usuariosMenos65() { //FALTA
		String queryString = "from Usuario U where U.getIdUsuario() = '2'";
		session = sessionFactory.openSession();
		Query seriesSec = session.createQuery(queryString);
		try	{
		  Transaction tx = session.beginTransaction();
		  Iterator<?> s = seriesSec.iterate();
		  tx.rollback();
		  System.out.println("----------------------------------------------------------------------");
		  System.out.println("Listar las series cuyo título contenga una secuencia de caracteres (la secuencia es un parámetro). Imprimir en consola: \"Título de la Serie: \"");
		  //System.out.println("Parámetro: \""+ sec +"\"");
		  System.out.println("----------------------------------------------------------------------");
		  while (s.hasNext()) {
			Serie serie = (Serie) s.next();
			System.out.println("Título de la Serie: " + serie.getTitulo());  
		    }
		  System.out.println("----------------------------------------------------------------------");
		  } 
		  catch (Exception e) {
		  System.out.println(e.getMessage());
		  } 
		  finally {
		    session.close();
		    }
		
	}
	
	**/
	
}
