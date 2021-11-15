package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM;

import java.util.ArrayList;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App.App;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.AvisoFinal;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.AvisoInicio;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.EstacionamientoVigente;

public class SEMGestionEstacionamiento{
	
	private SEMGestionApp gestionApp;
	private SEM sem;

	private final int precioEstacionamiento = 40;
	private ArrayList<EstacionamientoVigente> estacionamientosActuales;

	public SEMGestionEstacionamiento(SEM sem) {
		super();
		this.estacionamientosActuales = new ArrayList<EstacionamientoVigente>();
		this.gestionApp = new SEMGestionApp(sem,this);
		this.sem = sem;
	}
	
	public ArrayList<EstacionamientoVigente> getEstacionamientosActuales() {
		return estacionamientosActuales;
	}
	
	public SEMGestionApp getGestionApp() {
		return gestionApp;
	}

	public int getPrecioEstacionamientoPorHora() {
		return precioEstacionamiento;
	}
	
	public boolean esEstacionamientoVigente(String patente) {
		return this.getEstacionamientosActuales().stream().anyMatch(p -> p.esMismaPatente(patente));
	}

	public EstacionamientoVigente getEstacionamientoDe(String patente)throws Exception {
		// El mensaje solo debe ser invocado después de verificar la existencia del estacionamientoVigente (en este caso mediante esEstacionamientoVigente)
	    for (EstacionamientoVigente estacionamiento : this.getEstacionamientosActuales()) {
	        if (estacionamiento.esMismaPatente(patente)) {
	            return estacionamiento;
	        }
	    }
	    throw new Exception("Se busco un estacionamiento sin verificar su existencia");
	}

	public void removerEstacionamientoVigente(EstacionamientoVigente estacionamiento) {
		this.getEstacionamientosActuales().remove(estacionamiento); 
		
	}

	public void agregarNuevoEstacionamiento(EstacionamientoVigente estacionamiento) {
		this.getEstacionamientosActuales().add(estacionamiento);
		estacionamiento.actualizar(this.sem.getHoraSistema(),this);
		this.sem.notificar(new AvisoInicio(estacionamiento));
	}

	public void finEstacionamiento(String patente) throws Exception{
		if(this.esEstacionamientoVigente(patente)){	
			this.sem.notificar(new AvisoFinal(this.getEstacionamientoDe(patente)));
			this.removerEstacionamientoVigente(this.getEstacionamientoDe(patente));
		}
	}
	
	public ArrayList<String> iniciarNuevoEstacionamiento(App app) {
		return this.getGestionApp().iniciarNuevoEstacionamiento(app);
	}

	public void actualizarEstadoEstacionamiento() {		
		this.verificarFinalizacionDeTodosLosEstacionamientos();
		for(EstacionamientoVigente estacionamiento : estacionamientosActuales) {
			estacionamiento.actualizar(sem.getHoraSistema(), this);
		}
	}
	
	public void cobrarA(int numTelefono) {
		this.sem.cobrarA(this.precioEstacionamiento, numTelefono);
	}

	private void verificarFinalizacionDeTodosLosEstacionamientos() {
		if(this.esHoraDeFinalizar()) {
			this.finalizarTodosLosEstacionamientos();
		}
	}

	private boolean esHoraDeFinalizar() {
		
		return sem.getHoraSistema() >=20;
	}

	public void finalizarTodosLosEstacionamientos() {
		for(EstacionamientoVigente estacionamiento: this.getEstacionamientosActuales()) {
			estacionamiento.enviarNotificacion(this);
		}
		this.estacionamientosActuales.clear();
	}
	
	public void notificarUsuario(int numeroDeTelefono) {
	}

}