package model;

public class Pelicula extends Contenido implements Reproducible {
	
	//Variables de instancia
	private long duracion;

	/**Constructor**/
	public Pelicula(String titulo, int edadMinima, long duracion){
		super(titulo,edadMinima);
		this.duracion=duracion;
	}
	/**Métodos**/
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
	
	
	public boolean esPelicula(){
		return true;
	}

	public boolean esSerie() {
		return false;
	}
	
	
	
	
	
}
