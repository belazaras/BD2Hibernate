package model;

public class Categoria {

	// Identificador
	private Long idCategoria;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	// Variables de instancia
	protected int limiteReproducciones;

	// Constructores
	public Categoria() {
		this.limiteReproducciones = 100;
	}

	public Categoria(int limiteReproducciones) {
		this.limiteReproducciones = limiteReproducciones;
	}

	// Métodos

	public int limiteDeReproducciones() {
		return this.limiteReproducciones;
	}
}
