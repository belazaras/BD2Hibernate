package model;
import java.util.*;
public class GestorDeContenidos {

	//Variables de instancia
	private Usuario usuario;
	private Catalogo catalogo;
	private Collection<Reproduccion> reproducciones;
	
	//Constructores
	public GestorDeContenidos(Usuario usuario, Catalogo catalogo){
		this.usuario=usuario;
		this.catalogo=catalogo;
		this.reproducciones= new ArrayList<Reproduccion>();	
	}
	
	//Métodos
	public Collection<Episodio> episodiosVistos(){
		Collection<Episodio> epis = new ArrayList<Episodio>();
		Iterator<Reproduccion> it = this.reproducciones.iterator();
		while (it.hasNext()) {
			Reproduccion elemento = it.next();
			if (elemento.getReproducible().esEpisodio()) {
			Episodio e = (Episodio) elemento.getReproducible();
			epis.add(e);
			}
		}	
		return epis;
	}
	
	public Collection<Pelicula> peliculasVistas(){
		Collection<Pelicula> pelis = new ArrayList<Pelicula>();
		Iterator<Reproduccion> it = this.reproducciones.iterator();
		while (it.hasNext()) {
			Reproduccion elemento = it.next();
			if (elemento.getReproducible().esPelicula()) {
				Pelicula e = (Pelicula) elemento.getReproducible();
				pelis.add(e);
			}
		}	
		return pelis;
	}
	
	public Collection<Episodio> episodiosSinVerDe(Temporada temporada){
		Collection<Episodio> epis = new ArrayList<Episodio>();
		Iterator<Episodio> it = temporada.getEpisodios().iterator();
		
		while (it.hasNext()) {
			Episodio elemento = it.next();
			if (!this.episodiosVistos().contains(elemento)){
				epis.add(elemento);
			}
		}
	
		return epis;
	}
	
	public Collection<Pelicula> peliculasAptas(){	
		Collection<Pelicula> pelisTodas = this.catalogo.getPeliculas();
		Collection<Pelicula> pelisPuede = new ArrayList<Pelicula>();
		Iterator<Pelicula> it = pelisTodas.iterator();
		
		while (it.hasNext()) {
			Pelicula elemento = it.next();
			if (this.getUsuario().edad() >= elemento.getEdadMinima()) {
				pelisPuede.add(elemento);
			}
		}	
		return pelisPuede;
	}
	
	
	public void registrarReproduccion(Reproducible reproducible, Date fecha, long tiempo){
		Reproduccion r = new Reproduccion(reproducible,fecha,tiempo);
		this.reproducciones.add(r);
	}
	
	public boolean puedeReproducir(Reproducible reproducible){
		return this.getUsuario().edad() >= reproducible.getEdadMinima() &&
		this.cantidadDeReproducciones() < this.getUsuario().getSuscripcion().limiteDeReproducciones();
	}
	
	private int cantidadDeReproducciones() {
		return this.reproducciones.size();
	}
	
	public Collection<Reproduccion> getReproducciones(){
		return this.reproducciones;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public Catalogo getCatalogo(){
		return this.catalogo;
	}
	
	
	
	
	
}
