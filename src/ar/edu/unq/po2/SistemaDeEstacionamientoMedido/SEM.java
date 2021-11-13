package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;


public class SEM {
		
		private SEMGestionUsuario gestionUsuario;
		private SEMGestionInfraccion gestionInfraccion;
		private SEMGestionEstacionamiento gestionEstacionamiento;
		private SEMGestionZona gestionZona;
		private SEMGestionRegistro gestionRegistro;
		private SEMGestionMonitoreo gestionMonitoreo;
	
		public SEM() {
			super();
			this.gestionUsuario = new SEMGestionUsuario();
			this.gestionInfraccion = new SEMGestionInfraccion();
			this.gestionEstacionamiento = new SEMGestionEstacionamiento();
			this.gestionZona = new SEMGestionZona();
			this.gestionRegistro = new SEMGestionRegistro();
			this.gestionMonitoreo = new SEMGestionMonitoreo();
		}
		public SEMGestionUsuario getMyGestionUsuario() {
			return gestionUsuario;
		}

		public SEMGestionInfraccion getMyInfraccion() {
			return gestionInfraccion;
		}

		public SEMGestionEstacionamiento getMyEstacionamiento() {
			return gestionEstacionamiento;
		}

		public SEMGestionZona getMyZona() {
			return gestionZona;
		}

		public SEMGestionRegistro getMyRegistro() {
			return gestionRegistro;
		}
		
		public SEMGestionMonitoreo getMyGestionMonitoreo() {
			return gestionMonitoreo;
		}
		
		public int getPrecioEstacionamientoPorHora() {
			return this.getMyEstacionamiento().getPrecioEstacionamientoPorHora();
		}
		public boolean esEstacionamientoVigente(String patente) {
			return this.getMyEstacionamiento().esEstacionamientoVigente(patente);	
		}
		public void finalizarTodosLosEstacionamientos() {
			this.getMyEstacionamiento().finalizarTodosLosEstacionamientos();
		}
		public void finEstacionamiento(String patente) {
			this.getMyEstacionamiento().finEstacionamiento(patente);
		}
		private EstacionamientoVigente getEstacionamientoDe(String patente) { 
			return this.getMyEstacionamiento().getEstacionamientoDe(patente);
		}
		private void removerEstacionamientoVigente(EstacionamientoVigente estacionamiento) {
			this.getMyEstacionamiento().removerEstacionamientoVigente(estacionamiento);
		}
		public void agregarNuevoEstacionamiento(EstacionamientoVigente estacionamiento) {
			this.getMyEstacionamiento().agregarNuevoEstacionamiento(estacionamiento);
		}
		public void cargarCredito(int numTelefono, int credito) {
			this.getMyGestionUsuario().cargarCredito(numTelefono,credito);
		} //se corrigio el nombre
		public void cargarInfraccion(String patente) {
			this.getMyInfraccion().cargarInfraccion(patente);
		}
		public Zona obtenerZonaDe(GPS gps) {
			return this.getMyZona().obtenerZonaDe(gps);
		}
		public Usuario getUsuario(int numero) {
			return this.getMyGestionUsuario().getUsuarioDe(numero);
		}
		public void actualizarEstadoEstacionamiento() {
			this.getMyEstacionamiento().actualizarEstadoEstacionamiento();
		}
		
}
