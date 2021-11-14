package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionEstacionamiento{
	
	private SEMGestionApp gestionApp;
	private SEM sem;

	private final int precioEstacionamiento = 40;
	private ArrayList<EstacionamientoVigente> estacionamientosActuales;

	private ArrayList<EstacionamientoVigente> getEstacionamientosActuales() {
		return estacionamientosActuales;
	}

	public SEMGestionEstacionamiento(SEM sem) {
		super();
		this.estacionamientosActuales = new ArrayList<EstacionamientoVigente>();
		this.gestionApp = new SEMGestionApp(sem,this);
		this.sem = sem;

	}
	

	public int getPrecioEstacionamientoPorHora() {
		return precioEstacionamiento;
	}
	public boolean esEstacionamientoVigente(String patente) {
		return this.getEstacionamientosActuales().stream().anyMatch(p -> p.esMismaPatente(patente));
	}

	public EstacionamientoVigente getEstacionamientoDe(String patente) {
		// El mensaje solo debe ser invocado despu�s de verificar la existencia del estacionamientoVigente (en este caso mediante esEstacionamientoVigente)
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
		//TODO Tirar error(mediante algun mensaje o algo) o salvarlo con if, si la patente dada no existe dentro de la lista de estacionamientoVigente.
		if(this.esEstacionamientoVigente(patente)){
			
			this.removerEstacionamientoVigente(this.getEstacionamientoDe(patente));
		}
		
	}
	public ArrayList<String> iniciarNuevoEstacionamiento(App app) {
		return gestionApp.iniciarNuevoEstacionamiento(app);
	}

	public void actualizarEstadoEstacionamiento() {
		// TODO completar la parte de abajo comentada
		
		this.verificarFinalizacionDeTodosLosEstacionamientos();
		/* Esto lo que har� es darle la orden a todos los estacionamientos(pero solo tendra efecto en el de la app)
		 *  de revisar en cada uno de los estacionamientos vigentes, que si ya se completo una nueva hora desde que se inicio,
		 *   se vuelva a cobrar otros 40 por el estacionamiento.
		 */
		// por cada estacionamiento -> estacionamiento.actualizarEstado() o algo asi (ver� si es momento de cobrar dinero o no)
	
		
	}

	private void verificarFinalizacionDeTodosLosEstacionamientos() {
		if(this.esHoraDeFinalizar()) {
			this.finalizarTodosLosEstacionamientos();
		}
		
	}

	private boolean esHoraDeFinalizar() {
		
		return sem.getReloj().getHoraActual() >=20;
	}

	public void finalizarTodosLosEstacionamientos() {
		
		for(EstacionamientoVigente estacionamiento: this.getEstacionamientosActuales()) {
			this.removerEstacionamientoVigente(estacionamiento);
			estacionamiento.enviarNotificacion(this);
		}
		
	}
	public void notificarUsuario(int numTelefono) {
		// TODO Auto-generated method stub
		
	}


}