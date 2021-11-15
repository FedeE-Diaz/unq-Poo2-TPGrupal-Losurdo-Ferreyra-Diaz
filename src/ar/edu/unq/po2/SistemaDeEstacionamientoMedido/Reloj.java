package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reloj implements TemporizadorListener {
	
	private List<RelojListener> listeners;
	private LocalDateTime tiempoActual;
	
	public Reloj() {
		super();
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
}
