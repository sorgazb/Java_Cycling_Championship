package demo;

import demo.enums.HabilidadCiclista;

public class CiclistaExperimentado extends Ciclista{

	//
	public CiclistaExperimentado(String nombreCiclista, HabilidadCiclista habilidad, double energia, Equipo equipo) {
		super(nombreCiclista, habilidad, energia, equipo);
		// TODO Auto-generated constructor stub
	}
	
	//
	@Override
	public double obtenerDestreza() {
		double destreza=((getHabilidad().getHabilidad()+4)/130)*10;
		return destreza;
	}
}
