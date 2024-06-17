package demo.comparadores;

import java.util.Comparator;

import demo.Ciclista;

public class ComparatorCiclistaHabilidad implements Comparator<Ciclista>{
	@Override
	public int compare(Ciclista c1, Ciclista c2) {
		return Double.compare(c1.getHabilidad(), c2.getHabilidad());
	}
}
