package model;

import java.util.*;

public class Usuario {

	/** Variables de instancia **/
	private String email;
	private Date fechaNacimiento;
	private Sesion sesionActual;
	private GestorDeContenidos gestor;
	private Suscripcion suscripcion;
	private Long idUsuario;

	/** Constructor/es **/

	public Usuario() {

	}

	public Usuario(Date nacimiento, String email, Date fechaSuscripcion,
			Catalogo catalogo) {
		this.fechaNacimiento = nacimiento;
		this.email = email;
		this.suscripcion = new Suscripcion(fechaSuscripcion);
		this.gestor = new GestorDeContenidos(this, catalogo);
		this.sesionActual = null;
	}

	/** Metodos **/

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int edad() {
		// Devuelve la edad de un usuario.
		Calendar fechaNacimiento = Calendar.getInstance();
		Calendar fechaActual = Calendar.getInstance();
		fechaNacimiento.setTime(this.fechaNacimiento); // Parseamos la fecha
		int anio = fechaActual.get(Calendar.YEAR)
				- fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaActual.get(Calendar.MONTH)
				- fechaNacimiento.get(Calendar.MONTH);
		int dia = fechaActual.get(Calendar.DATE)
				- fechaNacimiento.get(Calendar.DATE);

		if (mes < 0 || (mes == 0 && dia < 0)) {
			// Importante dado que Enero comienza con el mes 0, y diciembre con
			// el 11.
			anio--;
		}

		return anio;

	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public GestorDeContenidos getGestor() {
		return this.gestor;
	}

	public void setGestor(GestorDeContenidos gestor) {
		this.gestor = gestor;
		/**
		 * if (this.gestor.getUsuario() != this) this.gestor.setUsuario(this);
		 **/
	}

	public Suscripcion getSuscripcion() {
		return this.suscripcion;
	}

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}

	public Sesion getSesionActual() {
		return sesionActual;
	}

	public void setSesion(Sesion sesionActual) {
		this.sesionActual = sesionActual;
	}

	public void setSesionActual(Sesion sesionActual) {
		this.sesionActual = sesionActual;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
