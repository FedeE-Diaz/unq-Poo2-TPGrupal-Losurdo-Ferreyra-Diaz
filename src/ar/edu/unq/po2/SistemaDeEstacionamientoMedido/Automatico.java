package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Automatico implements Modo {

	private final App app;
	
	public Automatico(App app) { //Considerar hacer una super clase y heredar de ella tanto para automatico como manual
		super();
		this.app = app;
	}

	@Override
	public ArrayList<String> iniciarEstacionamiento(String patente) {
		// TODO Auto-generated method stub
		SEM.iniciarNuevoEstacionamiento(app);
	}
	
//SEM
	private EstacionamientoVigente nuevoEstacionamientoApp(String patente) {
		// TODO Auto-generated method stub
		return new EstacionamientoApp(patente);
	}

	
//SEM:
	public void iniciarNuevoEstacionamiento(App app) {
		this.validarNuevoEstacionamiento(app.getMiUsuario());
		this.agregarNuevoEstacionamiento(this.nuevoEstacionamientoApp(app.getPatente()));
	}
//SEM:
	private void validarNuevoEstacionamiento() {
	// TODO Auto-generated method stub
	
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

}
