package model;

public class CategoriaVIP extends Categoria {

	// Constructores
	public CategoriaVIP() {
		this.limiteReproducciones = 500;
	}

	public CategoriaVIP(int limite) {
		this.limiteReproducciones = limite;
	}

	// Metodos
	@Override
	public int limiteDeReproducciones() {
		// TODO Auto-generated method stub
		return this.limiteReproducciones;
	}

}
