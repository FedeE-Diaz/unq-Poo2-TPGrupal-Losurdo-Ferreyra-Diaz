package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class App implements MovementSensor{

	private String patente; 
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

	public App(String patente, Celular celular) {
		super();
		this.patente = patente;
		this.modo = new Manual(this); // ver en los test si esto funciona bien
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
		
		modo.iniciarEstacionamiento(patente); //despues vemos si con parametros o algo(quiza reciba ya una patente guardad para el automatico)
	}
	
	//En automatico: las alertas inician estacionamientos y finalizan automaticamente.
	//En manual: solo avisa
	
	public void driving() {
		//TODO: completar - REVISAR ASISTENCIA AL USUARIO
		modo.asistenciaFinEstacionamiento();
	}
	
	public void walking() {
		//TODO: completar - REVISAR ASISTENCIA AL USUARIO
		modo.asistenciaInicioEstacionamiento();
	}

	public Zona getZonaActual() {

		return sem.obtenerZonaDe(celular.getGPS());
	}

}
/* Asistencia al usuario: En el primer caso los usuarios reciben multas por una omisi�n involuntaria, mientras que
en el segundo caso pierden dinero por extender el registro de estacionamiento hasta el final del
d�a, tambi�n de forma involuntaria.
------------------------------------------
hacer algo que por cada hora que pase desde que se inicio el estacionamientoApp,se le vaya restando credito al usuario,
hasta que este lo detenga,se registre un movimiento de gps o lleguen las 8


Btw falta programar despues en el SEM el: Monitoreo de estacionamientos
 */


