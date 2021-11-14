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
	private int numeroDeUsuarioInexistente;
	
	@BeforeEach
	void setUp() throws Exception {
		this.sem = new SEM();
		this.zona1 = new Zona("Pepe");
		this.sem.agregarZona(zona1);
		this.puntoDeVenta = new PuntoDeVenta(this.sem, this.zona1);
		this.celularUsuario = new Celular(1234);
		this.appUsuario = new App(this.sem, "def-303", this.celularUsuario);
		this.numeroDeUsuarioInexistente = 4321;
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
		
		this.puntoDeVenta.cargarCredito(1234,cantidadASumar);
		
		assertEquals(this.appUsuario.saldoDisponible(), creditoEsperado);
	}

	@Test
	void testCuandoUnPuntoDeVentaCargaCreditoParaUnNumeroQueNoTieneUsuarioSeGeneraUnNuevousuario() {
		Usuario usuarioInexistentePreviaCarga = this.sem.getUsuario(this.numeroDeUsuarioInexistente);
		
		this.puntoDeVenta.cargarCredito(numeroDeUsuarioInexistente, 80);
		
		assertFalse(usuarioInexistentePreviaCarga == this.sem.getUsuario(numeroDeUsuarioInexistente));

	}

}
