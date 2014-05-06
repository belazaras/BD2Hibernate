package model;

import java.util.*;

public class Reproduccion {

	// Identificador
	private Long idReproduccion;

	public Long getIdReproduccion() {
		return idReproduccion;
	}

	public void setIdReproduccion(Long idReproduccion) {
		this.idReproduccion = idReproduccion;
	}

	/** Variables de instancia **/
	private Date fecha;
	private long tiempo;
	private Reproducible reproducible;

	// Constructor
	public Reproduccion() {

	}

	public Reproduccion(Reproducible reproducible, Date fecha, long tiempo) {
		this.reproducible = reproducible;
		this.fecha = fecha;
		this.tiempo = tiempo;
	}

	/** Métodos **/

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
