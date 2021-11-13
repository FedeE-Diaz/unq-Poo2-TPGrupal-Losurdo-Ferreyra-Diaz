package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class Infraccion {
	
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
	
	public String getPatente() {
		return patente;
	}
}
