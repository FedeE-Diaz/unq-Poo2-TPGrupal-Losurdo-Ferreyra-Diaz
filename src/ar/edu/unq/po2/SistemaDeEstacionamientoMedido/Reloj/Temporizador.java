package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Reloj;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Temporizador {
	
	LocalDateTime ultimaHoraRegistrada;
	private List<TemporizadorListener> listeners;
	
	public Temporizador() {
		super();
		this.listeners = new ArrayList<TemporizadorListener>();
		this.ultimaHoraRegistrada = LocalDateTime.now();
	}
	
	public void subscribirListener(TemporizadorListener listener) {
		this.listeners.add(listener);
	}
	
	public void simularTiempo(long minutos) {
		this.setUltimaHoraRegistrada(this.ultimaHoraRegistrada.plus(Duration.of(minutos, ChronoUnit.MINUTES))); 
		this.update();
	}
	
	private void setUltimaHoraRegistrada(LocalDateTime hora) {
		this.ultimaHoraRegistrada = hora;
	}
	
	public void update() {
		for(TemporizadorListener listener : this.listeners) {
			listener.actualizarHora(this.ultimaHoraRegistrada);
		}
	}
	public void simularHora(int hora,int minutos) {
		this.setUltimaHoraRegistrada(this.ultimaHoraRegistrada.withHour(hora));
		this.setUltimaHoraRegistrada(this.ultimaHoraRegistrada.withMinute(minutos));
	}
}
