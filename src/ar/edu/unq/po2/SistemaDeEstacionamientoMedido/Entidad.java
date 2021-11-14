package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Entidad {
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
	
	public void desuscribirseEn(SEM sem) {
		sem.desuscribir(this);
	}
}
