package model;

import java.util.*;


public class Sitio {


	/** Variables de instancia **/
	private Catalogo catalogo;
	private Collection<Usuario> usuarios;

	/** Constructor **/
	
	public Sitio(){
		this.catalogo = new Catalogo();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	/** Métodos **/

	
	public Collection<Usuario> getUsuarios() {
	  return this.usuarios;		
	}
	
	public void registrarUsuario(Usuario usuario) {
	  	this.usuarios.add(usuario);
	}
	
	public Catalogo getCatalogo() {
		return this.catalogo;
	}
	
	
	
	
	

}
