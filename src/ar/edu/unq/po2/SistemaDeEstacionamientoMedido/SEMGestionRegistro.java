package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionRegistro {

	private ArrayList<Registro> registros;
	private int ultimoNumControl = 0;
	
	public SEMGestionRegistro() {
		super();
		this.registros = new ArrayList<Registro>();
	}	
}
