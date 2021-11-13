package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.time.LocalDateTime;

public class TIMER {

	public static int getHoraActual() {
		LocalDateTime localDate = LocalDateTime.now();
		return localDate.getHour();
	}

}
