package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class APPInspector {
	
	private SEM sem;
	
	public APPInspector(SEM sem, Celular celular) {
		this.sem     = sem;
	}
	
	public void verificarPatente(String patente) {
		if (!this.esEstacionamientoVigente(patente)) {
			this.altaDeInfraccion(patente);
		}
	}

	private void altaDeInfraccion(String patente) {
		sem.cargarInfraccion(patente);
		
	}

	private boolean esEstacionamientoVigente(String patente) {
		return sem.esEstacionamientoVigente(patente);
	}
}
