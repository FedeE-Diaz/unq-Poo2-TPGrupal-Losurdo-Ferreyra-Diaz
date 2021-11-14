package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class App implements MovementSensor{

	private String patente; 
	
	/* Por lo que entiendo, solo habrá un estacionamiento app a la vez, en caso de que hubiera mas de uno,
	 *  habria que modificar ciertos metodos para contemplar esos casos, pero bueno, no se pidio evaluar esa situacion,
	 *  por lo cual como dijeron en las clases, hay que evitar programar cosas de más y resolver problemas sobre situaciones 
	 *  que no nos pidieron (que si se lo resolvemos gratis luego no nos contratan de nuevo 
	 *  para resolver ese problema jeje) - Braian */
	
	private Modo modo; //Me parecio una buena idea aplicar un State para el modo automatico/manual.
	private Celular celular;
	private SEM sem;
	
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
	public int getNumeroTelefono() {
		return celular.getNumero();
	}

	public App(SEM sem,String patente, Celular celular) {
		super();
		
		this.sem = sem;
		this.patente = patente;
		this.modo = new Manual(this); // TODO: ver en los test si esto funciona bien
		this.celular = celular;
		sem.crearUsuarioDesdeApp(this,this.getNumeroTelefono());
	}
	
	public void cambiarModo() {
		modo.cambiarModo();
	}
	


	public String consultarSaldoDisponible() {
		return "Su saldo disponible es: " + this.saldoDisponible();	
	}
	public int saldoDisponible() {
		return this.getUsuario().getCredito();
	}
	
	public void iniciarEstacionamiento(String patente) {
		
		modo.iniciarEstacionamiento(patente);
	}
	public void finalizarEstacionamiento(String patente) {
		
		modo.finalizarEstacionamiento(patente);
	}
	
	
	//En automatico: las alertas inician estacionamientos y finalizan automaticamente.
	//En manual: solo avisa
	
	public void driving() {
		
		modo.asistenciaFinEstacionamiento();
	}
	
	public void walking() {
		
		modo.asistenciaInicioEstacionamiento();
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

	public boolean estoyEnElMismoPuntoQueElEstacionamiento() {

		return this.obtenerUbicacionActual() == sem.getEstacionamientoDe(this.getPatente()).getUbicacion();
	}

	public boolean estoyEnUnaZonaDeEstacionamientoMedido() {

		return sem.obtenerZonaDe(this.obtenerUbicacionActual()) != null;
	}



}
/* Asistencia al usuario: En el primer caso los usuarios reciben multas por una omisión involuntaria, mientras que
en el segundo caso pierden dinero por extender el registro de estacionamiento hasta el final del
día, también de forma involuntaria.
------------------------------------------
hacer algo que por cada hora que pase desde que se inicio el estacionamientoApp,se le vaya restando credito al usuario,
hasta que este lo detenga,se registre un movimiento de gps o lleguen las 8


Btw falta programar despues en el SEM el: Monitoreo de estacionamientos
 */


