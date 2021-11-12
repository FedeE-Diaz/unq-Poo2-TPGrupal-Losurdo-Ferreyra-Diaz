package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

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
	void testUnaAPPInspectorPuedeVerificarUnaPatente() {		
		appInspector.verificarPatente("ABC123");
		assertEquals(sem.getMyInfraccion().getInfracciones().size(), 1);
	}
}
