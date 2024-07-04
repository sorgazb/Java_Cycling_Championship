package demo.enums;

public enum DistanciaEtapa {
	CORTA(150), INTERMEDIA(200), LARGA(225);
	
	private final double distancia;
	
	private DistanciaEtapa(double distancia) {
		this.distancia=distancia;
	}
	
	public double getDistancia() {
		return distancia;
	}
}
