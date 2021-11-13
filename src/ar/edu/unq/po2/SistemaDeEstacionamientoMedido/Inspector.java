package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class Inspector {
	
	Zona zonaAsignada;
	APPInspector app;
	
	public Inspector(Zona zona) {
		super();
		this.zonaAsignada = zona;
		this.app          = new APPInspector(this);
	}
	
	public void verificarTodosLosVehiculos() {
		for(EstacionamientoVigente estacionamiento : this.zonaAsignada.getEstacionamientosActuales()) {
			this.app.verificarPatente(estacionamiento.getPatente());
		}
	}

	public Zona getZona() {
		return zonaAsignada;
	}
}
