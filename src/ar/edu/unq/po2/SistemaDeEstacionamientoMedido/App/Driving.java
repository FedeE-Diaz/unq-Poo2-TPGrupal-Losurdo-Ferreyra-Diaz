package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

public class Driving implements EstadoDesplazamiento{
	
	@Override
	public void walking(App app) {
		app.setEstado(new Driving());
		try {
			app.notificarALasInterfacesGraficas(app.getModo().asistenciaFinEstacionamiento());
		} catch (Exception e) {
			// TODO Auto-generated catch block -> que lo vea fede (No se puede editar el contrato de movement sensor agregando un throw exception)
			e.printStackTrace();
		}
	}
	@Override
	public void driving(App app) {

	}
	public void cambiarEstado(EstadoDesplazamiento estado, App app) {
		app.setEstado(estado);
	}
}
