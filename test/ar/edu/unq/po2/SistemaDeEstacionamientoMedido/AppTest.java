package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AppTest {
	
	private SEM sem;
	private App clienteApp1;
	private App clienteApp2;
	private Celular celu1;
	private Celular celu2;

	@BeforeEach
	void setUp() throws Exception {
		sem = new SEM();
		celu1 = new Celular(1120132014);
		celu2 = new Celular(1120162020);
		clienteApp1 = new App(sem, "M3M0RY-13", celu1);
		clienteApp2 = new App(sem, "R3MXR0SW41D",celu2);
	}
	@Test
	void testGetUsuario() {
		assertTrue(sem.getMyGestionUsuario().getListaDeUsuarios().contains(clienteApp1.getUsuario()));
		assertEquals(celu1.getNumero(), clienteApp1.getUsuario().getNumTelefonoAsociado());
	}

	@Test
	void testGetPatente() {
		assertEquals("M3M0RY-13", clienteApp1.getPatente());
	}

	@Test
	void testGetSem() {
		assertEquals(sem, clienteApp1.getSem());
	}

	@Test
	void testSetPatente() {
		assertEquals("M3M0RY-13", clienteApp1.getPatente());
		clienteApp1.setPatente("M3M3NT0M0R1");
		assertEquals("M3M3NT0M0R1", clienteApp1.getPatente());
	}
	@Test
	void testGetModo() {
		Automatico nuevoModo = new Automatico(clienteApp1);
		
		clienteApp1.setModo(nuevoModo);
		assertEquals(nuevoModo, clienteApp1.getModo());
	}
	@Test
	void testSetModo() {
		Manual nuevoModo = new Manual(clienteApp1);
		
		clienteApp1.setModo(nuevoModo);
		assertEquals(nuevoModo, clienteApp1.getModo());
	}

	@Test
	void testGetNumeroTelefono() {
		assertEquals(celu1.getNumero(), clienteApp1.getNumeroTelefono());
	}

	@Test
	void testApp() {
		fail("Not yet implemented");
	}

	@Test
	void testCambiarModo() {
		fail("Not yet implemented");
	}

	@Test
	void testConsultarSaldoDisponible() {
		fail("Not yet implemented");
	}

	@Test
	void testSaldoDisponible() {
		fail("Not yet implemented");
	}

	@Test
	void testIniciarEstacionamiento() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalizarEstacionamiento() {
		fail("Not yet implemented");
	}

	@Test
	void testDriving() {
		fail("Not yet implemented");
	}

	@Test
	void testWalking() {
		fail("Not yet implemented");
	}

	@Test
	void testGetZonaActual() {
		fail("Not yet implemented");
	}

	@Test
	void testHayEstacionamientoVigente() {
		fail("Not yet implemented");
	}

	@Test
	void testEstoyEnElMismoPuntoQueElEstacionamiento() {
		fail("Not yet implemented");
	}

	@Test
	void testEstoyEnUnaZonaDeEstacionamientoMedido() {
		fail("Not yet implemented");
	}

}
