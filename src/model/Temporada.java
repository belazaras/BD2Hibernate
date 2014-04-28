package model;
import java.util.*;
public class Temporada {

	/**Variables de instancia**/
	private Serie serie;
	private int numero;
	private Collection<Episodio> episodios;
	
	//Constructores
	public Temporada(){
		
	}
	
	public Temporada(Serie serie, int numero){
		this.episodios = new ArrayList<Episodio>();
		this.serie=serie;
		this.numero=numero;
		this.serie.agregarTemporada(this);
	}
	
	/**Métodos**/
	public Serie getSerie(){
		return this.serie;
	}
	
	public int getNumero(){
		return this.numero;
	}

	public void agregarEpisodio(Episodio episodio){
		this.episodios.add(episodio);
	}
	
	public int getEdadMinima(){
		return this.serie.getEdadMinima();
	}
	
	public Collection<Episodio> getEpisodios(){
		return this.episodios;
	}

}
