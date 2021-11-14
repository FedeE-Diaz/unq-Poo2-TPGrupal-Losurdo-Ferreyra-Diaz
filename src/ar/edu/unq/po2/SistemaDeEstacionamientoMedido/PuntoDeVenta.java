package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class PuntoDeVenta {
	private SEM sem;
	private Zona zona;
	
	public PuntoDeVenta(SEM sem, Zona zona) {
		this.sem = sem;
		this.zona = zona;
		this.zona.agregarPuntoDeVenta(this);
		
	}
	
	public void iniciarEstacionamiento(String patente,int horas) {
		this.sem.agregarNuevoEstacionamiento(new EstacionamientoVigente(patente, getHoraActual(), horas ,this.zona));
	}
	
	public int getHoraActual() {
		return 8;
	}
	
	public void cargarCredito(int numero, int monto) {
		this.sem.cargarCredito(numero, monto);
	}
	
	
	
}
