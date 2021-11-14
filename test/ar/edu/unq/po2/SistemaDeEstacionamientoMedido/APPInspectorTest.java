package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class APPInspectorTest {
	
	private APPInspector appInspector;
	private SEM sem;
	private Celular celular;
	private Zona zona;
	private EstacionamientoVigente estacionamiento;

	@BeforeEach
	public void setUp() throws Exception {
		this.sem          = new SEM();
		this.celular      = new Celular(123123);
		this.zona         = new Zona("Roberto");
		this.appInspector = new APPInspector(this.sem, this.celular, this.zona);
		
		Punto punto = new Punto();
		zona.agregarPunto(punto); // todos los puntos son iguales, es decir, el punto de la zona asignada al inspector será el mismo donde está
			                      // el inspector actualmente, por lo que tendrá derecho a hacer la infracción
		
		
		this.estacionamiento = new EstacionamientoVigente("ABC123", 12, 14, this.zona);
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYNoLoEs_RecibeUnaRespuestaNegativa() {
		assertFalse(appInspector.esEstacionamientoVigente("ABC123"), "Error en no es un estacionamiento vigente");
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYLoEs_RecibeUnaRespuestaPositiva() {
		sem.agregarNuevoEstacionamiento(estacionamiento);
		
		assertTrue(appInspector.esEstacionamientoVigente("ABC123"), "Error en es un estacionamiento vigente"); 
	}
	
	@Test
	void cuandoUnaPatenteNoTieneUnEstacionamientoVigente_LaAppInspectorLeCargaUnaInfraccion() {		
		appInspector.verificarPatente("34VCS"); // la patente 34VCS no tiene un estacionamiento vigente
		
		assertEquals(sem.getMyInfraccion().getCantidadDeInfracciones(), 1, "Error en cargar la infracción correspondiente"); //el inspector ha cargado la infracción
	}
	
	@Test
	void cuandoUnaPatenteTieneUnEstacionamientoVigente_LaAppInspectorNoLeCargaUnaInfraccion() {
		sem.agregarNuevoEstacionamiento(estacionamiento);
		
		appInspector.verificarPatente("ABC123"); //ABC123 es una patente que tiene un estacionamiento en la zona de inspección del inspector
		
		assertEquals(sem.getMyInfraccion().getCantidadDeInfracciones(), 0); //el inspector no ha cargado la infracción
	}
}
