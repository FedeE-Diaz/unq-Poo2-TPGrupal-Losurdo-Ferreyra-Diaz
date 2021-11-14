package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class EstacionamientoApp extends EstacionamientoVigente {
	
	private int numTelefono;
	private Punto puntoInicial;
	private int horas;
	private int horasCobradas;
	
	
	public EstacionamientoApp(String patente, int horaInicial, int horaFinal,Zona zona, int numTelefono){
		super(patente, horaInicial, horaFinal, zona);
		this.numTelefono = numTelefono;
		this.horasCobradas = 0;
	}
	
	public void enviarNotificacion(SEMGestionEstacionamiento semGestor) {
		semGestor.notificarUsuario(this.numTelefono);
		
	}
	
	public boolean correspondeCobrar(int horaActual) {
		return this.horasCobradas <= this.horasTranscurridas(horaActual);
	}
	private int horasTranscurridas(int horaActual) {
		return horaActual - this.getHoraInicial();
	}

	@Override
	public Punto getUbicacion() {
		return this.puntoInicial;
	}
	@Override
	public void actualizar(int horaActual, SEMGestionEstacionamiento semGestionEstacionamiento){
		if(correspondeCobrar(horaActual)){
			this.cobrarEn(semGestionEstacionamiento);
		}
	}

	private void cobrarEn(SEMGestionEstacionamiento semGestionEstacionamiento) {
		semGestionEstacionamiento.cobrarA(this.numTelefono);
		
	}
}
