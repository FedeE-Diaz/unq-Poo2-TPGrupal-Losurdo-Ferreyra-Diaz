package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

// SI EL INSPECTOR ES UN STRING, LA APPINSPECTOR DEBE CONOCER LA ZONA
// ZONA DEBE SABER LA CANTIDAD DE PUNTOS QUE LO COMPONEN
public class APPInspector {
	
	private Inspector inspector;
	private SEM sem;
	private Celular celular;
	//private Zona zona;
	
	public APPInspector(Inspector inspector, SEM sem, Celular celular) { 
		this.inspector = inspector;
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
		return null; //calcularZonaDeInspeccion(); // Retorna de mi GPS la ubicación en el que hice la inspección
		// LA ZONA DEBE SABER LA CANTIDAD DE PUNTOS Q LA COMPONEN Y TENER ALGO Q PERMITA VERIFICAR SI X PUNTO PERTENECE A ESA ZONA
	}

	private void calcularZonaDeInspeccion() {
		//celular.getGPS().getUbicacionActual();
	}
}
