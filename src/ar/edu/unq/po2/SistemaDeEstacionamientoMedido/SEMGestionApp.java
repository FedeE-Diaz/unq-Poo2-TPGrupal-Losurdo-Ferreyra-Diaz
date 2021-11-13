package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class SEMGestionApp {

	private SEMGestionEstacionamiento semEstacionamiento;
	
	public SEMGestionApp(SEMGestionEstacionamiento semGestionEstacionamiento) {
		this.semEstacionamiento = semGestionEstacionamiento;
	}
	
	public SEMGestionEstacionamiento getSemEstacionamiento() {
		return semEstacionamiento;
	}


	public void iniciarNuevoEstacionamiento(App app) {
		this.validarNuevoEstacionamiento(app);
		
	}
	private void validarNuevoEstacionamiento(App app) {
		
		if(this.alcanzaElCredito(app)) {
			semEstacionamiento.agregarNuevoEstacionamiento(this.nuevoEstacionamientoApp(app.getPatente(), app));
		}
	}
	private boolean alcanzaElCredito(App app) {
	
		return this.calculoHoraFinal(app) >= 1;
	}

	private EstacionamientoVigente nuevoEstacionamientoApp(String patente,App app) {

		return new EstacionamientoApp(patente,TIMER.getHoraActual(),this.calculoHoraFinal(app),app.getNumeroTelefono()),app.getZonaActual();
	}

	private int calculoHoraFinal(App app) {
	
		return (int) app.saldoDisponible() / semEstacionamiento.getPrecioEstacionamientoPorHora();
	}

}
