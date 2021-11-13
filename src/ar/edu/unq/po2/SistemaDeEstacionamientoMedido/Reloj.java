package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reloj {
	
	private ArrayList<Temporizador> subscriptores;
	// Hacer de TIMER nuestro observado? y que el semEstacionamiento o el comun sea el listener? implementando una interfaz updateTime()?

	public int getHoraActual() {
		LocalDateTime localDate = LocalDateTime.now();
		return localDate.getHour();
	}

	public void agregarObservador(Temporizador listener) {
		subscriptores.add(listener);
	}

	public void removerObservador(Temporizador listener) {
		subscriptores.remove(listener);
	}

//	public static 
	
	/* Quiza con Timer timer = new Timer(); se podria simular la ejecucion cada ciertos tiempo(1min por ejemplo) 
	 * en un ciclo constante dando el aviso a los listeners sobre el tiempo actualizado.
	 * De esta forma, cada listener haria lo que vea preciso segun su situacion, en el caso del SEM verificaria que los
	 * estacionamientos de app resten credito al usuario por cada hora cumplida de estacionamiento vigente, y a las 
	 * 20hs,daria finalizacion a todos los estacionamientos.
	 */
}
