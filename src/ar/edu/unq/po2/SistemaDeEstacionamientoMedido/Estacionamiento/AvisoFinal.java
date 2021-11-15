package ar.edu.unq.po2.SistemaDeEstacionamientoMedido.Estacionamiento;

public class AvisoFinal implements AvisoGenerico {
	 private EstacionamientoVigente estacionamiento;
	 
	 public AvisoFinal(EstacionamientoVigente estacionamiento) {
		 this.estacionamiento = estacionamiento;
	 }
	 
	 public AvisoFinal aviso() {
		 return this;
	 }
}