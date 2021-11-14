package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionMonitoreo {

		private ArrayList<Entidad> subscriptores;
		
		public ArrayList<Entidad> getSubscriptores() {
			return subscriptores;
		}
		public void subscribirse(Entidad entidad) {
			this.getSubscriptores().add(entidad);
		}
		public void deSubscribirse(Entidad entidad) {
			this.getSubscriptores().remove(entidad);
		}
		
		public void notificarSubscriptores() {
			for(Entidad subscriptor : this.subscriptores) {
				subscriptor.notificar(new AvisoGenerico())
			}
		}
}
