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
		EstacionamientoVigente nuevoEstacionamiento = new EstacionamientoVigente(patente, getHoraActual(), horas ,this.zona);
		this.sem.agregarNuevoEstacionamiento(nuevoEstacionamiento);
		this.sem.registrarNuevasHoras(horas, this);
	}
	
	public int getHoraActual() {
		return this.sem.getHoraSistema();
	}
	
	public void cargarCredito(int numero, int monto) {
		this.sem.cargarCredito(numero, monto, this);
	}
}
