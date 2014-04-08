package model;
import java.util.*;
public class Catalogo {

	private Collection<Contenido> contenidos;
	
	public Catalogo(){
		
		this.contenidos= new HashSet<Contenido>();
	}
	
	public Collection<Contenido> getContenidos(){
		return this.contenidos;
	}

	public Collection<Pelicula> getPeliculas(){
		//return null;
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
