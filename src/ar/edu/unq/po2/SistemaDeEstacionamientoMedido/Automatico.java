package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Automatico implements Modo {

	private final App app;
	
	private App getApp() {
		return app;
	}

	public Automatico(App app) { //Considerar hacer una super clase y heredar de ella tanto para automatico como manual
		super();
		this.app = app;
	}

	@Override
	public ArrayList<String> iniciarEstacionamiento(String patente) {
		return app.getSem().iniciarNuevoEstacionamiento(app);
	}

	// AVISA Y CREA/ELIMINA
	@Override
	public void asistenciaInicioEstacionamiento() {
	// TODO Auto-generated method stub
	
	}

	@Override
	public void asistenciaFinEstacionamiento() {
	// TODO Auto-generated method stub
	
	}
/*En estos casos, el
usuario también recibe una notificación, ahora indicando que el inicio/fin de estacionamiento se ha
realizado de forma automática.*/
	
	@Override
	public void cambiarModo() {
	
	this.getApp().setModo(app.getManual());
	
	}

}
