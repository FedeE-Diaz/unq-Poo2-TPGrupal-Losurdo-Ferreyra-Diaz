package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.App;

public class Driving implements EstadoDesplazamiento{
	
	@Override
	public void walking(App app) {
		this.cambiarEstado(new Walking(), app);
		try {
			app.notificarALasInterfacesGraficas(app.getModo().asistenciaFinEstacionamiento());
		} catch (Exception e) {
			// TODO Verificar el cambio de throw exception a try/catch (El contrato de movement sensor no contiene throw exception, se viola el contrato al estar agregando un throw exception)
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
