package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class Punto {

	int x = 0;
	int y = 1;
	// Esta clase es representativa del punto que seria dado por el GPS
	
	public Punto() {
		// este punto toma los valores por defecto
		super();
	}
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean esMismoPunto(Punto punto) {
		return punto.x == this.x && 
			   punto.y == this.y;
		// lo que hace en realidad es comparar los valores de x e y de cada punto y de esta forma
		// determinar si son del mismo punto
	}
}
