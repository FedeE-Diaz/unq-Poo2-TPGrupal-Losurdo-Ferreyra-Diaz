package ar.edu.unq.po2.SistemaDeEstacionamientoMedido;

public interface MonitoreoListener {
	public void suscribirseEn(SEM sem);
	public void deSuscribirseEn(SEM sem);
	public void recibir(AvisoGenerico Aviso);
}
