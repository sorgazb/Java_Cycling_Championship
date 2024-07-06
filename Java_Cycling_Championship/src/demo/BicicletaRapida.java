package demo;

import demo.enums.PesoBicicleta;

public class BicicletaRapida extends Bicicleta {

	//
	private double velocidadExtra;

	//
	public BicicletaRapida(String nombreBicicleta, PesoBicicleta peso, double velocidadExtra) {
		super(nombreBicicleta, peso);
		this.velocidadExtra = velocidadExtra;
	}

	//
	public double getVelocidadExtra() {
		return velocidadExtra;
	}

	public void setVelocidadExtra(double velocidadExtra) {
		this.velocidadExtra = velocidadExtra;
	}

	//

	//
	@Override
	public double obtenerVelocidadCiclista(Ciclista c, Etapa e) {
		return super.obtenerVelocidadCiclista(c, e) + velocidadExtra;
	}

	//
	@Override
	public double tiempoFinalizarEtapa(Ciclista c, Etapa e) {
		double tiempoNecesario=0;
		tiempoNecesario=(e.getDistancia().getDistancia()/obtenerVelocidadCiclista(c, e))*60;
		return tiempoNecesario;
	}

}
