package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEM {
		
		private int hora;
		private ArrayList<Usuario> listaDeUsuarios;
		private ArrayList<Infraccion> infracciones;
		private ArrayList<EstacionamientoVigente> estacionamientosActuales;
		private ArrayList<Zona> zonas;
		private final int precioEstacionamiento = 40;
		
		
	
		public SEM() {
			super();
			this.listaDeUsuarios = new ArrayList<Usuario>();
			this.infracciones = new ArrayList<Infraccion>();
			this.estacionamientosActuales = new ArrayList<EstacionamientoVigente>();
			this.zonas = new ArrayList<Zona>();
		}
		private ArrayList<Usuario> getListaDeUsuarios() {
			return listaDeUsuarios;
		}
		private ArrayList<Infraccion> getInfracciones() {
			return infracciones;
		}
		private ArrayList<EstacionamientoVigente> getEstacionamientosActuales() {
			return estacionamientosActuales;
		}
		private ArrayList<Zona> getZonas() {
			return zonas;
		}
		private int getPrecioEstacionamientoPorHora() {
			return precioEstacionamiento;
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
		public void finEstacionamiento(String patente) {
			//Tirar error(mediante algun mensaje o algo) o salvarlo con if, si la patente dada no existe dentro de la lista de estacionamientoVigente.
			if(this.esEstacionamientoVigente(patente)) {
				
				this.removerEstacionamientoVigente(this.getEstacionamientoDe(patente));
			}
		}
		private EstacionamientoVigente getEstacionamientoDe(String patente) { 
			// El mensaje solo puede ser invocado después de verificar la existencia del estacionamientoVigente (en este caso mediante esEstacionamientoVigente)
		    for (EstacionamientoVigente estacionamiento : this.getEstacionamientosActuales()) {
		        if (estacionamiento.esMismaPatente(patente)) {
		            return estacionamiento;
		        }
		    }
		    return null;
		}
		private void removerEstacionamientoVigente(EstacionamientoVigente estacionamiento) {
			this.getEstacionamientosActuales().remove(estacionamiento); 
		}
		public void agregarNuevoEstacionamiento(EstacionamientoVigente estacionamiento) {
			this.getEstacionamientosActuales().add(estacionamiento); 
		}
		public void cargarCredito(int numTelefono, int credito) {
			//TODO: crea un usuario nuevo si no habia
		}
		public void cargarInfraccion(String patente) {
			//TODO: completar
		}
		
}
