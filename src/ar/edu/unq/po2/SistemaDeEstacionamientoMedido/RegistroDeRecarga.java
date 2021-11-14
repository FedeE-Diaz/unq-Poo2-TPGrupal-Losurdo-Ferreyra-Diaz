package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class RegistroDeRecarga extends Registro {

	// Esta clase act�a como Data Class ya que es la representaci�n de un registro fisico
	
	private int credito;
	private int numeroTelefono;

	public RegistroDeRecarga(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDateTime fechaYHora, int numTelefono,
			int credito) {
		super.numeroDeControl = numeroControl;
		super.puntoDeVenta  = puntoDeVenta;
		super.fechaYHora    = fechaYHora;
		this.numeroTelefono = numTelefono;
		this.credito = credito;
	}
}
