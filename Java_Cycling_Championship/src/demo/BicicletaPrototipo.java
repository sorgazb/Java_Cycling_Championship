package demo;

import demo.enums.PesoBicicleta;

public class BicicletaPrototipo extends Bicicleta{

	public BicicletaPrototipo(String nombreBicicleta, PesoBicicleta peso) {
		super(nombreBicicleta, peso);
	}
	
	@Override
	public double obtenerVelocidadCiclista(Ciclista c, Etapa e) {
		return super.obtenerVelocidadCiclista(c, e);
	}
	
	@Override
	public double tiempoFinalizarEtapa(Ciclista c, Etapa e) {
		double tiempoNecesario=0;
		tiempoNecesario=(e.getDistancia().getDistancia()/obtenerVelocidadCiclista(c, e)*c.obtenerDestreza());
		return tiempoNecesario;
	}
	
	
}
