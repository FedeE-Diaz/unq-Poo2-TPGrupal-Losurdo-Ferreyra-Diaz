package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class Infraccion {
	
	//Sería un Data Class porque representa un archivo en una base de datos del SEM
	
	private String patente;
	private Inspector inspector;
	private Zona zona;
	private LocalDateTime fechaYHora;
	
	public Infraccion(String patente, Inspector inspector, Zona zona) {
		super();
		this.patente    = patente;
		this.inspector  = inspector;
		this.zona       = zona;
		this.fechaYHora = LocalDateTime.now();
	}
	
	public Inspector getInspector() {
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
