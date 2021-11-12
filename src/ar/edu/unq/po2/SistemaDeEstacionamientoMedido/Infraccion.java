package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class Infraccion {
	
	private String patente;
	private LocalDateTime fechaYHora;
	
	public Infraccion(String patente) {
		super();
		this.patente = patente;
		this.fechaYHora = LocalDateTime.now();
	}
	public String getPatente() {
		return patente;
	}
}
