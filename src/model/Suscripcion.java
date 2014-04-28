package model;

import java.util.*;

public class Suscripcion {

	/**Variables de instancia **/
	private Categoria categoria;
	private Date fecha;
	/**Constructores**/
	
	public Suscripcion(){
		
	}
	
	public Suscripcion(Date fecha){
		this.categoria = new CategoriaInvitado();
		this.fecha=fecha;
	}
	
	/** M�todos **/
	
	public Date getFecha(){
		return this.fecha;
	}
	
	public void pasarANormal(){
		this.categoria= new Categoria();
	}
	
	public void pasarAVIP(){
		this.categoria= new CategoriaVIP();
	}
	
	public int limiteDeReproducciones(){
		return this.categoria.limiteDeReproducciones();
	}

	public Categoria getCategoria(){
		return this.categoria;
	}

}
