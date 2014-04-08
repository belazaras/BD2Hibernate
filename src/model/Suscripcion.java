package model;

import java.util.*;

public class Suscripcion {

	/**Variables de instancia **/
	private Categoria categoria;
	private Date fecha;
	/**Constructores**/
	
	Suscripcion(Date fecha){
		this.categoria = new CategoriaInvitado();
		this.fecha=fecha;
	}
	
	/** Métodos **/
	
	public Date getFecha(){
		return this.fecha;
	}
	
	public void pasarANormal(){
		this.categoria= new Categoria();
	}
	
	public void pasarAVIP(){
		this.categoria= new CategoriaVIP();
	}
	
	public int limiteReproducciones(){
		return this.categoria.limiteReproducciones();
	}

	public Categoria getCategoria(){
		return this.categoria;
	}

}
