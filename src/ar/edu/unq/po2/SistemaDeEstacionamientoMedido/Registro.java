package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public abstract class Registro {
	
	// Esta clase actúa como Data Class ya que es la representación de un registro fisico
	protected int numeroDeControl;
	protected LocalDateTime fechaYHora;
	protected PuntoDeVenta puntoDeVenta;
	
	public int getNumeroDeControl() {
		return numeroDeControl;
	}
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}
}
