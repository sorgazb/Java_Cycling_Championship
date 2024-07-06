package demo;

import demo.enums.HabilidadCiclista;

public class CiclistaNovato extends Ciclista{

	//
	public CiclistaNovato(String nombreCiclista, HabilidadCiclista habilidad, double energia, Equipo equipo) {
		super(nombreCiclista, habilidad, energia, equipo);
	}
	
	//
	@Override
	public double obtenerDestreza() {
		double destreza=((getHabilidad().getHabilidad()+2)/120)*10;
		return destreza;
	}

}
