package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App.App;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App.Automatico;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App.Manual;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Celular;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.PuntoDeVenta;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.Zona;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Reloj.Temporizador;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEM;


class AppTest {
	
	private SEM sem;
	private App clienteApp1;
	private App clienteApp2;
	private Celular celu1;
	private Celular celu2;
	private Consola consola;
	private Zona zona1;
	private PuntoDeVenta puntoDeVenta;
	private Temporizador temporizadorSem;
	
	@BeforeEach
	void setUp() throws Exception {
		sem = new SEM();
		celu1 = new Celular(1120132014);
		celu2 = new Celular(1120162020);
		clienteApp1 = new App(sem, "M3M0RY-13", celu1);
		clienteApp2 = new App(sem, "R3MXR0SW41D",celu2);
		consola = new Consola();
		zona1 = new Zona("Jorge");
		puntoDeVenta = new PuntoDeVenta(this.sem, this.zona1);
		zona1.agregarPunto(new Punto());
		sem.agregarZona(zona1);
		temporizadorSem = this.sem.getTemporizador();		
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
		
		clienteApp1.cambiarModo(new Automatico(clienteApp1));
		clienteApp1.cambiarModo(new Manual(clienteApp1));
		clienteApp1.cambiarModo(new Automatico(clienteApp1));// un usuario cambia de modo 2 veces para verificar que anda el cambio
		ArrayList<String> respuestaEsperada2 = new ArrayList<String>();
		respuestaEsperada2.add("Se ha iniciado una solicitud de estacionamiento automaticamente");
		respuestaEsperada2.add("Saldo insuficiente. Estacionamiento no permitido.");
		assertEquals(respuestaEsperada2, clienteApp1.getModo().asistenciaInicioEstacionamiento());
		
		
	}
	@Test
	void testSubscribirInterfazGrafica() {
		clienteApp1.agregarSubscriptor(consola);
		
		assertTrue(clienteApp1.getSubscriptores().contains(consola));
		
	}
	
	@Test
	void testAvisosDeFinalDeEstacionamientoSegunModoManual() throws Exception {
		puntoDeVenta.cargarCredito(1120132014, 50); // se carga credito antes de iniciar el estacionamiento	
		clienteApp1.agregarSubscriptor(consola);
		clienteApp1.iniciarEstacionamiento("M3M0RY-13");
		
		ArrayList<String> respuestaEsperada = new ArrayList<String>();
		respuestaEsperada.add("Alerta: Hemos detectado que te estas a punto de ir sin haber finalizado el estacionamiento");
		assertEquals(respuestaEsperada, clienteApp1.getModo().asistenciaFinEstacionamiento());
	}
	
	@Test
	void testAvisoDeFinalDeEstacionamientoSegunModoAutomatico() throws Exception {
		puntoDeVenta.cargarCredito(1120132014, 50); // se carga credito antes de iniciar el estacionamiento	
		clienteApp1.agregarSubscriptor(consola);
		clienteApp1.iniciarEstacionamiento("M3M0RY-13");
		
		clienteApp1.cambiarModo(new Automatico(clienteApp1));
		
		ArrayList<String> respuestaEsperada2 = new ArrayList<String>();
		respuestaEsperada2.add("Se ha finalizado el estacionamiento actual automaticamente");
		assertEquals(respuestaEsperada2, clienteApp1.getModo().asistenciaFinEstacionamiento());
	}

	@Test
	void testConsultarSaldoDisponible() {
		assertEquals("Su saldo disponible es: 0", clienteApp1.consultarSaldoDisponible());
	}

	@Test
	void testSaldoDisponible() {
		assertEquals(0, clienteApp1.saldoDisponible());
	}

	@Test
	void testIniciarEstacionamientoAuto() {
		clienteApp1.cambiarModo(new Automatico(clienteApp1));
		ArrayList<String> respuestaEsperada = new ArrayList<String>();
		respuestaEsperada.add("Saldo insuficiente. Estacionamiento no permitido.");
		assertEquals(respuestaEsperada, clienteApp1.iniciarEstacionamiento(clienteApp1.getPatente()));
	}
	
	@Test
	void testIniciarEstacionamientoManual() {
		ArrayList<String> respuestaEsperada = new ArrayList<String>();
		respuestaEsperada.add("Saldo insuficiente. Estacionamiento no permitido.");
		assertEquals(respuestaEsperada, clienteApp1.iniciarEstacionamiento("IW4NTSL33P"));
		assertEquals("IW4NTSL33P", clienteApp1.getPatente()); 
	}

	@Test
	void testFinalizarEstacionamiento() throws Exception {
		clienteApp1.getUsuario().sumarCredito(40);
		clienteApp1.iniciarEstacionamiento(clienteApp1.getPatente());
		assertTrue(clienteApp1.hayEstacionamientoVigente());
		clienteApp1.finalizarEstacionamiento(clienteApp1.getPatente());
		assertFalse(sem.esEstacionamientoVigente("M3M0RY-13"));
	}
	
	@Test
	void testDriving() throws Exception{
		clienteApp1.cambiarModo(new Automatico(clienteApp1));
		clienteApp2.agregarSubscriptor(consola);
		clienteApp2.getUsuario().sumarCredito(40);
		clienteApp2.iniciarEstacionamiento(clienteApp2.getPatente());
		clienteApp2.driving();
	}
	
	@Test
	void testWalkingIrseSinHaberHechoEstacionamiento() {
		clienteApp2.agregarSubscriptor(consola);
		clienteApp2.getUsuario().sumarCredito(40);
		clienteApp2.walking();
	}

	@Test
	void testCuandoUnaAppIniciaUnEstacionamientoElCreditoDelUsuarioSeConsume() {
		puntoDeVenta.cargarCredito(1120132014, 40);
		clienteApp1.iniciarEstacionamiento("abc-123");
		
		assertEquals("Su saldo disponible es: 0",clienteApp1.consultarSaldoDisponible());
	}
	
	@Test
	void testCuandoUnaAppIniciaUnEstacionamientoYTranscurreMenosDeUnaHoraElCreditoNoCambia() {
		puntoDeVenta.cargarCredito(1120132014, 120);
		clienteApp1.iniciarEstacionamiento("abc-123");
		this.temporizadorSem.simularTiempo(30);  // solo pas? un minuto
		
		assertEquals("Su saldo disponible es: 80",clienteApp1.consultarSaldoDisponible());
	}
	
	@Test
	void testCuandoUnUsuarioPreExisteAUnaAppLaCreacionLeAsginaLaAppAlUsuario() {
		App app;
		puntoDeVenta.cargarCredito(1234, 200);
		app = new App(this.sem,"abc-123", new Celular(1234));
		
		assertEquals("Su saldo disponible es: 200", app.consultarSaldoDisponible());
	}
	
	@Test
	void testCuandoSeHacenLas20LosEstacionamientosFinalizan() {
		puntoDeVenta.cargarCredito(1120132014, 600);
		clienteApp1.iniciarEstacionamiento("abc-123");
		this.temporizadorSem.simularTiempo(781);
		
		assertFalse(sem.esEstacionamientoVigente("abc-123"));
	}
}
