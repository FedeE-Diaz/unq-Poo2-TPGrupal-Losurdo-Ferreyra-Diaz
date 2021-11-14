package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEM implements Temporizador{
		
		private SEMGestionUsuario gestionUsuario;
		private SEMGestionInfraccion gestionInfraccion;
		private SEMGestionEstacionamiento gestionEstacionamiento;
		private SEMGestionZona gestionZona;
		private SEMGestionRegistro gestionRegistro;
		private SEMGestionMonitoreo gestionMonitoreo;
		private Reloj reloj;
		
		public SEM() {
			super();
			this.gestionUsuario = new SEMGestionUsuario();
			this.gestionInfraccion = new SEMGestionInfraccion();
			this.gestionEstacionamiento = new SEMGestionEstacionamiento(this);
			this.gestionZona = new SEMGestionZona();
			this.gestionRegistro = new SEMGestionRegistro();
			this.gestionMonitoreo = new SEMGestionMonitoreo();
			this.reloj = new Reloj();
			reloj.agregarObservador(this);
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
		
		public Reloj getReloj() {
			return reloj;
		}
		public int getPrecioEstacionamientoPorHora() {
			return this.getMyEstacionamiento().getPrecioEstacionamientoPorHora();
		}
		public boolean esEstacionamientoVigente(String patente) {
			return this.getMyEstacionamiento().esEstacionamientoVigente(patente);	
		}
		public void finEstacionamiento(String patente) {
			this.getMyEstacionamiento().finEstacionamiento(patente);
		}
		public EstacionamientoVigente getEstacionamientoDe(String patente) { 
			return this.getMyEstacionamiento().getEstacionamientoDe(patente);
		}
		public void removerEstacionamientoVigente(EstacionamientoVigente estacionamiento) {
			this.getMyEstacionamiento().removerEstacionamientoVigente(estacionamiento);
		}
		public void agregarNuevoEstacionamiento(EstacionamientoVigente estacionamiento) {
			this.getMyEstacionamiento().agregarNuevoEstacionamiento(estacionamiento);
		}
		public void cargarCredito(int numTelefono, int credito) {
			this.getMyGestionUsuario().cargarCredito(numTelefono,credito);
		} 
		public void cargarInfraccion(String patente, Inspector inspector, Zona zona) {
			this.getMyInfraccion().cargarInfraccion(patente, inspector, zona);
		}
		public Zona obtenerZonaDe(Punto punto) {
			return this.getMyZona().obtenerZonaDe(punto); // Si el punto no existe en ninguna zona, entonces devuelve null
		}
		public Usuario getUsuario(int numero) {
			return this.getMyGestionUsuario().getUsuarioDe(numero);
		}
		@Override
		public void actualizarReloj() {
			this.getMyEstacionamiento().actualizarEstadoEstacionamiento();
		}
		public ArrayList<String> iniciarNuevoEstacionamiento(App app) {
			return this.getMyEstacionamiento().iniciarNuevoEstacionamiento(app);
		}
		public void crearUsuarioDesdeApp(App app,int numTel) {
			this.getMyGestionUsuario().crearUsuarioDesdeApp(app,numTel);
		}
}
