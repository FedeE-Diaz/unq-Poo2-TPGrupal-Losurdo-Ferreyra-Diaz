package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Celular;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEM;

public class APPInspector {
	
	private SEM sem;
	private Celular celular;
	private Zona zona;
	
	public APPInspector(SEM sem, Celular celular, Zona zona) { 
		this.sem       = sem;
		this.celular   = celular; 
		this.zona      = zona;
	}
	
	public void verificarPatente(String patente) {
		if (!this.esEstacionamientoVigente(patente)) {
			this.altaDeInfraccion(patente);
		}
	}

	private void altaDeInfraccion(String patente) {
		if(this.esZonaDeInspeccion()) {
			sem.cargarInfraccion(patente, this.zona);
		}
	}

	private boolean esZonaDeInspeccion() {
		return zona.lePertenece(this.getUbicacionActual());
	}

	private Punto getUbicacionActual() {
		return celular.getGPS().getUbicacionActual();
	}

	public boolean esEstacionamientoVigente(String patente) {
		return sem.esEstacionamientoVigente(patente);
	}
	
}
