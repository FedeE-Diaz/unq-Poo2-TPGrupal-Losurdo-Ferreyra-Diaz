package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public abstract class ModoActivo implements Modo{

	private final App app;

	protected App getApp() {
		return app;
	}

	public ModoActivo(App app) {
		super();
		this.app = app;
	}

	@Override
	public ArrayList<String> iniciarEstacionamiento(String patente) {
		this.setearPatenteManualmente(patente);
		return this.getApp().getSem().iniciarNuevoEstacionamiento(app);
	}

	protected void setearPatenteManualmente(String patente) {}
	
	@Override
	public void finalizarEstacionamiento(String patente) {
		this.getApp().getSem().finEstacionamiento(patente);
	}

	/* Estas advertencias que se dan por un posible inicio/fin de estacionamiento, se activan 
	 * al detectar un cambio en el tipo de desplazamiento del usuario (mediante la interfaz MovementSensor)
	 * quien sea que se encargue de enviar estos mensajes tambien suponemos que enviaria el aviso a la interfaz grafica
	 * (que sera un listener de los cambios de movimiento que realize el usuario), 
	 * quiza haga falta agregar alguna linea extra para enviar esta notificacion a la interfaz grafica,pero 
	 * por lo entendido en el trabajo,no es un requerimiento solicitado actualmente.  */
	
	@Override
	public ArrayList<String> asistenciaInicioEstacionamiento() {
		if(!this.getApp().hayEstacionamientoVigente() && this.getApp().estoyEnUnaZonaDeEstacionamientoMedido()) {
			return this.notificarAdvertenciaSobreInicioEstacionamiento();
		}
		else {
			return null; //La idea es que la interfaz grafica evalue que si el retorno es null, no debe mostrar nada. (Ya que las condiciones determinaban que no debia mostrar ningun aviso)
		}
	}
	@Override
	public ArrayList<String> asistenciaFinEstacionamiento() {
		if(this.getApp().hayEstacionamientoVigente() && this.getApp().estoyEnElMismoPuntoQueElEstacionamiento()) { //Pequeño short circuit
			return this.notificarAdvertenciaSobreFinEstacionamiento();
		}
		else {
			return null; //La idea es que la interfaz grafica evalue que si el retorno es null, no debe mostrar nada. (Ya que las condiciones determinaban que no debia mostrar ningun aviso)
		}
	}
	
	protected abstract ArrayList<String> notificarAdvertenciaSobreInicioEstacionamiento();
	
	protected abstract ArrayList<String> notificarAdvertenciaSobreFinEstacionamiento();

	@Override
	public abstract void cambiarModo();
}
