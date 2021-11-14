package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionApp {

	private SEM sem;
	private SEMGestionEstacionamiento semEstacionamiento;
	
	public SEMGestionApp(SEM sem, SEMGestionEstacionamiento semGestionEstacionamiento) {
		this.semEstacionamiento = semGestionEstacionamiento;
		this.sem = sem;
	}
	
	public SEMGestionEstacionamiento getSemEstacionamiento() {
		return semEstacionamiento;
	}


	public ArrayList<String> iniciarNuevoEstacionamiento(App app) {
		
		return this.validarNuevoEstacionamiento(app);
		
	}
	private ArrayList<String> validarNuevoEstacionamiento(App app) {
		
		if(this.alcanzaElCredito(app)) {
			
			EstacionamientoVigente nuevoEstacionamiento = this.nuevoEstacionamientoApp(app.getPatente(), app);
			semEstacionamiento.agregarNuevoEstacionamiento(nuevoEstacionamiento);
			// TODO avisa a los subscriptores de gestionMonitor de que se creo un estacionamiento ( y verificar que haga lo mismo cuando finaliza)
			return this.mensajeRespuestaDe(nuevoEstacionamiento);
		}
		else {
			return this.mensajeError();
		}
	}
	private ArrayList<String> mensajeRespuestaDe(EstacionamientoVigente nuevoEstacionamiento) {

		ArrayList<String> respuesta = new ArrayList<String>();
		respuesta.add("Se ha iniciado su estacionamiento exitosamente");
		respuesta.add("Hora Inicial: " + nuevoEstacionamiento.getHoraInicial());
		respuesta.add("Hora Final: " + nuevoEstacionamiento.getHoraFinal());
		return respuesta;
	}
	private ArrayList<String> mensajeError(){
		ArrayList<String> respuesta = new ArrayList<String>();
		respuesta.add("Saldo insuficiente. Estacionamiento no permitido.");
		return respuesta;
	}
	private boolean alcanzaElCredito(App app) {
	
		return this.calculoHorasDisponibles(app) >= 1;
	}

	private EstacionamientoVigente nuevoEstacionamientoApp(String patente,App app) {

		return new EstacionamientoApp(patente,sem.getReloj().getHoraActual(),this.calculoHoraFinal(app),app.getZonaActual(),app.getNumeroTelefono());
	}

	private int calculoHoraFinal(App app) {
		return sem.getReloj().getHoraActual() + this.calculoHorasDisponibles(app); 
		// Esto habra que cambiarlo si llegamos a usar dates y todo eso.
	}
	public int calculoHorasDisponibles(App app) {
		return app.saldoDisponible() / semEstacionamiento.getPrecioEstacionamientoPorHora();
	}
}
