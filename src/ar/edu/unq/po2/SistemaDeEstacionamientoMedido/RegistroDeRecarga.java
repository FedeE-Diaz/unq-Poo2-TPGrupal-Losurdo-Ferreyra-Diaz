package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class RegistroDeRecarga {

	private int numeroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDateTime fechaYHora;
	private int numeroTelefono;
	private int credito;

	public RegistroDeRecarga(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDateTime fechaYHora, int numTelefono,
			int credito) {
		this.numeroControl = numeroControl;
		this.puntoDeVenta  = puntoDeVenta;
		this.fechaYHora    = fechaYHora;
		this.numeroTelefono = numTelefono;
		this.credito = credito;
	}
}
