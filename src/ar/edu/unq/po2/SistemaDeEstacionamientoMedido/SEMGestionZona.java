package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionZona {

	private ArrayList<Zona> zonas;

	private ArrayList<Zona> getZonas(){
		return zonas;
	}

	public SEMGestionZona() {
		super();
		this.zonas = new ArrayList<Zona>();
	}
	
	public Zona obtenerZonaDe(Punto punto) {
		for (Zona zona : this.zonas) {
			if (zona.lePertenece(punto)) {
				return zona;
			}
		}
		return null;
	}  
	public void agregarZona(Zona zona) {
		this.getZonas().add(zona);
	}
	
}
