package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Celular;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.APPInspector;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.Zona;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEM;

class APPInspectorTD {

	private APPInspector appInspector;
	private SEM sem;
	private Celular celular;
	private Zona zona;

	@BeforeEach
	public void setUp() throws Exception {
		this.sem          = mock(SEM.class);
		this.celular      = new Celular(123123);
		this.zona         = new Zona("Roberto");
		this.appInspector = new APPInspector(this.sem, this.celular, this.zona);
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYNoLoEs_RecibeUnaRespuestaNegativa() {
		when(sem.esEstacionamientoVigente("ABC123")).thenReturn(false);
		
		assertFalse(appInspector.esEstacionamientoVigente("ABC123"));
	}
	
	@Test
	void cuandoUnaAPPInspectorPreguntaSiUnaPatenteEsEstacionamientoVigenteYLoEs_RecibeUnaRespuestaPositiva() {
		Punto punto = new Punto();
		zona.agregarPunto(punto); // se agrega a la Zona el Punto por defecto, el mismo donde está ubicado el Inspector
				
		when(sem.esEstacionamientoVigente("34VCS")).thenReturn(true);
		verify(this.sem, never()).cargarInfraccion("34VC2", zona);
	}
		
	@Test
	void cuandoUnaPatenteNoTieneUnEstacionamientoVigente_LaAppInspectorLeCargaUnaInfraccion() {
		Punto punto = new Punto();
		zona.agregarPunto(punto);
		
		appInspector.verificarPatente("ABC123");
		
		when(sem.esEstacionamientoVigente("ABC123")).thenReturn(false);
		verify(this.sem).cargarInfraccion("ABC123", zona);		
	}
	
	@Test 
	void cuandoUnaPatenteNoTieneEstacionamientoVigente_PeroLaZonaNoLeCorrespondeAlInspector_NoSeCargaLaInfraccion() {
		Punto punto = new Punto(10, 20); 
		zona.agregarPunto(punto);
		
		appInspector.verificarPatente("34VCS");
		
		when(sem.esEstacionamientoVigente("34VCS")).thenReturn(false);
		verify(this.sem, never()).cargarInfraccion("34VC2", zona);
		// Se verifica que si bien 34VCS no es un estacionamiento vigente, SEM nunca recibió
		// el mensaje cargarInfraccion porque el inspector no es de esa zona
	}
}
