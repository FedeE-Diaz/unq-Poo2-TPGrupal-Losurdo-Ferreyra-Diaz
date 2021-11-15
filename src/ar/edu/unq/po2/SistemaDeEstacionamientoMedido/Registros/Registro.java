package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Registros;

import java.time.LocalDateTime;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.PuntoDeVenta;

public abstract class Registro {
	
	// Esta clase act�a como Data Class ya que es la representaci�n de un registro fisico
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
