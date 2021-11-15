package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento;

import java.util.ArrayList;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEM;

public class Entidad implements MonitoreoListener{
	private ArrayList<AvisoGenerico> avisosRecibidos;
	
	public Entidad() {
		this.avisosRecibidos = new ArrayList<AvisoGenerico>();
	}
	public void suscribirseEn(SEM sem) {
		sem.suscribir(this);
	}
	
	public void recibir(AvisoGenerico aviso) {
		this.avisosRecibidos.add(aviso);
	}
	
	public ArrayList<AvisoGenerico> getAvisosRecibidos(){
		return this.avisosRecibidos;
	}
	
	public void deSuscribirseEn(SEM sem) {
		sem.desuscribir(this);
	}
}
