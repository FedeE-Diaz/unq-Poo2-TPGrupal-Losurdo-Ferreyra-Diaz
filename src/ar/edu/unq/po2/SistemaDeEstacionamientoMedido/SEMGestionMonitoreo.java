package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionMonitoreo {

		private ArrayList<Entidad> subscriptores;
		
		public SEMGestionMonitoreo() {
			this.subscriptores = new ArrayList<Entidad>();
		}
		public ArrayList<Entidad> getSubscriptores() {
			return subscriptores;
		}
		public void subscribirse(Entidad entidad) {
			this.getSubscriptores().add(entidad);
		}
		public void deSubscribir(Entidad entidad) {
			this.getSubscriptores().remove(entidad);
		}
		
		public void notificarSubscriptores(AvisoGenerico aviso) {
			for(Entidad subscriptor : this.subscriptores) {
				subscriptor.recibir(aviso);
			}
		}
}
