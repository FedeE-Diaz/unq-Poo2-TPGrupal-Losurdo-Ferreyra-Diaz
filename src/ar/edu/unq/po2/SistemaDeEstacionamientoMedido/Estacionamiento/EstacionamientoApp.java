package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.Zona;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEMGestionEstacionamiento;

public class EstacionamientoApp extends EstacionamientoVigente {
	
	private int numTelefono;
	private Punto puntoInicial;
	private int horas;
	private int horasCobradas;
	
	
	public EstacionamientoApp(String patente, int horaInicial, int horaFinal,Zona zona, int numTelefono, Punto puntoInicial){
		super(patente, horaInicial, horaFinal, zona);
		this.numTelefono = numTelefono;
		this.horasCobradas = 0;
		this.puntoInicial = puntoInicial;
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
			horasCobradas ++;
		}
	}

	private void cobrarEn(SEMGestionEstacionamiento semGestionEstacionamiento) {
		semGestionEstacionamiento.cobrarA(this.numTelefono);
		
	}
}
