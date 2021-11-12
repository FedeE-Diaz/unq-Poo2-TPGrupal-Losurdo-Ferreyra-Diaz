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
	
	public void cargarInfraccion(String patente) {
		Infraccion nuevaInfraccion = new Infraccion(patente);
		this.infracciones.add(nuevaInfraccion);		
	}
	
	public boolean tieneUnaInfraccion(String patente) {
		for(Infraccion infraccion : this.infracciones) {
			if(infraccion.getPatente() == patente) {
				return true;
			}
		}
		return false;
	}	
}
