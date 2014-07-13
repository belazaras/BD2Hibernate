package model;

import java.util.*;

public class Sesion {

	// Variables de instancia
	private Date fecha;
	private Reproduccion reproduccion;
	private int idSesion;

	// Constructores
	public Sesion() {

	}

	public Sesion(Reproduccion reproduccion, Date fecha) {
		this.reproduccion = reproduccion;
		this.fecha = fecha;
	}

	// Metodos
	public Date getFecha() {
		return this.fecha;
	}

	public Reproduccion getReproduccion() {
		return this.reproduccion;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setReproduccion(Reproduccion reproduccion) {
		this.reproduccion = reproduccion;
	}

}
