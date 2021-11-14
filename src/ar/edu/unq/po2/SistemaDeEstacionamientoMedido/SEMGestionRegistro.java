package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SEMGestionRegistro {

	private ArrayList<Registro> registros;
	private int ultimoNumControl = 0;
	
	public SEMGestionRegistro() {
		super();
		this.registros = new ArrayList<Registro>();
	}
	
	public void registrarCompraCredito(int numTelefono, int credito, PuntoDeVenta puntoDeVenta) {
		LocalDateTime fechaYHora = LocalDateTime.now();
		RegistroDeRecarga registro = new RegistroDeRecarga(this.ultimoNumControl, puntoDeVenta, fechaYHora, numTelefono, credito);
		
		this.agregarRegistro(registro);
	}

	public void registrarCompraDeHoras(int horas, PuntoDeVenta puntoDeVenta) {
		LocalDateTime fechaYHora = LocalDateTime.now();
		RegistroCompraDeHoras registro = new RegistroCompraDeHoras(this.ultimoNumControl, puntoDeVenta, fechaYHora, horas);
		
		this.agregarRegistro(registro);
	}	
	
	private void agregarRegistro(Registro registro) {
		this.registros.add(registro);
		ultimoNumControl ++;
	}

	public int getCantidadDeRegistros() {
		return this.registros.size();
	}

	public ArrayList<Registro> getRegistros() {
		return registros;
	}
	
}
