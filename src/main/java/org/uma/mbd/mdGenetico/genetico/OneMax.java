package org.uma.mbd.mdGenetico.genetico;

public class OneMax implements Problema {

	/**
	 * El fitness de un individuo es el número de unos que tiene el cromosoma.
	 * @see Problema#evalua(Cromosoma)
	 */
	public double evalua(Cromosoma cromosoma) {
		double cont = 0;
		for(int i=0; i< cromosoma.longitud(); i++){
			if(cromosoma.gen(i) == 1)
				cont++;
		}
		return cont;
	}
}
