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
		public void finEstacionamiento(String patente) throws Exception{
			this.getMyEstacionamiento().finEstacionamiento(patente);
		}
		public EstacionamientoVigente getEstacionamientoDe(String patente) throws Exception { 
			return this.getMyEstacionamiento().getEstacionamientoDe(patente);
		}
		public void agregarNuevoEstacionamiento(EstacionamientoVigente estacionamiento) {
			this.getMyEstacionamiento().agregarNuevoEstacionamiento(estacionamiento);
		}
		public void cargarCredito(int numTelefono, int credito, PuntoDeVenta puntoDeVenta) {
			this.getMyGestionUsuario().cargarCredito(numTelefono,credito);
			this.registarCompraCredito(numTelefono, credito, puntoDeVenta);
		} 
		private void registarCompraCredito(int numTelefono, int credito, PuntoDeVenta puntoDeVenta) {
			this.getMyRegistro().registrarCompraCredito(numTelefono, credito, puntoDeVenta);			
		}
		public void registrarNuevasHoras(int horas,	PuntoDeVenta puntoDeVenta) {
			this.getMyRegistro().registrarCompraDeHoras(horas, puntoDeVenta);	
		}
		public void agregarZona(Zona zona) {
            this.getMyZona().agregarZona(zona);
        }
		public void cargarInfraccion(String patente, Zona zona) {
			this.getMyInfraccion().cargarInfraccion(patente, zona);
		}
		public Zona obtenerZonaDe(Punto punto) {
			return this.getMyZona().obtenerZonaDe(punto); // Si el punto no existe en ninguna zona, entonces devuelve null
		}
		public Usuario getUsuario(int numero) {
			return this.getMyGestionUsuario().getUsuarioDe(numero);
		}
		public int getHoraSistema() {
			return this.reloj.getHoraActual();
		}
		public void suscribir(Entidad entidad) {
			this.gestionMonitoreo.subscribirse(entidad);
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
		public void cobrarA(int precio, int numTelefono) {
			this.gestionUsuario.descontarCredito(precio, numTelefono);
		}
		public void notificar(AvisoGenerico aviso) {
			this.gestionMonitoreo.notificarSubscriptores(aviso);
		}
}

