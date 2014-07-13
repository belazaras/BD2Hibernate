package model;

public class Episodio implements Reproducible {

	// Identificador
	private Long idEpisodio;

	public Long getIdEpisodio() {
		return idEpisodio;
	}

	public void setIdEpisodio(Long idEpisodio) {
		this.idEpisodio = idEpisodio;
	}

	/** Variables de instancia **/
	private long duracion;
	private int numero;
	private String titulo;
	private Temporada temporada;

	// Constructor

	public Episodio() {

	}

	public Episodio(long duracion, int numero, String titulo,
			Temporada temporada) {

		this.duracion = duracion;
		this.numero = numero;
		this.titulo = titulo;
		this.temporada = temporada;
		this.temporada.agregarEpisodio(this);// Agrega el episodio recien creado
												// a la temporada
	}

	/** Metodos **/
	@Override
	public String getTitulo() {
		// TODO Auto-generated method stub
		return this.titulo;
	}

	@Override
	public long getDuracion() {
		// TODO Auto-generated method stub
		return this.duracion;
	}

	@Override
	public int getEdadMinima() {
		return this.getTemporada().getEdadMinima();
	}

	@Override
	public boolean aptoPara(Usuario usuario) {
		return usuario.edad() >= this.getEdadMinima();
	}

	@Override
	public boolean esPelicula() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esEpisodio() {
		// TODO Auto-generated method stub
		return true;
	}

	public int getNumero() {
		return this.numero;
	}

	public Temporada getTemporada() {
		return this.temporada;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

}
