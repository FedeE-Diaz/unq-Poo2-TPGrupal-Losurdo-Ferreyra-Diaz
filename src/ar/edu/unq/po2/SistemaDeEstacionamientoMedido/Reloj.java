package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reloj implements TemporizadorListener {
	
	private LocalDateTime tiempoActual;
	// Hacer de TIMER nuestro observado? y que el semEstacionamiento o el comun sea el listener? implementando una interfaz updateTime()?
	
	public Reloj() {
		super();
		new ArrayList<Temporizador>();
		this.tiempoActual = LocalDateTime.now();
	}
	
	public int getHoraActual() {
		return tiempoActual.getHour();
	}

	@Override
	public void actualizarHora(LocalDateTime horaActualizada) {
		this.tiempoActual = horaActualizada;		
	}

	@Override
	public void subscribirse(Temporizador temporizador) {
		temporizador.subscribirListener(this);		
	}

//	public static 
	
	/* Quiza con Timer timer = new Timer(); se podria simular la ejecucion cada ciertos tiempo(1min por ejemplo) 
	 * en un ciclo constante dando el aviso a los listeners sobre el tiempo actualizado.
	 * De esta forma, cada listener haria lo que vea preciso segun su situacion, en el caso del SEM verificaria que los
	 * estacionamientos de app resten credito al usuario por cada hora cumplida de estacionamiento vigente, y a las 
	 * 20hs,daria finalizacion a todos los estacionamientos.
	 */
}
