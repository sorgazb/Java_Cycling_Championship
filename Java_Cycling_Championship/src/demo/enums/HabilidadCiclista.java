package demo.enums;

public enum HabilidadCiclista {
	LENTA(4.0), NORMAL(6.0), BUENA(8.0);
	
	private final double habilidad;
	
	private HabilidadCiclista(double habilidad) {
		this.habilidad=habilidad;
	}
	
	public double getHabilidad() {
		return habilidad;
	}
}
