package demo.comparadores;

import java.util.Comparator;

import demo.Ciclista;

public class ComparatorCiclistaHabilidad implements Comparator<Ciclista>{
	@Override
	public int compare(Ciclista c1, Ciclista c2) {
		int comparacion= Double.compare(c1.getHabilidad(), c2.getHabilidad());
		if(comparacion==0) {
			return c1.getNombreCiclista().compareTo(c2.getNombreCiclista());
		}
		return comparacion;
	}
}
