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
	
	public int getCantidadDeInfracciones() {
		return this.infracciones.size();
	}
	
	public void cargarInfraccion(String patente, Zona zona) {
		Infraccion nuevaInfraccion = new Infraccion(patente, zona);
		this.getInfracciones().add(nuevaInfraccion);		
	}
	
	public boolean tieneUnaInfraccion(String patente) {
		for(Infraccion infraccion : this.getInfracciones()) {
			if(infraccion.getPatente() == patente) {
				return true;
			}
		}
		return false;
	}	
}
