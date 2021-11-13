package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

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
	
	public Zona getPosicion() {
		gps.getZona(); // esta vendria a ser la representacion de la obtencion de la zona pero quiza no es necesario
	}
	public GPS getGPS() {
		return gps; // creo q con esto directamente, ya estaria en vez del getPosicion()
	}
	
}
