package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos;

import java.time.LocalDateTime;

public class Infraccion {
	
	//Sería un Data Class porque representa un archivo en una base de datos del SEM
	
	private String patente;
	private String inspector;
	private Zona zona;
	private LocalDateTime fechaYHora;
	
	public Infraccion(String patente, Zona zona) {
		super();
		this.patente    = patente;
		this.inspector  = zona.getInspector();
		this.zona       = zona;
		this.fechaYHora = LocalDateTime.now();
	}
	
	public String getInspector() {
		return inspector;
	}

	public Zona getZona() {
		return zona;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	
	public String getPatente() {
		return patente;
	}
}
