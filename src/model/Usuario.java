package model;

import java.util.*;

public class Usuario {
	
	/** Variables de instancia **/
	private String email;
	private Date fechaNacimiento;
	private Sesion sesionActual;
	private GestorDeContenidos gestor;
	private Suscripcion suscripcion;
	private Catalogo catalogo;
	
	/**Constructor/es**/
	
	public Usuario(){
		
	}
	
	public Usuario(Date nacimiento, String email, Date fechaSuscripcion, Catalogo catalogo){
		this.fechaNacimiento= nacimiento;
		this.email= email;
		this.catalogo= catalogo;
		this.suscripcion= new Suscripcion(fechaSuscripcion);
		this.gestor=new GestorDeContenidos(this,catalogo);
		this.sesionActual=null;
	}
	
	
	/**Métodos**/
	public String getEmail() {
		return this.email;
	}
	
	public int edad() {
		
		Calendar fechaNacimiento = Calendar.getInstance();
		Calendar fechaActual = Calendar.getInstance();
		fechaNacimiento.setTime(this.fechaNacimiento); //Parseamos la fecha
		int año=fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
		int mes=fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
		int dia= fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
		
		if(mes<0 || (mes==0 && dia<0)){
			//Importante dado que Enero comienza con el mes 0, y diciembre con el 11.
			año--;
		}

		return año;  
		
	}
	
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public GestorDeContenidos getGestor() {
		return this.gestor;
	}
	
	public Suscripcion getSuscripcion() {
		return this.suscripcion;
	}
	
	public Sesion getSesionActual() {
		return sesionActual;
	}

	public void setSesionActual(Sesion sesionActual) {
		this.sesionActual = sesionActual;
	}
	
	
}
