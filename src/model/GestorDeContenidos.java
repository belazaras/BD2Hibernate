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
		return null;
	}
	
	public Collection<Pelicula> peliculasVistas(){
		return null;
	}
	
	public Collection<Episodio> episodiosSinVerDe(Temporada temporada){
		return null;
	}
	
	public Collection<Pelicula> peliculasAptas(){
		return null;
	}
	
	
	public void registrarReproduccion(Reproducible reproducible, Date fecha, long tiempo){
		
	}
	
	public boolean puedeReproducir(Reproducible reproducible){
		return false;
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
