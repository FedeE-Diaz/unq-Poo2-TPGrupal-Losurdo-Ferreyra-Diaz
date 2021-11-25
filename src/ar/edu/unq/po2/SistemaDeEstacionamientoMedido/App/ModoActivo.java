package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

import java.util.ArrayList;

public abstract class ModoActivo implements Modo{

	private final App app;

	public ModoActivo(App app) {
		super();
		this.app = app;
	}
	
	protected App getApp() {
		return app;
	}
	
	@Override
	public ArrayList<String> iniciarEstacionamiento(String patente) {
		this.setearPatenteManualmente(patente);
		return this.getApp().getSem().iniciarNuevoEstacionamiento(app);
	}

	protected void setearPatenteManualmente(String patente) {}
	
	@Override
	public void finalizarEstacionamiento(String patente) throws Exception{
		
		this.getApp().getSem().finEstacionamiento(patente);
	}
	
	/* Estas advertencias que se dan por un posible inicio/fin de estacionamiento, se activan 
	 * al detectar un cambio en el tipo de desplazamiento del usuario (mediante la interfaz MovementSensor)
	 * quien sea que se encargue de enviar estos mensajes provoca que se envie el aviso a la interfaz grafica
	 * (que sera un listener de los cambios de movimiento que realize el usuario, el cual estaria subscrito a una lista en app),
	 *  no implemento demás comportamiento relacionado a la interfaz grafica porque por lo entendido no forma parte de la evaluacion de este trabajo */
	
	@Override
	public ArrayList<String> asistenciaInicioEstacionamiento() {
		if(!this.getApp().hayEstacionamientoVigente() && this.getApp().estoyEnUnaZonaDeEstacionamientoMedido()) {
			return this.notificarAdvertenciaSobreInicioEstacionamiento();
		}
		else {
			return null; //La idea es que la interfaz grafica evalue que si el retorno es null, no debe mostrar nada.
						//(Ya que las condiciones determinaban que no debia mostrar ningun aviso)
		}				//Esto se podria reemplazar con un arrayList<String> vacio y que entonces si está vacio no haga ningun popUp...es lo mismo
	}
	
	@Override
	public ArrayList<String> asistenciaFinEstacionamiento() throws Exception{
		if(this.getApp().hayEstacionamientoVigente() && this.getApp().estoyEnElMismoPuntoQueElEstacionamiento()) { 
			return this.notificarAdvertenciaSobreFinEstacionamiento();
		}
		else {
			return null; //La idea es que la interfaz grafica evalue que si el retorno es null, no debe mostrar nada. (Ya que las condiciones determinaban que no debia mostrar ningun aviso)
		}
	}
	
	protected abstract ArrayList<String> notificarAdvertenciaSobreInicioEstacionamiento();
	
	protected abstract ArrayList<String> notificarAdvertenciaSobreFinEstacionamiento() throws Exception;
	
}
