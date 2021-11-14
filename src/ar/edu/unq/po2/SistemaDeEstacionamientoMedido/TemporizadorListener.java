package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public interface TemporizadorListener {

	public void subscribirse(Temporizador temporizador);
	public void actualizarHora(LocalDateTime horaActualizada);

}
