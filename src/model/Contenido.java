package model;

public abstract class Contenido {

	// Identificador
	private Long idContenido;

	public Long getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(Long idContenido) {
		this.idContenido = idContenido;
	}

	// Variables de instancia
	protected String titulo;
	protected int edadMinima;

	// Constructores
	public Contenido() {

	}

	public Contenido(String titulo, int edadMinima) {
		this.titulo = titulo;
		this.edadMinima = edadMinima;
	}

	// Metodos
	public String getTitulo() {
		return this.titulo;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public abstract boolean esPelicula();

	public abstract boolean esSerie();

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	
}
