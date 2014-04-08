package model;

public class Categoria {

	//Variables de instancia
	protected int limiteReproducciones; 
	
	//Constructores
	public Categoria(){
		this.limiteReproducciones=100;
	}
	
	public Categoria(int limiteReproducciones){
		this.limiteReproducciones=limiteReproducciones;
	}
	
	//Métodos
	
	public int limiteDeReproducciones(){
		return this.limiteReproducciones;
	}
}
