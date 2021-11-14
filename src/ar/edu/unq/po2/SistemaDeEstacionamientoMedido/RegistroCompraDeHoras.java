package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class RegistroCompraDeHoras extends Registro {
	

	// Esta clase act�a como Data Class ya que es la representaci�n de un registro fisico
	
	private int horas;

	public RegistroCompraDeHoras(int numControl, PuntoDeVenta puntoDeVenta, LocalDateTime fechaYHora, int horas) {
		super.numeroDeControl = numControl;
		super.puntoDeVenta    = puntoDeVenta;
		super.fechaYHora      = fechaYHora;
		this.horas           = horas;
	}
}
