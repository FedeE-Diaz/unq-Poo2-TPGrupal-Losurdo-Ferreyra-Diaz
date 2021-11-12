package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class Inspector {
	
	APPInspector app;
	
	public Inspector(APPInspector app) {
		super();
		this.app = app;
	}
	
	public void verificarTodosLosVehiculosDe(Zona zona) {
		for(EstacionamientoVigente estacionamiento : zona.getEstacionamientosActuales()) {
			this.app.verificarPatente(estacionamiento.getPatente());
		}
	}
}
