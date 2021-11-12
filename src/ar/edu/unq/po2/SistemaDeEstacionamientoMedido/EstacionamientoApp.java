package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class EstacionamientoApp extends EstacionamientoVigente {
	
	private int numTelefono;
	
	public EstacionamientoApp(String patente, int horaInicial, int horaFinal,Zona zona, int numTelefono){
		super(patente, horaInicial, horaFinal, zona);
		this.numTelefono = numTelefono;
	}
	
	public void enviarNotificacion(SEMGestionEstacionamiento semGestor) {
		semGestor.notificarUsuario(this.numTelefono);
		
	}
}
