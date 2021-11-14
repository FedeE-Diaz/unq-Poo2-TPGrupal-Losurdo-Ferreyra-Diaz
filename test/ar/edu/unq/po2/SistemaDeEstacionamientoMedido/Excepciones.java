package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Excepciones {
	
	private SEM sem;
	private SEMGestionEstacionamiento semGestorEstacionamiento ;
	@BeforeEach
	void setUp() throws Exception {
		this.sem = new SEM();
		this.semGestorEstacionamiento = this.sem.getMyEstacionamiento();
	}

	@Test
	void testGestionEstacionamientoBuscaEstacionamientosInexistentes() {

	  Exception thrown = Assertions.assertThrows(Exception.class, () -> {
	           this.semGestorEstacionamiento.getEstacionamientoDe("PatenteInexistente");
	  
	  });
	  
	  Assertions.assertEquals("Se busco un estacionamiento sin verificar su existencia", thrown.getMessage());
	}
}
