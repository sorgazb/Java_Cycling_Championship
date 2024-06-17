package demo.comparadores;

import java.util.Comparator;

import demo.Ciclista;

public class ComparatorCiclistaEnergia implements Comparator<Ciclista>{
	
	@Override
	public int compare(Ciclista c1, Ciclista c2) {
		return Double.compare(c1.getEnergia(), c2.getEnergia());
	}

}
