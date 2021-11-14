package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Zona {
	private APPInspector appInspector;
	private ArrayList<PuntoDeVenta> puntosDeVenta;
	private ArrayList<Punto> puntos;

	public Zona(APPInspector appInspector) {
		this.appInspector = appInspector;
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
		this.puntos = new ArrayList<Punto>();
	}

	public boolean lePertenece(Punto punto) {
		
		return this.puntos.contains(punto);
	}
	
	public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntosDeVenta.add(puntoDeVenta);
	}
	
	
	
	
}
