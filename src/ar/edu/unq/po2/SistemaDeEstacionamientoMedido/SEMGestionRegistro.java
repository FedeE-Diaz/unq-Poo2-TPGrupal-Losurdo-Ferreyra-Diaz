package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SEMGestionRegistro {

	private ArrayList<RegistroDeRecarga> registros;
	private int ultimoNumControl = 0;
	
	public SEMGestionRegistro() {
		super();
		this.registros = new ArrayList<RegistroDeRecarga>();
	}

	public void registrarCompraCredito(int numTelefono, int credito, PuntoDeVenta puntoDeVenta) {
		LocalDateTime fechaYHora = LocalDateTime.now();
		RegistroDeRecarga registro = new RegistroDeRecarga(this.ultimoNumControl, puntoDeVenta, fechaYHora, numTelefono, credito);
		
		this.registros.add(registro);
		ultimoNumControl +=1;
	}	
}
