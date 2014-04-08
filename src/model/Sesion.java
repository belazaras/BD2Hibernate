package model;
import java.util.*;
public class Sesion {
	
	//Variables de instancia
	private Date fecha;
	private Reproduccion reproduccion;
	
	//Constructores
	public Sesion(Reproduccion reproduccion, Date fecha){
		this.reproduccion=reproduccion;
		this.fecha=fecha;
	}
	
	//Metodos
	public Date getFecha() {
		return this.fecha;
	}
	
	public Reproduccion getReproduccion(){
		return this.reproduccion;
	}
}
