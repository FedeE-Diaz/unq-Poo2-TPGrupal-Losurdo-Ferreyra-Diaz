package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

public class Walking implements EstadoDesplazamiento{
	
	@Override
	public void walking(App app) {
		
	}
	@Override
	public void driving(App app) {
		this.cambiarEstado(new Driving(), app);
		try {
			app.notificarALasInterfacesGraficas(app.getModo().asistenciaFinEstacionamiento());
		} catch (Exception e) {
			// TODO Auto-generated catch block -> que lo vea fede (No se puede editar el contrato de movement sensor agregando un throw exception)
			e.printStackTrace();
		}
	}
	public void cambiarEstado(EstadoDesplazamiento estado, App app) {
		app.setEstado(estado);
	}
}
