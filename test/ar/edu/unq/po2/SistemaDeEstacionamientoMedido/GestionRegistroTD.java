package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento.PuntoDeVenta;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.Zona;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEM;

class GestionRegistroTD {
	
	private SEM sem;
	private Zona zona;
	private PuntoDeVenta puntoDeVenta;

	@BeforeEach
	public void setUp() throws Exception {
		
		this.sem = mock(SEM.class);
		this.zona = new Zona("Ricardo");
		this.puntoDeVenta = new PuntoDeVenta(sem, zona);
	}
	
	@Test
	void testCuandoSeCompranHorasDeEstacionamiento_SeCreaUnRegistroConLosDatos() {
		this.puntoDeVenta.iniciarEstacionamiento("ABC123", 5);
		
		verify(this.sem).registrarNuevasHoras(5, this.puntoDeVenta);		
	}
	
	@Test
	void testCuandoSeRecargaUnCelular_SeCreaUnRegistroConLosDatos() {
		this.puntoDeVenta.cargarCredito(123123, 500);
		
		verify(this.sem).cargarCredito(123123, 500, this.puntoDeVenta);
	}

}
