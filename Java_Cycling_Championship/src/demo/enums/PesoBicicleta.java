package demo.enums;

public enum PesoBicicleta {
	LIGERA(7.35), NORMAL(7.50), PESADA(7.85);
	
	private final double peso;
	
	private PesoBicicleta(double peso) {
		this.peso=peso;
	}
	
	public double getPeso() {
		return peso;
	}
}
