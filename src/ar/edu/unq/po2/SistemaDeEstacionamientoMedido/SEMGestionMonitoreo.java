package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

import java.util.ArrayList;

public class SEMGestionMonitoreo {

		private ArrayList<AvisoGenerico> subscriptores;
		
		public ArrayList<AvisoGenerico> getSubscriptores() {
			return subscriptores;
		}
		public void subscribirse(AvisoGenerico avisado) {
			this.getSubscriptores().add(avisado);
		}
		public void deSubscribirse(AvisoGenerico avisado) {
			this.getSubscriptores().remove(avisado);
		}
}
