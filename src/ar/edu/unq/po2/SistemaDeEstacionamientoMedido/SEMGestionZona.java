package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionZona {

	private ArrayList<Zona> zonas;

	private ArrayList<Zona> getZonas() {
		return zonas;
	}

	public SEMGestionZona() {
		super();
		this.zonas = new ArrayList<Zona>();
	}
	
}
