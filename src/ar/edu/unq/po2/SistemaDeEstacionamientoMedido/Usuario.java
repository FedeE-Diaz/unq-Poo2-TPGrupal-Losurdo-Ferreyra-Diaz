package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class Usuario {

	private int numTelefonoAsociado;
	private int credito;
	
	public Usuario(int numTelefonoAsociado, int credito) {
		super();
		this.numTelefonoAsociado = numTelefonoAsociado;
		this.credito = credito;
	}
	
	public int getNumTelefonoAsociado() {
		return numTelefonoAsociado;
	}
	public int getCredito() {
		return credito;
	}
	
}
