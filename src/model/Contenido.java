package model;

public abstract class Contenido {

	//Variables de instancia
	protected String titulo;
	protected int edadMinima;
	
	//Constructores
	public Contenido(String titulo,int edadMinima){
		this.titulo=titulo;
		this.edadMinima=edadMinima;
	}
	
	//Metodos
	public String getTitulo(){
		return this.titulo;
	}

	public int getEdadMinima(){
		return edadMinima;
	}
	
	public abstract boolean esPelicula();
	
	public abstract boolean esSerie();

	
	
	
}
