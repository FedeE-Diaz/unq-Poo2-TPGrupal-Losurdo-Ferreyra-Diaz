package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

public interface EstadoDesplazamiento {

	public void walking(App app);
	public void driving(App app);
	public void cambiarEstado(EstadoDesplazamiento estado, App app);
		
	
}
