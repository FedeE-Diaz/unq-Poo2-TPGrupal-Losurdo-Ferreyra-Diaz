package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class APPInspectorTest {
	
	private APPInspector appInspector;
	private SEM sem;
	private Celular celular;

	@BeforeEach
	public void setUp() throws Exception {
		this.sem          = new SEM();
		this.celular      = new Celular(123123);
		this.appInspector = new APPInspector(sem, celular);;
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYNoLoEs_RecibeUnaRespuestaNegativa() {
		assertFalse(appInspector.esEstacionamientoVigente("ABC123"));
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYLoEs_RecibeUnaRespuestaPositiva() {
		//TODO: Hacer con EstacionamientoVigente
		assertFalse(appInspector.esEstacionamientoVigente("ABC123")); 
	}
	
	@Test
	void cuandoUnaPatenteNoTieneUnEstacionamientoVigente_LaAppInspectorLeCargaUnaInfraccion() {		
		appInspector.verificarPatente("ABC123"); // la patente ABC123 no tiene un estacionamiento vigente
		assertEquals(sem.getMyInfraccion().getInfracciones().size(), 1);
		assertEquals(sem.getMyInfraccion().getInfracciones().get(0).getPatente(), "ABC123");
		// utilizo el .get(0) porque hay una única infracción en la lista de infracciones
	}
	
	@Test
	void cuandoUnaPatenteTieneUnEstacionamientoVigente_LaAppInspectorNoLeCargaUnaInfraccion() {
		// TODO: hacer con EstacionamientoVigente
	}
}
