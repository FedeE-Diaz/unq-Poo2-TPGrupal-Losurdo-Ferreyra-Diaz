package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

import java.util.ArrayList;

public class Automatico extends ModoActivo{
	
	public Automatico(App app) {
		super(app);
	}

	// AVISA Y CREA/ELIMINA
	@Override
	protected ArrayList<String> notificarAdvertenciaSobreInicioEstacionamiento() {
		ArrayList<String> respuesta = new ArrayList<String>();
		respuesta.add("Se ha iniciado una solicitud de estacionamiento automaticamente");
		respuesta.addAll(this.iniciarEstacionamiento(this.getApp().getPatente())); 
		/* El ejercicio no lo aclara pero me parece buena idea iniciar el mensaje del intento de solicitud y luego el mensaje de si fue exitoso o no */
		return respuesta;
	}

	@Override
	protected ArrayList<String> notificarAdvertenciaSobreFinEstacionamiento() throws Exception{
		ArrayList<String> respuesta = new ArrayList<String>();
		respuesta.add("Se ha finalizado el estacionamiento actual automaticamente");
		this.finalizarEstacionamiento(this.getApp().getPatente());
		return respuesta;
	}
	
	@Override
	public void cambiarModo() {
	this.getApp().setModo(new Manual(this.getApp()));
	}
}
