package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos;

import java.util.ArrayList;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.PuntoDeVenta;

public class Zona {
	private String inspector;
	private ArrayList<PuntoDeVenta> puntosDeVenta;
	private ArrayList<Punto> puntos;

	public Zona(String inspector) {
		this.inspector = inspector;
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
		this.puntos = new ArrayList<Punto>();
	}

	public boolean lePertenece(Punto punto) {
		for(Punto p : this.puntos) {
			if(p.esMismoPunto(punto)) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntosDeVenta.add(puntoDeVenta);
	}
	
	public String getInspector() {
		return inspector;
	}

	public void agregarPunto(Punto punto) {
		this.puntos.add(punto);
	}

}
