package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestionRegistroTest {

	private SEM sem;
	private Zona zona;
	private PuntoDeVenta puntoDeVenta;

	@BeforeEach
	public void setUp() throws Exception {
		
		this.sem = new SEM();
		this.zona = new Zona("Ricardo");
		this.puntoDeVenta = new PuntoDeVenta(sem, zona);
	}
	
	@Test
	void testTodosLosRegistrosTienenSuNumeroDeControlDistinto() {
		this.puntoDeVenta.iniciarEstacionamiento("ABC123", 5);
		this.puntoDeVenta.cargarCredito(123123, 400);
		this.puntoDeVenta.iniciarEstacionamiento("FCD43", 9);

		assertEquals(sem.getMyRegistro().getRegistros().get(0).getNumeroDeControl(), 0);
		assertEquals(sem.getMyRegistro().getRegistros().get(1).getNumeroDeControl(), 1);
		assertEquals(sem.getMyRegistro().getRegistros().get(2).getNumeroDeControl(), 2);
	}
	
	@Test
	void testCuandoSeCompranHorasDeEstacionamiento_SeCreaUnRegistroConLosDatos() {
		this.puntoDeVenta.iniciarEstacionamiento("ABC123", 5);
		LocalDateTime fechaYHoraEsperados = LocalDateTime.now();
		
		assertEquals(sem.getMyRegistro().getCantidadDeRegistros(), 1);
		assertEquals(sem.getMyRegistro().getRegistros().get(0).getPuntoDeVenta(), this.puntoDeVenta);
		assertEquals(sem.getMyRegistro().getRegistros().get(0).getFechaYHora(), fechaYHoraEsperados, "Error en la fecha y hora");
	}
	
	@Test
	void testCuandoSeRecargaUnCelular_SeCreaUnRegistroConLosDatos() {
		this.puntoDeVenta.cargarCredito(123123, 500);
		
		assertEquals(sem.getMyRegistro().getCantidadDeRegistros(), 1);
		assertEquals(sem.getMyRegistro().getRegistros().get(0).getPuntoDeVenta(), this.puntoDeVenta);
	}

}
