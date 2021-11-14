package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoDeVentaTest {
	private SEM sem;
	private PuntoDeVenta puntoDeVenta;
	private Zona zona1;
	private App appUsuario;
	private Celular celularUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		this.sem = new SEM();
		this.zona1 = new Zona("Pepe");
		this.puntoDeVenta = new PuntoDeVenta(this.sem, this.zona1);
		this.celularUsuario = new Celular(1234);
		this.appUsuario = new App(this.sem, "def-303", this.celularUsuario);
	}

	@Test
	void testCuandoUnPuntoDeVentaIniciaUnEstacionamientoEsteSeRegistraEnElSem() {
		this.puntoDeVenta.iniciarEstacionamiento("abc-203", 3);
		
		assertTrue(this.sem.esEstacionamientoVigente("abc-203"));
	}

	@Test
	void testCuandoUnPuntoDeVentaCargaCreditoLaCantidadDeCreditoDelUsuarioAumentaEnLaCantidadCargada() {
		int cantidadASumar = 80;
		int creditoEsperado = appUsuario.saldoDisponible() + cantidadASumar;
		
		
		
		assertTrue()
	}

	@Test
	void testGetHoraActual() {
		fail("Not yet implemented");
	}

	@Test
	void testCargarCredito() {
		fail("Not yet implemented");
	}

}
