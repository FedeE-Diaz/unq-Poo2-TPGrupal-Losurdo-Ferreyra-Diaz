package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionUsuario {

	private ArrayList<Usuario> listaDeUsuarios;

	public SEMGestionUsuario() {
		super();
		this.listaDeUsuarios = new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public void cargarCredito(int numTelefono, int credito) {
		if(!this.esUsuarioExistente(numTelefono)) {
			Usuario usuario = this.crearUsuario(numTelefono,credito,null); 
			//quiza en vez de pasarle un null,pasarle una app random?
			this.agregarUsuario(usuario);
		}
		else {
			this.sumarCreditoA(numTelefono,credito);
		}
	}
	
	public void sumarCreditoA(int numTelefono, int credito) {
		this.getUsuarioDe(numTelefono).sumarCredito(credito);
	}
	public Usuario getUsuarioDe(int numTelefono) {
		// El mensaje solo debe ser invocado después de verificar la existencia del usuario (en este caso mediante esUsuarioExistente)
	    for (Usuario usuario : this.getListaDeUsuarios()) {
	        if (usuario.esMismoNumero(numTelefono)) {
	            return usuario;
	        }
	    }
	    return null;
	}

	public void crearUsuarioDesdeApp(App app, int numTel) {
		if(this.esUsuarioExistente(numTel)) {
			this.getUsuarioDe(numTel).setApp(app);
		}
		else {
			Usuario usuario = this.crearUsuario(numTel, 0, app);
			this.agregarUsuario(usuario);
		}
	}
	private boolean esUsuarioExistente(int numTel){
		return this.getListaDeUsuarios().stream().anyMatch(p -> p.esMismoNumero(numTel));
	}

	private Usuario crearUsuario(int numTelefono, int credito, App app) {
		return new Usuario(numTelefono, credito, app);
	}
	
	private void agregarUsuario(Usuario usuario) {
		this.getListaDeUsuarios().add(usuario);
	}

	public void descontarCredito(int precio, int numTelefono) {
		this.getUsuarioDe(numTelefono).restarCredito(precio);
		
	}
	
}
