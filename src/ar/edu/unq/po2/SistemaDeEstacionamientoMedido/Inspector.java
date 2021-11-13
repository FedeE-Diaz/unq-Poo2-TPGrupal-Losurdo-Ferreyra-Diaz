package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class Inspector {
	
	Zona zona;
	APPInspector app;
	
	public Inspector(Zona zona) {
		super();
		this.zona = Zona;
		this.app  = new APPInspector(this);
	}
	
	public void verificarTodosLosVehiculos() {
		for(EstacionamientoVigente estacionamiento : this.zona) {
			this.app.verificarPatente(estacionamiento.getPatente());
		}
	}
}
