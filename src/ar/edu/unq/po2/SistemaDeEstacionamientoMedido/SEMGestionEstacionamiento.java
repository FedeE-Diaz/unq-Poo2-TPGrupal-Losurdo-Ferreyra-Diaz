package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionEstacionamiento {
	
	
	private ArrayList<EstacionamientoVigente> estacionamientosActuales;

	private ArrayList<EstacionamientoVigente> getEstacionamientosActuales() {
		return estacionamientosActuales;
	}

	public SEMGestionEstacionamiento() {
		super();
		this.estacionamientosActuales = new ArrayList<EstacionamientoVigente>();
	}

	public boolean esEstacionamientoVigente(String patente) {
		return this.getEstacionamientosActuales().stream().anyMatch(p -> p.esMismaPatente(patente));
	}

	public void finalizarTodosLosEstacionamientos() {
		//TODO: falta evaluar de alguna forma(en algun lado) la hora en la que se debe enviar este mensaje y quiza agregar un comprobador de hora?
		for(EstacionamientoVigente estacionamiento: this.getEstacionamientosActuales()) {
			this.removerEstacionamientoVigente(estacionamiento);
			estacionamiento.enviarNotificacion();
			//TODO: agregar un mensaje hook o algo que se encargue de enviar el mensaje a la app de los estacionamientosApp de que termino 
		}
		
	}

	public EstacionamientoVigente getEstacionamientoDe(String patente) {
		// El mensaje solo debe ser invocado después de verificar la existencia del estacionamientoVigente (en este caso mediante esEstacionamientoVigente)
	    for (EstacionamientoVigente estacionamiento : this.getEstacionamientosActuales()) {
	        if (estacionamiento.esMismaPatente(patente)) {
	            return estacionamiento;
	        }
	    }
	    return null;
		
	}

	public void removerEstacionamientoVigente(EstacionamientoVigente estacionamiento) {
		this.getEstacionamientosActuales().remove(estacionamiento); 
		
	}

	public void agregarNuevoEstacionamiento(EstacionamientoVigente estacionamiento) {
		this.getEstacionamientosActuales().add(estacionamiento); 
	}

	public void finEstacionamiento(String patente) {
		//Tirar error(mediante algun mensaje o algo) o salvarlo con if, si la patente dada no existe dentro de la lista de estacionamientoVigente.
		if(this.esEstacionamientoVigente(patente)) {
			
			this.removerEstacionamientoVigente(this.getEstacionamientoDe(patente));
		}
		
	}
	
}
