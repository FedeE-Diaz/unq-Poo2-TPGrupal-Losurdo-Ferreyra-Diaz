package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class Punto {

	int x = 0;
	int y = 1;
	// Esta clase es representativa del punto que seria dado por el GPS
	
	public boolean esMismoPunto(Punto punto) {
		return true;
		// lo que hace en realidad es comparar los valores de x e y de cada punto y de esta forma
		// determinar si son del mismo punto, pero debido a que la logica del punto no es necesaria que fuera implementada,
		// lo simplificamos para poder enfocarnos mejor en la representacion y funcionamiento de las demas cosas
	}
}
