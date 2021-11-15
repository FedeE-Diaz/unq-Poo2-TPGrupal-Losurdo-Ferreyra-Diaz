package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEM implements RelojListener {
		
		private SEMGestionUsuario gestionUsuario;
		private SEMGestionInfraccion gestionInfraccion;
		private SEMGestionEstacionamiento gestionEstacionamiento;
		private SEMGestionZona gestionZona;
		private SEMGestionRegistro gestionRegistro;
		private SEMGestionMonitoreo gestionMonitoreo;
		private Reloj reloj;
		private Temporizador temporizador;
		
		public SEM() {
			super();
			this.gestionUsuario = new SEMGestionUsuario();
			this.gestionInfraccion = new SEMGestionInfraccion();
			this.gestionEstacionamiento = new SEMGestionEstacionamiento(this);
			this.gestionZona = new SEMGestionZona();
			this.gestionRegistro = new SEMGestionRegistro();
			this.gestionMonitoreo = new SEMGestionMonitoreo();
			this.reloj = new Reloj();
			this.temporizador = new Temporizador();
			this.subscribirseReloj(reloj);
			reloj.subscribirse(this.temporizador);
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
		public Temporizador getTemporizador() {
			return this.temporizador;
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
			return this.getMyZona().obtenerZonaDe(punto);
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
		public void subscribirseReloj(Reloj reloj) {
			reloj.subscribirListener(this);
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
		public void desuscribir(Entidad entidad) {
			this.gestionMonitoreo.deSubscribir(entidad);
			
		}
}

