package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

import java.util.ArrayList;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InterfacesGraficas;

public class Notificadora {
	
	private App app;
	private ArrayList<InterfacesGraficas> subscriptores;
	
	public Notificadora(App app) {
		this.app = app;
		this.subscriptores = new ArrayList<InterfacesGraficas>();
	}

	public ArrayList<InterfacesGraficas> getSubscriptores() {
		return subscriptores;
	}
	public void notificarALasInterfacesGraficas(ArrayList<String> textoAMostrarEnPantalla) {
		for(InterfacesGraficas ig : subscriptores) {
			ig.popUpAviso(textoAMostrarEnPantalla); 
		}
	}

	public void agregarSubscriptor(InterfacesGraficas sub) {
		
		this.getSubscriptores().add(sub);
	}
}
