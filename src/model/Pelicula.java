package model;

public class Pelicula extends Contenido implements Reproducible {

	// Identificador
	private Long idPelicula;

	public Long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}

	// Variables de instancia
	private long duracion;

	/** Constructores **/
	public Pelicula() {

	}

	public Pelicula(String titulo, int edadMinima, long duracion) {
		super(titulo, edadMinima);
		this.duracion = duracion;
	}

	/** Métodos **/
	@Override
	public long getDuracion() {
		// TODO Auto-generated method stub
		return this.duracion;
	}

	@Override
	public boolean aptoPara(Usuario usuario) {

		return usuario.edad() >= this.edadMinima;
	}

	@Override
	public boolean esEpisodio() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean esPelicula() {
		return true;
	}

	public boolean esSerie() {
		return false;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}
	
}
