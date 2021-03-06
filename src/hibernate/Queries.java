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

	public static void main(String[] args) throws ParseException {
		try {
			// Archivos de configuracion de hibernate
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					cfg.getProperties()).buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		// Comenzamos con los metodos de queries.
		/**
		 * La metodologia a utilizar en cada metodo esta dada por una
		 * transaccion donde realizaremos cada consulta en HQL.
		 **/
		listarSeries();
		seriesConSecuencia("Sim");
		cincoEpisodiosMasVistos();
		peliMasVista("2013");
		masPeliculas(10);
		menos65Seg();
		nMasVistas(3);
		usuariosVieronEpi("Be a Friend");
		usuariosPeliMenor12();
		limiteReproducciones(30);
	}

	private static void listarSeries() {
		/** El metodo lista todas las series del sistema **/
		session = sessionFactory.openSession();
		// La query a realizar
		Query series = session.createQuery("from Serie");
		try {

			session = sessionFactory.openSession();
			// Abrimos la transaccion
			Transaction tx = session.beginTransaction();
			Iterator<?> s = series.iterate(); // El iterador s lo utilizaremos
												// para imprimir los resultados
			tx.rollback(); // Cerramos la transaccion

			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("A. Listar el nombre de todas las series del sistema. Imprimir en consola: \"Titulo de la Serie: \"");
			System.out
					.println("----------------------------------------------------------------------");
			while (s.hasNext()) {
				Serie serie = (Serie) s.next();
				System.out.println("Titulo de la Serie: " + serie.getTitulo());
			}
			System.out
					.println("=======================================================================");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	private static void seriesConSecuencia(String sec) {
		/**
		 * El metodo lista aquellas series cuyo titulo posea una secuencia
		 * recibida por parametro
		 **/
		// La query a realizar
		String queryString = "from Serie s where s.titulo like :sec";
		// Abrimos la transaccion
		session = sessionFactory.openSession();
		// :sec sera seteado con la secuencia que recibimos por parametro
		Query seriesSec = session.createQuery(queryString).setString("sec",
				"%" + sec + "%");
		try {
			Transaction tx = session.beginTransaction();
			Iterator<?> s = seriesSec.iterate();
			tx.rollback();
			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("B. Listar las series cuyo titulo contenga una secuencia de caracteres (la secuencia es un parametro). Imprimir en consola: \"Titulo de la Serie: \"");
			System.out.println("Parametro: \"" + sec + "\"");
			System.out
					.println("----------------------------------------------------------------------");
			while (s.hasNext()) {
				Serie serie = (Serie) s.next();
				System.out.println("Titulo de la Serie: " + serie.getTitulo());
			}
			System.out
					.println("=======================================================================");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	private static void cincoEpisodiosMasVistos() {
		/**
		 * La consulta devuelve aquellos cinco episodios mas vistos de todo el
		 * sistema
		 **/
		// La query a realizar
		String queryString = "SELECT r, count(idReproducible) as cant "
				+ "FROM Reproduccion r "
				+ "WHERE r.reproducible.class ='model.Episodio' "
				+ "GROUP BY idReproducible " + "ORDER BY cant desc";

		session = sessionFactory.openSession();
		Query result = session.createQuery(queryString);
		result.setMaxResults(5);
		try {
			Transaction tx = session.beginTransaction(); // Abrimos transaccion
			Iterator<?> r = result.iterate(); // Iterador auxiliar para los
												// resultados
			tx.rollback();// Cerramos transaccion
			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("C. Listar los 5 episodios de series mas vistos en el sistema.");
			System.out
					.println("----------------------------------------------------------------------");
			while (r.hasNext()) {
				Object[] objects = (Object[]) r.next();
				Reproduccion repro = (Reproduccion) objects[0];
				Long cant = (Long) objects[1];
				System.out.println("Episodio:"
						+ repro.getReproducible().getTitulo()
						+ " ha sido visto " + cant + " veces");
			}

			System.out
					.println("=======================================================================");

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			session.close();
		}

	}

	private static void peliMasVista(String year) throws ParseException {
		/**
		 * La consulta devuelve aquella pelicula mas vista del sistema,
		 * recibiendo un anio por parametro
		 **/
		// La query a realizar
		String queryString = "SELECT r, count(idReproducible) as cant "
				+ "FROM Reproduccion r "
				+ "WHERE r.reproducible.class ='model.Pelicula' and r.fecha between :ini and :fin "
				+ "GROUP BY idReproducible " + "ORDER BY cant DESC";

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaIni = df.parse("01-01-" + year);
		Date fechaFin = df.parse("31-12-" + year);
		session = sessionFactory.openSession();
		try {
			Query result = session.createQuery(queryString)
					.setDate("ini", fechaIni).setDate("fin", fechaFin)
					.setMaxResults(1);

			Transaction tx = session.beginTransaction();
			Iterator<?> r = result.iterate();
			tx.rollback();

			System.out
					.println("-------------------------------------------------------------------");
			System.out
					.println("D. Informar la pelicula mas vista en un determinado anio (donde el anio es parametrizable).");
			System.out.println("Parametro: \"" + year + "\"");

			// Impresion del resultado.
			while (r.hasNext()) {
				Object[] objects = (Object[]) r.next();
				Reproduccion repro = (Reproduccion) objects[0];
				Long cant = (Long) objects[1];
				System.out
						.println("----------------------------------------------------------------------");
				System.out.println("Pelicula mas vista en el anio: " + year
						+ " es: " + repro.getReproducible().getTitulo() + " ("
						+ cant + " reproducciones)");
				System.out
						.println("=======================================================================");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	private static void masPeliculas(int _cantidadPeliculas) {
		/**
		 * La consulta devuelve aquellos usuarios que reprodujeron mas de
		 * _cantidadPeliculas recibido por parametro
		 **/
		String queryString = "SELECT user,count(user.idUsuario) AS cantidadReproducciones "
				+ "FROM Usuario user INNER JOIN user.gestor g "
				+ "INNER JOIN g.reproducciones r "
				+ "WHERE r.reproducible.class='model.Pelicula'"
				+ "GROUP BY (user.idUsuario) "
				+ "HAVING count(user.idUsuario) > :cantidadPeliculas "
				+ "ORDER BY cantidadReproducciones DESC";

		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			List result = session.createQuery(queryString)
					.setInteger("cantidadPeliculas", _cantidadPeliculas).list();
			Iterator<?> ite = result.iterator();
			tx.rollback();
			System.out
					.println("-------------------------------------------------------------------");
			System.out
					.println("E. Listar los usuarios que reprodujeron mas de n peliculas (donde n es parametrizable).");
			System.out.println("Parametro: \"" + _cantidadPeliculas + "\"");
			System.out
					.println("-------------------------------------------------------------------");

			while (ite.hasNext()) {
				Object[] objects = (Object[]) ite.next();
				Usuario user = (Usuario) objects[0];
				Long reproducciones = (Long) objects[1];
				System.out.println("Usuario " + user.getEmail()
						+ " ha realizado " + reproducciones
						+ " reproducciones.");
			}
			System.out
					.println("-------------------------------------------------------------------");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	private static void menos65Seg() {
		/**
		 * La consulta devuelve aquellos usuarios que vieron un episodio por mas
		 * de 65 segundos
		 **/

		// Abro sesion
		session = sessionFactory.openSession();
		// La query a realizar
		String queryString = "SELECT DISTINCT user.email "
				+ "FROM Usuario user INNER JOIN user.gestor g "
				+ "INNER JOIN g.reproducciones r "
				+ "WHERE r.reproducible.class='model.Episodio' "
				+ "AND r.tiempo < 65000" + "ORDER BY r.tiempo";

		Query result = session.createQuery(queryString);

		try {
			// Itero dentro de la transaccion
			Transaction tx = session.beginTransaction();
			Iterator<?> m = result.iterate();
			tx.rollback();

			// Imprimo
			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("F. Listar los usuarios que vieron al menos un episodio por menos de 65 segundos.");
			System.out
					.println("----------------------------------------------------------------------");

			// Imprimo iteracion
			while (m.hasNext()) {
				String mail = (String) m.next();
				System.out.println("Mail del usuario: " + mail);
			}
			System.out
					.println("=======================================================================");
		} catch (Exception e) {
			// Si hay error lo imprimo
			System.out.println(e.getMessage());
		} finally {
			// Si o si cierro la sesion
			session.close();
		}
	}

	private static void nMasVistas(Integer n) {
		/**
		 * El metodo lista aquellas peliculas mas vistas del sistema, (La
		 * cantidad se define por parametro)
		 **/
		// Abro sesion
		session = sessionFactory.openSession();
		// La query a realizar
		String queryString = "SELECT r, count(idReproducible) as cant "
				+ "FROM Reproduccion r "
				+ "WHERE r.reproducible.class='model.Pelicula' "
				+ "GROUP BY idReproducible ORDER BY cant DESC";

		Query result = session.createQuery(queryString).setMaxResults(n);

		try {
			// Itero dentro de la transaccion
			Transaction tx = session.beginTransaction();
			Iterator<?> r = result.iterate();
			tx.rollback();

			// Imprimo
			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("G. Listar las n peliculas mas vistas en el sistema.");
			System.out.println("Parametro n: \"" + n + "\"");
			System.out
					.println("----------------------------------------------------------------------");

			// Imprimo iteracion
			while (r.hasNext()) {
				Object[] objects = (Object[]) r.next();
				Reproduccion rep = (Reproduccion) objects[0];
				Long reproducciones = (Long) objects[1];
				System.out.println("La Pelicula: "
						+ rep.getReproducible().getTitulo()
						+ " ha sido vista: " + reproducciones + " veces");
			}
			System.out
					.println("=======================================================================");
		} catch (Exception e) {
			// Si hay error lo imprimo
			System.out.println(e.getMessage());
		} finally {
			// Si o si cierro la sesion
			session.close();
		}
	}

	private static void usuariosVieronEpi(String titulo) {
		/**
		 * El metodo lista aquellos usuarios que vieron determinado episodio,
		 * cuyo titulo se recibe por parametro
		 **/
		// Abro sesion
		session = sessionFactory.openSession();
		// La query a realizar
		String queryString = "SELECT DISTINCT user.email "
				+ "FROM Usuario user INNER JOIN user.gestor g "
				+ "INNER JOIN g.reproducciones r "
				+ "WHERE r.reproducible.class='model.Episodio' "
				+ "AND r.reproducible.id = "
				+ "( SELECT id FROM Episodio WHERE titulo=:titu )";

		Query result = session.createQuery(queryString).setString("titu",
				titulo);

		try {
			// Itero dentro de la transaccion
			Transaction tx = session.beginTransaction();
			Iterator<?> r = result.iterate();
			tx.rollback();

			// Imprimo
			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("H. Listar los usuarios que vieron un episodio cuyo titulo se ingresa por parametro.");
			System.out.println("Parametro titulo: \"" + titulo + "\"");
			System.out
					.println("----------------------------------------------------------------------");

			// Imprimo iteracion
			while (r.hasNext()) {
				String mail = (String) r.next();
				System.out.println("Mail del usuario: " + mail);
			}
			System.out
					.println("=======================================================================");
		} catch (Exception e) {
			// Si hay error lo imprimo
			System.out.println(e.getMessage());
		} finally {
			// Si o si cierro la sesion
			session.close();
		}
	}

	private static void usuariosPeliMenor12() {
		/**
		 * Este metodo lista aquellos usuarios que visualizaron una pelicula
		 * cuya edad minima sea 12 anios
		 **/
		// Abro sesion
		session = sessionFactory.openSession();
		// La query a realizar
		String queryString = "SELECT DISTINCT user.email "
				+ "FROM Usuario user INNER JOIN user.gestor g "
				+ "INNER JOIN g.reproducciones r "
				+ "WHERE r.reproducible.class='model.Pelicula' "
				+ "AND r.reproducible.id in "
				+ "( SELECT id FROM Pelicula WHERE edadMinima=12)";

		Query result = session.createQuery(queryString);

		try {
			// Itero dentro de la transaccion
			Transaction tx = session.beginTransaction();
			Iterator<?> r = result.iterate();
			tx.rollback();

			// Imprimo
			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("I. Listar usuarios que reprodujeron al menos una pelicula cuya edad minima sea 12 anios.");
			System.out
					.println("----------------------------------------------------------------------");

			// Imprimo iteracion
			while (r.hasNext()) {
				String mail = (String) r.next();
				System.out.println("Mail del usuario: " + mail);
			}
			System.out
					.println("=======================================================================");
		} catch (Exception e) {
			// Si hay error lo imprimo
			System.out.println(e.getMessage());
		} finally {
			// Si o si cierro la sesion
			session.close();
		}
	}

	private static void limiteReproducciones(Integer cant) {
		/**
		 * Lista aquellos usuarios que esten a una determinada cantidad de
		 * llegar al limite de reproducciones, la cantidad se recibe por
		 * parametro
		 **/
		// Abro sesion
		session = sessionFactory.openSession();
		// La query a realizar

		String queryString = "from Usuario u where u.suscripcion.Categoria.limiteReproducciones - size(u.gestor.reproducciones) < :cant";

		Query result = session.createQuery(queryString)
				.setInteger("cant", cant);

		try {
			// Itero dentro de la transaccion
			Transaction tx = session.beginTransaction();
			Iterator<?> r = result.iterate();
			tx.rollback();

			// Imprimo
			System.out
					.println("----------------------------------------------------------------------");
			System.out
					.println("J. Listar los usuarios que esten a menos de una cantidad dada de reproducciones para llegar al limite de las mismas para su categoria.");
			System.out.println("Parametro cantidad: \"" + cant + "\"");
			System.out
					.println("----------------------------------------------------------------------");

			// Imprimo iteracion
			while (r.hasNext()) {
				Usuario o = (Usuario) r.next();
				System.out.println("Mail del usuario: " + o.getEmail());
			}
			System.out
					.println("=======================================================================");
		} catch (Exception e) {
			// Si hay error lo imprimo
			System.out.println(e.getMessage());
		} finally {
			// Si o si cierro la sesion
			session.close();
		}
	}

}
