package demo.enums;

public enum DificultadEtapa {
	SENCILLA(0.9), NORMAL(1.0), COMPLEJA(1.1);
	
	private final double dificultad;
	
	private DificultadEtapa(double dificultad) {
		this.dificultad=dificultad;
	}
	
	public double getDificultad() {
		return dificultad;
	}
}
