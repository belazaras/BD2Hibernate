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
	
	//M�todos
	
	public int limiteReproducciones(){
		return this.limiteReproducciones;
	}
	
	
	

}
