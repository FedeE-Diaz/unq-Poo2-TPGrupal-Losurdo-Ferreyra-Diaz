package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM;

import java.util.ArrayList;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App.App;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.EstacionamientoApp;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.EstacionamientoVigente;

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

		return new EstacionamientoApp(patente,sem.getReloj().getHoraActual(),this.calculoHoraFinal(app),app.getZonaActual(),app.getNumeroTelefono(), app.getPuntoActual());
	}

	private int calculoHoraFinal(App app) {
		return sem.getReloj().getHoraActual() + this.calculoHorasDisponibles(app); 
	}
	
	public int calculoHorasDisponibles(App app) {
		return app.saldoDisponible() / semEstacionamiento.getPrecioEstacionamientoPorHora();
	}
}
