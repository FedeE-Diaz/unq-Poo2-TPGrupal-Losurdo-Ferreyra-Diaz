package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;


// INSPECTOR PODR�A SER SIMPLEMENTE UN STRING
public class Inspector {
	
	String nombre;
	Zona zonaAsignada;
	
	public Inspector(String nombre, Zona zona) {
		super();
		this.nombre       = nombre;
		this.zonaAsignada = zona;
	}
	
//	public void verificarTodosLosVehiculos() {
//		for(EstacionamientoVigente estacionamiento : this.zonaAsignada.getEstacionamientosActuales()) {
//			this.app.verificarPatente(estacionamiento.getPatente());
//		}
//	}

	public Zona getZona() {
		return zonaAsignada;
	}
}
