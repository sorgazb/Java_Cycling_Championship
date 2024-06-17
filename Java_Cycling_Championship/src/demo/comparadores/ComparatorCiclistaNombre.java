package demo.comparadores;

import java.util.Comparator;

import demo.Ciclista;

public class ComparatorCiclistaNombre implements Comparator<Ciclista>{
	@Override
	public int compare(Ciclista o1, Ciclista o2) {
		return o1.getNombreCiclista().compareTo(o2.getNombreCiclista());
	}

}
