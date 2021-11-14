package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public class AvisoInicio implements AvisoGenerico {
	 private EstacionamientoVigente estacionamiento;
	 
	 public AvisoInicio(EstacionamientoVigente estacionamiento) {
		 this.estacionamiento = estacionamiento;
	 }
	 
	 public AvisoInicio aviso() {
		 return this;
	 }
}
