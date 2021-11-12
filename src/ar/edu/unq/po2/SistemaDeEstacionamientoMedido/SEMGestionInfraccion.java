package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionInfraccion {
	
	private ArrayList<Infraccion> infracciones;

	public ArrayList<Infraccion> getInfracciones() {
		return infracciones;
	}

	public SEMGestionInfraccion() {
		super();
		this.infracciones = new ArrayList<Infraccion>();
	}

	public void cargarCredito(String patente) {
		// TODO Auto-generated method stub
		
	}
	
}
