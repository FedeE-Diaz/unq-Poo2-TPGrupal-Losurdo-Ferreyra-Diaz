package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class Consola implements InterfacesGraficas{

	@Override
	public void popUpAviso(ArrayList<String> texto) {
		if(texto != null) {
			for(String t : texto) {
				System.out.println(t);
			}
		}
	}
}
