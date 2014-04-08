package model;
import java.util.*;
public class Reproduccion {
	
	/**Variables de instancia**/
	private Date fecha;
	private long tiempo;
	private Reproducible reproducible;
	
	//Constructor
	public Reproduccion(Reproducible reproducible, Date fecha, long tiempo){
		this.reproducible=reproducible;
		this.fecha=fecha;
		this.tiempo=tiempo;
	}
	
	/**Métodos**/
	
	public Date getFecha() {
		return fecha;
	}
	public long getTiempo() {
		return tiempo;
	}
	public Reproducible getReproducible() {
		return reproducible;
	}
	
	
}
