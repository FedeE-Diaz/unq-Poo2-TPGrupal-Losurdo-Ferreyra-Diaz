package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Celular;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.EstacionamientoVigente;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.APPInspector;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.Zona;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEM;


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
			
		this.estacionamiento = new EstacionamientoVigente("ABC123", 12, 14, this.zona);
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYNoLoEs_RecibeUnaRespuestaNegativa() {
		assertFalse(appInspector.esEstacionamientoVigente("ABC123"), "Error en no es un estacionamiento vigente");
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYLoEs_RecibeUnaRespuestaPositiva() {
		Punto punto = new Punto();
		zona.agregarPunto(punto); // se agrega a la Zona el Punto por defecto, el mismo donde está ubicado el Inspector
		
		sem.agregarNuevoEstacionamiento(estacionamiento);
		
		assertTrue(appInspector.esEstacionamientoVigente("ABC123"), "Error en es un estacionamiento vigente"); 
		assertFalse(sem.getMyInfraccion().tieneUnaInfraccion("ABC123"));
	}
	
	@Test
	void cuandoUnaPatenteNoTieneUnEstacionamientoVigente_LaAppInspectorLeCargaUnaInfraccion() {		
		Punto punto = new Punto();
		zona.agregarPunto(punto); // se agrega a la Zona el Punto por defecto, el mismo donde está ubicado el Inspector
		
		appInspector.verificarPatente("34VCS"); // la patente 34VCS no tiene un estacionamiento vigente
		
		assertEquals(sem.getMyInfraccion().getCantidadDeInfracciones(), 1, "Error en cargar la infracción correspondiente"); //el inspector ha cargado la infracción
		assertTrue(sem.getMyInfraccion().tieneUnaInfraccion("34VCS"));
	}
	
	@Test 
	void cuandoUnaPatenteNoTieneEstacionamientoVigente_PeroLaZonaNoLeCorrespondeAlInspector_NoSeCargaLaInfraccion() {
		Punto punto = new Punto(10, 20); 
		zona.agregarPunto(punto);    // Se agrega a la Zona un punto con coordenadas que no pertenecen a la que el Inspector está parado (según el GPS de su celular)
		
		appInspector.verificarPatente("34VCS");
		
		assertEquals(sem.getMyInfraccion().getCantidadDeInfracciones(), 0); // La patente 34VCS no tiene Estacionamiento Vigente, pero el Inspector no puede cargar la infracción 
		assertFalse(sem.getMyInfraccion().tieneUnaInfraccion("34VCS"));     // No se cargó la infracción
	}
	
	@Test
	void cuandoUnaPatenteTieneUnEstacionamientoVigente_LaAppInspectorNoLeCargaUnaInfraccion() {
		Punto punto = new Punto();
		zona.agregarPunto(punto); // se agrega a la Zona el Punto por defecto, el mismo donde está ubicado el Inspector
		
		sem.agregarNuevoEstacionamiento(estacionamiento);
		
		appInspector.verificarPatente("ABC123"); //ABC123 es una patente que tiene un estacionamiento en la zona de inspección del inspector
		
		assertEquals(sem.getMyInfraccion().getCantidadDeInfracciones(), 0); //el inspector no ha cargado la infracción
		assertFalse(sem.getMyInfraccion().tieneUnaInfraccion("ABC123"));
	}
}
