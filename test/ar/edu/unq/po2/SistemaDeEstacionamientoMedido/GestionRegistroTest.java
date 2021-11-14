package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

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
	void testCuandoSeCompranHorasDeEstacionamiento_SeCreaUnRegistroConLosDatos() {
		this.puntoDeVenta.iniciarEstacionamiento("ABC123", 5);
		
		assertEquals(sem.getMyRegistro().getCantidadDeRegistros(), 1);
		assertEquals(sem.getMyRegistro().getRegistros().get(0).getPuntoDeVenta(), this.puntoDeVenta);
	}
	
	@Test
	void testCuandoSeRecargaUnCelular_SeCreaUnRegistroConLosDatos() {
		this.puntoDeVenta.cargarCredito(123123, 500);
		
		assertEquals(sem.getMyRegistro().getCantidadDeRegistros(), 1);
		assertEquals(sem.getMyRegistro().getRegistros().get(0).getPuntoDeVenta(), this.puntoDeVenta);
	}

}
