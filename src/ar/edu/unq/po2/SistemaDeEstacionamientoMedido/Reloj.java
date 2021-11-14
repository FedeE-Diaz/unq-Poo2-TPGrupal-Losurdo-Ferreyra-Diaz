package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reloj implements TemporizadorListener {
	
	private List<RelojListener> listeners;
	private LocalDateTime tiempoActual;
	// Hacer de TIMER nuestro observado? y que el semEstacionamiento o el comun sea el listener? implementando una interfaz updateTime()?
	
	public Reloj() {
		super();
		new ArrayList<Temporizador>();
		this.listeners = new ArrayList<RelojListener>();
		this.tiempoActual = LocalDateTime.now();
	}
	
	public int getHoraActual() {
		return tiempoActual.getHour();
	}
	
	public void subscribirListener(RelojListener listener) {
		this.listeners.add(listener);		
	}

	@Override
	public void actualizarHora(LocalDateTime horaActualizada) {
		this.tiempoActual = horaActualizada;
		this.update();
	}
	
	private void update() {
		for(RelojListener listener : this.listeners) {
			listener.actualizarReloj();
		}		
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
