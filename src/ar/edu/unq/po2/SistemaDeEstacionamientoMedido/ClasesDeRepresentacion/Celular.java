package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion;

public class Celular {

	private int numero;
	private GPS gps;
	
	public Celular(int numero) {
		this.numero = numero;
		this.gps = new GPS();
	}
	public int getNumero() {
		return numero;
	}
	public GPS getGPS() {
		return gps; 
	}
	public Punto getPunto() {
		return this.gps.getUbicacionActual();
		
	}
	
}
