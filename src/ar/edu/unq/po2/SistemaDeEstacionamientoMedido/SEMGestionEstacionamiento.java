package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionEstacionamiento{
	
	private SEMGestionApp gestionApp;
	private SEM sem;

	private final int precioEstacionamiento = 40;
	private ArrayList<EstacionamientoVigente> estacionamientosActuales;

	public ArrayList<EstacionamientoVigente> getEstacionamientosActuales() {
		return estacionamientosActuales;
	}

	public SEMGestionEstacionamiento(SEM sem) {
		super();
		this.estacionamientosActuales = new ArrayList<EstacionamientoVigente>();
		this.gestionApp = new SEMGestionApp(sem,this);
		this.sem = sem;
	}
	
	public SEMGestionApp getGestionApp() {
		return gestionApp;
	}

	public int getPrecioEstacionamientoPorHora() {
		return precioEstacionamiento;
	}
	
	public boolean esEstacionamientoVigente(String patente) {
		return this.getEstacionamientosActuales().stream().anyMatch(p -> p.esMismaPatente(patente));
	}

	public EstacionamientoVigente getEstacionamientoDe(String patente)throws Exception {
		// El mensaje solo debe ser invocado después de verificar la existencia del estacionamientoVigente (en este caso mediante esEstacionamientoVigente)
	    for (EstacionamientoVigente estacionamiento : this.getEstacionamientosActuales()) {
	        if (estacionamiento.esMismaPatente(patente)) {
	            return estacionamiento;
	        }
	    }
	    throw new Exception("Se busco un estacionamiento sin verificar su existencia");
	}

	public void removerEstacionamientoVigente(EstacionamientoVigente estacionamiento) {
		this.getEstacionamientosActuales().remove(estacionamiento); 
		
	}

	public void agregarNuevoEstacionamiento(EstacionamientoVigente estacionamiento) {
		this.getEstacionamientosActuales().add(estacionamiento);
		estacionamiento.actualizar(this.sem.getHoraSistema(),this);
		this.sem.notificar(new AvisoInicio(estacionamiento));
	}

	public void finEstacionamiento(String patente) throws Exception{
		if(this.esEstacionamientoVigente(patente)){	
			this.sem.notificar(new AvisoFinal(this.getEstacionamientoDe(patente)));
			this.removerEstacionamientoVigente(this.getEstacionamientoDe(patente));
		}
	}
	
	public ArrayList<String> iniciarNuevoEstacionamiento(App app) {
		return this.getGestionApp().iniciarNuevoEstacionamiento(app);
	}

	public void actualizarEstadoEstacionamiento() {
		// TODO completar la parte de abajo comentada
		
		this.verificarFinalizacionDeTodosLosEstacionamientos();
		for(EstacionamientoVigente estacionamiento : estacionamientosActuales) {
			estacionamiento.actualizar(sem.getHoraSistema(), this);
		}
		/* Esto lo que hará es darle la orden a todos los estacionamientos(pero solo tendra efecto en el de la app)
		 *  de revisar en cada uno de los estacionamientos vigentes, que si ya se completo una nueva hora desde que se inicio,
		 *   se vuelva a cobrar otros 40 por el estacionamiento.
		 */
		// por cada estacionamiento -> estacionamiento.actualizarEstado() o algo asi (verá si es momento de cobrar dinero o no)
	
		
	}
	public void cobrarA(int numTelefono) {
		this.sem.cobrarA(this.precioEstacionamiento, numTelefono);
	}

	private void verificarFinalizacionDeTodosLosEstacionamientos() {
		if(this.esHoraDeFinalizar()) {
			this.finalizarTodosLosEstacionamientos();
		}
	}

	private boolean esHoraDeFinalizar() {
		
		return sem.getHoraSistema() >=20;
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