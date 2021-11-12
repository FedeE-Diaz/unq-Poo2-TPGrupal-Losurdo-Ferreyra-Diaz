package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class App implements MovementSensor{

	private String patente; //debe guardar la patente para el modo automatico...no?
	private Modo modo; //Me parecio una buena idea hacer un State/Strategy (Verificar cual,muy probablemente un strategy) para el modo automatico/manual.
	private Celular celular;
	private SEM sem;
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public String getPatente() {
		return patente;
	}
	
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public App(Modo modo, Celular celular) {
		super();
		this.patente = null; //?
		this.modo = modo; //?
		this.celular = celular;
		this.usuario = null; //???
		// construir un nuevo usuario en el sem si no hay ya un usuario creado(y si lo hay simplemente agregarse al usuario ya existente la app)
	}
	
	public void cambiarModo() {
		modo.cambiarModo();
	}
	
	public String consultarSaldoDisponible() {
		return "Su saldo disponible es: " + this.saldoDisponible();	
	}
	private int saldoDisponible() {
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
}
/* Asistencia al usuario: En el primer caso los usuarios reciben multas por una omisi�n involuntaria, mientras que
en el segundo caso pierden dinero por extender el registro de estacionamiento hasta el final del
d�a, tambi�n de forma involuntaria.
------------------------------------------
hacer algo que por cada hora que pase desde que se inicio el estacionamientoApp,se le vaya restando credito al usuario,
hasta que este lo detenga,se registre un movimiento de gps o lleguen las 8


Btw falta programar despues en el SEM el: Monitoreo de estacionamientos
 */

