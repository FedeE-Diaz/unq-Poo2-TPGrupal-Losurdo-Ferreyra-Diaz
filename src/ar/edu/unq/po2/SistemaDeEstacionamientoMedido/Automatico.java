package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

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
		this.iniciarEstacionamiento(this.getApp().getPatente()); 
		/* El ejercicio no lo aclara pero si quiero adicionalmente al mensaje del aviso,sumarle los
		 *  mensajes anteriores "comunes" al iniciar estacionamiento, deberia hacer una concatenacion
		 *   de "respuesta" con "iniciarEstacionamiento". */
		return respuesta;
	}

	@Override
	protected ArrayList<String> notificarAdvertenciaSobreFinEstacionamiento(){
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
