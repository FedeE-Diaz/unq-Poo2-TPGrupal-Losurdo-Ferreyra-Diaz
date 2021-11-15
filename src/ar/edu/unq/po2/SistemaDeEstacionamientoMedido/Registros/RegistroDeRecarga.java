package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Registros;

import java.time.LocalDateTime;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.PuntoDeVenta;

public class RegistroDeRecarga extends Registro {

	// Esta clase actúa como Data Class ya que es la representación de un registro fisico
	
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
