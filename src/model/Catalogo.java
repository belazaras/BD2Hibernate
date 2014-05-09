package model;
import java.util.*;
public class Catalogo {

	/** Variables de instancia **/
	private Collection<Contenido> contenidos;
	private Long idCatalogo;
	
	/**Constructor/es**/
	public Catalogo(){
		
		this.contenidos= new HashSet<Contenido>();
	}
	
	
	/**Métodos**/
	public Collection<Contenido> getContenidos(){
		return this.contenidos;
	}

	public void setContenidos(Collection<Contenido> contenidos) {
		this.contenidos = contenidos;
	}
	
	public Long getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(Long idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	
	public Collection<Pelicula> getPeliculas(){
		Collection<Pelicula> pelis = new HashSet<Pelicula>();
		Iterator<Contenido> it = this.contenidos.iterator();
		while (it.hasNext()) {
		  Contenido elemento = it.next();
		  if (elemento.esPelicula()) {
			  Pelicula e = (Pelicula) elemento;
			  pelis.add(e);
		      }
		  }
		return pelis;		
	}

	public Collection<Serie> getSeries(){
		Collection<Serie> series = new HashSet<Serie>();
		Iterator<Contenido> it = this.contenidos.iterator();
		while (it.hasNext()) {
		  Contenido elemento = it.next();
		  if (elemento.esSerie()) {
			  Serie e = (Serie) elemento;
			  series.add(e);
		      }
		  }
		return series;
	}

	public void agregar(Contenido contenido){
	  this.contenidos.add(contenido);	
	}
	

}
