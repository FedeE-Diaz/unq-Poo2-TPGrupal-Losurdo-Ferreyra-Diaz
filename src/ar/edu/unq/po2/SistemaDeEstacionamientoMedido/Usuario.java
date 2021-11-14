package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class Usuario {

	private int numTelefonoAsociado;
	private int credito;
	private App app;
	
	public Usuario(int numTelefonoAsociado, int credito, App app) {
		super();
		this.numTelefonoAsociado = numTelefonoAsociado;
		this.credito = credito;
		this.app = app;
	}
	
	public int getNumTelefonoAsociado() {
		return numTelefonoAsociado;
	}
	public int getCredito() {
		return credito;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
	
	public void setCredito(int credito) {
		this.credito = credito;
	}

	public void sumarCredito(int creditoExtra) {
		this.setCredito(this.getCredito() + creditoExtra);
	}
	public boolean esMismoNumero(int numero) {
		return this.getNumTelefonoAsociado() == numero;
	}

	public void restarCredito(int precio) {
		this.setCredito(this.getCredito()-precio);
		
	}
}
