package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class RegistroCompraDeHoras extends Registro {
	

	// Esta clase actúa como Data Class ya que es la representación de un registro fisico
	
	private int horas;

	public RegistroCompraDeHoras(int numControl, PuntoDeVenta puntoDeVenta, LocalDateTime fechaYHora, int horas) {
		super.numeroDeControl = numControl;
		super.puntoDeVenta    = puntoDeVenta;
		super.fechaYHora      = fechaYHora;
		this.horas           = horas;
	}
}
