package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AppTest {
	
	private SEM sem;
	private App clienteApp1;
	private App clienteApp2;
	private Celular celu1;
	private Celular celu2;
	private Consola consola;
	private Zona zona1;
	
	@BeforeEach
	void setUp() throws Exception {
		sem = new SEM();
		celu1 = new Celular(1120132014);
		celu2 = new Celular(1120162020);
		clienteApp1 = new App(sem, "M3M0RY-13", celu1);
		clienteApp2 = new App(sem, "R3MXR0SW41D",celu2);
		consola = new Consola();
		zona1 = new Zona("Jorge");
		zona1.agregarPunto(new Punto());
		sem.agregarZona(zona1);
		
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
		assertEquals(celu2.getNumero(), clienteApp2.getNumeroTelefono());
	}
	

	@Test
	void testAvisosDeInicioSegunModo() {
		clienteApp1.agregarSubscriptor(consola);
		ArrayList<String> respuestaEsperada = new ArrayList<String>();
		respuestaEsperada.add("Alerta: Estas a punto de irte de tu auto sin haber realizado un estacionamiento");
		assertEquals(respuestaEsperada, clienteApp1.getModo().asistenciaInicioEstacionamiento());
		
		clienteApp1.cambiarModo();
		ArrayList<String> respuestaEsperada2 = new ArrayList<String>();
		respuestaEsperada2.add("Se ha iniciado una solicitud de estacionamiento automaticamente");
		assertEquals(respuestaEsperada2, clienteApp1.getModo().asistenciaInicioEstacionamiento());
		
		
	}
	@Test
	void testSubscribirInterfazGrafica() {
		clienteApp1.agregarSubscriptor(consola);
		
		assertTrue(clienteApp1.getSubscriptores().contains(consola));
		
	}
	
/*
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
*/
}
