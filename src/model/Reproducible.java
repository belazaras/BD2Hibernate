package model;

public interface Reproducible {

	public abstract String getTitulo();
	
	public abstract long getDuracion();
	
	public abstract int getEdadMinima();

	public abstract boolean aptoPara(Usuario usuario);
	
	public abstract boolean esPelicula();
	
	public abstract boolean esEpisodio();




}
