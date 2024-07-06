package demo;

import demo.enums.HabilidadCiclista;

public class CiclistaEstrella extends Ciclista {

	private int popularidad;

	public CiclistaEstrella(String nombreCiclista, HabilidadCiclista habilidad, double energia, Equipo equipo) {
		super(nombreCiclista, habilidad, energia, equipo);
		this.popularidad = 6;
	}

	@Override
	public double obtenerDestreza() {
		double destreza = ((getHabilidad().getHabilidad() + 6) / 140) * 10;
		return destreza;
	}

	@Override
	public void usarBicicletaEtapa(Bicicleta b, Etapa e) {
		super.usarBicicletaEtapa(b, e);
		if(obtenerResultadoEtapaTiempo(e)<160) {
			if (haAbandonado() == false) {
				popularidad=popularidad+4;
			}
		}else {
			popularidad=popularidad-1;
		}
	}

}
