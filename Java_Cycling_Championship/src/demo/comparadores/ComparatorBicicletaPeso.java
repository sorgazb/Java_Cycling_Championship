package demo.comparadores;

import java.util.Comparator;

import demo.Bicicleta;

public class ComparatorBicicletaPeso implements Comparator<Bicicleta>{
	
	@Override
	public int compare(Bicicleta b1, Bicicleta b2) {
		return Double.compare(b1.getPeso(), b2.getPeso());
	}

}
