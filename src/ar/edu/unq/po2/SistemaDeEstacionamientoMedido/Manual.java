package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Manual implements Modo{
	
	
	private final App app;
	
	private App getApp() {
		return app;
	}

	public Manual(App app) {
		super();
		this.app = app;
	}

	@Override
	public ArrayList<String> iniciarEstacionamiento(String patente) {
		this.getApp().setPatente(patente);
		return this.getApp().getSem().iniciarNuevoEstacionamiento(app);
	}


// SOLO AVISA
	@Override
	public void asistenciaInicioEstacionamiento() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void asistenciaFinEstacionamiento() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void cambiarModo() {

		this.getApp().setModo(new Automatico(app));
		
	}



}