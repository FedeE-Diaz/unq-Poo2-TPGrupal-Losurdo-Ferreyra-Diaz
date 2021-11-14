package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class EstacionamientoApp extends EstacionamientoVigente {
	
	private int numTelefono;
	private Punto puntoInicial;
	
	public EstacionamientoApp(String patente, int horaInicial, int horaFinal,Zona zona, int numTelefono){
		super(patente, horaInicial, horaFinal, zona);
		this.numTelefono = numTelefono;
	}
	
	public void enviarNotificacion(SEMGestionEstacionamiento semGestor) {
		semGestor.notificarUsuario(this.numTelefono);
		
	}
	
	public Punto getUbicacion() {
		return this.puntoInicial;
	}
}
