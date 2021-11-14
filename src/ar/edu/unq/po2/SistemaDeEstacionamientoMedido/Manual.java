package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Manual extends ModoActivo{
	


	public Manual(App app) {
		super(app);
	}

	// SOLO AVISA
	@Override
	protected ArrayList<String> notificarAdvertenciaSobreInicioEstacionamiento() {
		ArrayList<String> respuesta = new ArrayList<String>();
		respuesta.add("Alerta: Estas a punto de irte de tu auto sin haber realizado un estacionamiento");
		return respuesta;
	}


	@Override
	protected ArrayList<String> notificarAdvertenciaSobreFinEstacionamiento() {
		ArrayList<String> respuesta = new ArrayList<String>();
		respuesta.add("Alerta: Hemos detectado que te estas a punto de ir sin haber finalizado el estacionamiento");
		return respuesta;
	}


	@Override
	public void cambiarModo() {

		this.getApp().setModo(new Automatico(this.getApp()));
		
	}
	@Override
	protected void setearPatenteManualmente(String patente) {
		this.getApp().setPatente(patente);
	}





}
