package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionUsuario {

	private ArrayList<Usuario> listaDeUsuarios;

	private ArrayList<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public SEMGestionUsuario() {
		super();
		this.listaDeUsuarios = new ArrayList<Usuario>();
	}

	public void cargarCredito(int numTelefono, int credito) {
		if(!this.esUsuarioExistente(numTelefono)) {
			this.crearUsuario(numTelefono,credito,null);
		}
		else {
			this.getUsuarioDe(numTelefono).sumarCredito(credito);
		}
	}
	
	public Usuario getUsuarioDe(int numTelefono) {
		// El mensaje solo debe ser invocado despu�s de verificar la existencia del usuario (en este caso mediante esUsuarioExistente)
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
			this.crearUsuario(numTel, numTel, app);
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
	private void removerUsuario(Usuario usuario) {
		this.getListaDeUsuarios().remove(usuario);
	}
}
