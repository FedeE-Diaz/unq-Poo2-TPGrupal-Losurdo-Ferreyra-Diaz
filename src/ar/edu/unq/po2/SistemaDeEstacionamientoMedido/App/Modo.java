package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

import java.util.ArrayList;

public interface Modo {
	
	public ArrayList<String> iniciarEstacionamiento(String patente);
	
	public void finalizarEstacionamiento(String patente) throws Exception;
	
	public ArrayList<String> asistenciaInicioEstacionamiento();
	
	public ArrayList<String> asistenciaFinEstacionamiento() throws Exception;
	
	
}