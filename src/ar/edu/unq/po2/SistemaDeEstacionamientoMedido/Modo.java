package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public interface Modo {
	
	public ArrayList<String> iniciarEstacionamiento(String patente);
	
	public void cambiarModo();
	
	public void asistenciaInicioEstacionamiento();

	public void asistenciaFinEstacionamiento();
}