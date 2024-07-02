package demo.comparadores;

import java.util.Comparator;

import demo.Ciclista;

public class ComparatorResultadoEtapa implements Comparator<Ciclista>{
	@Override
	public int compare(Ciclista c1, Ciclista c2) {
		int comparacion= Double.compare(c1.obtenerResultadoEtapaTiempo(null), c2.obtenerResultadoEtapaTiempo(null));
		if(comparacion==0) {
			return c1.getNombreCiclista().compareTo(c2.getNombreCiclista());
		}
		return comparacion;
	}
}