package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfraccionTest {
	
	private Infraccion infraccion1;
	private Zona zona;
	private LocalDateTime fechaHora;

	@BeforeEach
	public void setUp() throws Exception {
		this.zona = new Zona("Sergio");
		this.infraccion1 = new Infraccion("ABC123", zona);
		this.fechaHora = LocalDateTime.now();
	}
	
	@Test
	void testGetInspector() {
		assertEquals(infraccion1.getInspector(), "Sergio", "Error en obtener el inspector");
	}

	@Test
	void testGetZona() {
		assertEquals(infraccion1.getZona(), zona, "Error en obtener la zona");
	}

	@Test
	void testGetFechaYHora() {
		assertEquals(infraccion1.getFechaYHora(), fechaHora, "Error en obtener la fecha y hora");
	}

	@Test
	void testGetPatente() {
		assertEquals(infraccion1.getPatente(), "ABC123", "Error en obtener la patente");
	}

}
