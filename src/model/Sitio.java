package model;

import java.util.*;

public class Sitio {

	/** Variables de instancia **/
	private Catalogo catalogo;
	private Collection<Usuario> usuarios;
	private int idSitio;

	/** Constructor **/

	public Sitio() {
		this.catalogo = new Catalogo();
		this.usuarios = new ArrayList<Usuario>();
	}

	/** Metodos **/

	public Collection<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void registrarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public int getIdSitio() {
		return idSitio;
	}

	public void setIdSitio(int idSitio) {
		this.idSitio = idSitio;
	}

}
