package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Entidad {
	private ArrayList<String> avisosRecibidos;
	
	public Entidad() {
		this.avisosRecibidos = new ArrayList<String>();
	}
	public void suscribirseEn(SEM sem) {
		sem.suscribir(this);
	}
	
	public void recibir(AvisoGenerico aviso) {
		this.avisosRecibidos.add(aviso);
	}
	
}
