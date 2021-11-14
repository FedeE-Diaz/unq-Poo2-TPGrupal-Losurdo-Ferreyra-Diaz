package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public interface Modo {
	
	public ArrayList<String> iniciarEstacionamiento(String patente);
	
	public void finalizarEstacionamiento(String patente);
	
	public ArrayList<String> asistenciaInicioEstacionamiento();
	
	public ArrayList<String> asistenciaFinEstacionamiento();
	
	public void cambiarModo();

	
}