package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

import java.util.ArrayList;

import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InterfacesGraficas;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Celular;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.ClasesDeRepresentacion.Punto;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.InspeccionesEstacionamientos.Zona;
import ar.edu.unq.po2.SistemaDeEstacionamientoMedido.SEM.SEM;

public class App implements MovementSensor{

	private String patente; 
	
	/* Por lo que entiendo, solo habr� un estacionamiento app a la vez, en caso de que hubiera mas de uno,
	 *  habria que modificar ciertos metodos para contemplar esos casos, pero bueno, no se pidio evaluar esa situacion,
	 *  por lo cual como dijeron en las clases, hay que evitar programar cosas de m�s y resolver problemas sobre situaciones 
	 *  que no nos pidieron (que si se lo resolvemos gratis luego no nos contratan de nuevo 
	 *  para resolver ese problema jeje) - Braian */
	
	private Modo modo; //Me parecio una buena idea aplicar un State para el modo automatico/manual.
	private Celular celular;
	private SEM sem;
	private ArrayList<InterfacesGraficas> subscriptores;
	
	public App(SEM sem,String patente, Celular celular) {
		super();
		this.sem = sem;
		this.patente = patente;
		this.modo = new Manual(this); 
		this.celular = celular;
		this.subscriptores = new ArrayList<InterfacesGraficas>();
		sem.crearUsuarioDesdeApp(this,this.getNumeroTelefono());
		this.sem.getTemporizador().simularHora(7, 0);
	}
	
	public Usuario getUsuario() { 
		return sem.getUsuario(this.getNumeroTelefono());
	}

	public String getPatente() {
		return patente;
	}
	
	public SEM getSem() {
		return sem;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public void setModo(Modo modo) {
		this.modo = modo;
	}
	
	public Modo getModo() {
		return modo;
	}

	public Celular getCelular() {
		return celular;
	}

	public int getNumeroTelefono() {
		return getCelular().getNumero();
	}
	
	public ArrayList<InterfacesGraficas> getSubscriptores() {
		return subscriptores;
	}
	
	public void cambiarModo() {
		this.getModo().cambiarModo();
	}
	
	public String consultarSaldoDisponible() {
		return "Su saldo disponible es: " + this.saldoDisponible();	
	}
	
	public int saldoDisponible() {
		return this.getUsuario().getCredito();
	}
	
	public ArrayList<String> iniciarEstacionamiento(String patente) {
		return this.getModo().iniciarEstacionamiento(patente);
	}
	
	public void finalizarEstacionamiento(String patente) throws Exception{
		this.getModo().finalizarEstacionamiento(patente);
	}
	
	//En automatico: las alertas inician estacionamientos y finalizan automaticamente.
	//En manual: solo avisa
	
	public void driving() throws Exception{
		this.notificarALasInterfacesGraficas(this.getModo().asistenciaFinEstacionamiento());
	}
	
	public void walking() {
		this.notificarALasInterfacesGraficas(this.getModo().asistenciaInicioEstacionamiento());
	}

	private void notificarALasInterfacesGraficas(ArrayList<String> textoAMostrarEnPantalla) {
		for(InterfacesGraficas ig : subscriptores) {
			ig.popUpAviso(textoAMostrarEnPantalla); 
		}
	}

	public Zona getZonaActual() {
		return sem.obtenerZonaDe(this.obtenerUbicacionActual());
	}
	
	private Punto obtenerUbicacionActual() {
		return celular.getGPS().getUbicacionActual();
	}

	public boolean hayEstacionamientoVigente() {
		return sem.esEstacionamientoVigente(this.getPatente());
	}

	public boolean estoyEnElMismoPuntoQueElEstacionamiento() throws Exception {
		//Para utilizar este metodo se debe utilizar en un short-circuit que determine previamente que dicho estacionamiento existe.
		return this.obtenerUbicacionActual().esMismoPunto(sem.getEstacionamientoDe(this.getPatente()).getUbicacion());
	}

	public boolean estoyEnUnaZonaDeEstacionamientoMedido() {
		return sem.obtenerZonaDe(this.obtenerUbicacionActual()) != null;
	}
	
	public void agregarSubscriptor(InterfacesGraficas sub) {
		this.getSubscriptores().add(sub);
	}

	public Punto getPuntoActual() {
		return this.celular.getPunto();
	}
}

