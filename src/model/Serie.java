package model;

import java.util.*;

public class Serie extends Contenido implements Reproducible {

	// Identificador
	private Long idSerie;

	public Long getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}

	/** Variables de instancia **/
	private Collection<Temporada> temporadas;

	/** Constructor **/
	public Serie() {

	}

	public Serie(String titulo, int edadMinima) {
		super(titulo, edadMinima);
		this.temporadas = new ArrayList<Temporada>();
	}

	@Override
	public long getDuracion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean aptoPara(Usuario usuario) {

		return (usuario.edad() >= edadMinima);
	}

	@Override
	public boolean esEpisodio() {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<Temporada> getTemporadas() {
		return this.temporadas;
	}

	@Override
	public boolean esPelicula() {
		return false;
	}

	@Override
	public boolean esSerie() {
		return true;
	}

	public void agregarTemporada(Temporada temporada) {
		this.temporadas.add(temporada);
	}

}
