package model;
import java.util.*;
public class Temporada {

	/**Variables de instancia**/
	private Serie serie;
	private int numero;
	private Collection<Episodio> episodios;
	private int idTemporada;
	//Constructores
	public Temporada(){
		
	}
	
	public Temporada(Serie serie, int numero){
		this.episodios = new ArrayList<Episodio>();
		this.serie=serie;
		this.numero=numero;
		this.serie.agregarTemporada(this);
	}
	
	/**M�todos**/
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

	public int getIdTemporada() {
		return idTemporada;
	}

	public void setIdTemporada(int idTemporada) {
		this.idTemporada = idTemporada;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setEpisodios(Collection<Episodio> episodios) {
		this.episodios = episodios;
	}
	
	
}
