package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;


public class SEM {
		
		private SEMGestionUsuario gestionUsuario;
		private SEMGestionInfraccion gestionInfraccion;
		private SEMGestionEstacionamiento gestionEstacionamiento;
		private SEMGestionZona gestionZona;
		private SEMGestionRegistro gestionRegistro;
		private final int precioEstacionamiento = 40;
	
		public SEM() {
			super();
			this.gestionUsuario = new SEMGestionUsuario();
			this.gestionInfraccion = new SEMGestionInfraccion();
			this.gestionEstacionamiento = new SEMGestionEstacionamiento();
			this.gestionZona = new SEMGestionZona();
			this.gestionRegistro = new SEMGestionRegistro();
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

		private int getPrecioEstacionamientoPorHora() {
			return precioEstacionamiento;
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
		}
		public void cargarInfraccion(String patente) {
			this.getMyInfraccion().cargarInfraccion(patente);
		}
		
}
