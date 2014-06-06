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
        //peliMasVista("2013");
        //usuariosMasPelis(10);
        usuariosMenos65();
		}
	
	private static void listarSeries() {
		session = sessionFactory.openSession();
		Query series = session.createQuery("from Serie"); //select titulo???
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
		  System.out.println("----------------------------------------------------------------------");
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
		  System.out.println("----------------------------------------------------------------------");
		  } 
		  catch (Exception e) {
		  System.out.println(e.getMessage());
		  } 
		  finally {
		    session.close();
		    }
		
	}	
	
	/**private static void peliMasVista(String year) throws ParseException { //FALTA TERMINAR
		String queryString = "select count(p.id) from Reproduccion r  where r.reproducible.class = 'Pelicula' and r.fecha between :ini and :fin";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaIni = df.parse("01-01-"+year);
		Date fechaFin = df.parse("31-12-"+year);
		session = sessionFactory.openSession();
		try	{
		  Transaction tx = session.beginTransaction();
		  Pelicula peli = (Pelicula) session.createQuery(queryString).setDate("ini", fechaIni).setDate("fin", fechaFin).setMaxResults(1).uniqueResult();
		  tx.rollback();
		  System.out.println("----------------------------------------------------------------------");
		  System.out.println("Informar la película más vista en un determinado año (donde el año es parametrizable). Imprimir en consola: \"El título de la Película más vista en el año: \"...\" es: \"");
		  System.out.println("Parámetro: \""+ year +"\"");
		  System.out.println("----------------------------------------------------------------------");
		  System.out.println("El título de la Película más vista en el año: "+year+" es: "+ peli.getTitulo());
		  System.out.println("----------------------------------------------------------------------");
		  } 
		  catch (Exception e) {
		  System.out.println(e.getMessage());
		  } 
		  finally {
		    session.close();
		    }
		
	}	
	
	private static void usuariosMasPelis(int n) {
		String queryString = "select U.email, count(U.id) from Usuario U, Reproduccion R where U.gestor.reproducciones>=:n and R.reproducible = 'h'";
		session = sessionFactory.openSession();
		Query seriesSec = session.createQuery(queryString).setInteger("n", n);
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
		
	}**/
	
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
	
}
