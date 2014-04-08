package model;

public class Episodio implements Reproducible {

	/**Variables de instancia**/
	private long duracion;
	private int numero;
	private String titulo;
	private Temporada temporada;
	
	//Constructor
	
	public Episodio(long duracion, int numero, String titulo, Temporada temporada){
		
		this.duracion=duracion;
		this.numero=numero;
		this.titulo=titulo;
		this.temporada=temporada;
		this.temporada.agregarEpisodio(this);//Agrega el episodio recién creado a la temporada		
	}
	
	
	/**Métodos**/
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

	public int getNumero(){
		return this.numero;
	}
	
	public Temporada getTemporada(){
		return this.temporada;
	}
	
	
}
