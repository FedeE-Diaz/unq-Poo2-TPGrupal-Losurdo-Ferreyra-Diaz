package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.Zona;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEMGestionEstacionamiento;

public class EstacionamientoVigente {
	
	private String patente;
	private int horaInicio;
	private int horaFinal;
	private Zona zona;
	
	public EstacionamientoVigente(String patente, int horaInicio, int horaFinal, Zona zona){
		this.patente = patente;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.zona = zona;
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	public int getHoraInicial() {
		return this.horaInicio;
	}
	public int getHoraFinal() {
		return this.horaFinal;
	}
	
	public boolean esMismaPatente(String patente) {
		return this.getPatente().equals(patente); 
	}
	
	public boolean estaEnZona(Zona zona) {
		return this.zona == zona;
	}
	
	public void enviarNotificacion(SEMGestionEstacionamiento semGestor){
	}
	
	public Punto getUbicacion() {
		return new Punto();
	}

	public void actualizar(int horaActual, SEMGestionEstacionamiento semGestionEstacionamiento) {
	}
	
}