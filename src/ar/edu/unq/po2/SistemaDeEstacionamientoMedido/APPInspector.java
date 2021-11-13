package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class APPInspector {
	
	private SEM sem;
	private Celular celular;
	
	public APPInspector(Inspector inspector, SEM sem, Celular celular) { 
		this.sem       = sem;
		this.celular   = celular; 
	}
	
	public void verificarPatente(String patente) {
		if (!this.esEstacionamientoVigente(patente)) {
			this.altaDeInfraccion(patente);
		}
	}

	private void altaDeInfraccion(String patente) {
		sem.cargarInfraccion(patente, this.inspector, this.zonaDeInspeccion());
	}

	public boolean esEstacionamientoVigente(String patente) {
		return sem.esEstacionamientoVigente(patente);
	}
	
	private Zona zonaDeInspeccion() {
		return inspector.getZona();
	}
}
