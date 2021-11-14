package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionInfraccion {
	
	private ArrayList<Infraccion> infracciones;
	
	public SEMGestionInfraccion() {
		super();
		this.infracciones = new ArrayList<Infraccion>();
	}
	
	public ArrayList<Infraccion> getInfracciones() {
		return infracciones;
	}
	
	public void cargarInfraccion(String patente, Inspector inspector, Zona zona) {
		Infraccion nuevaInfraccion = new Infraccion(patente, inspector, zona);
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
