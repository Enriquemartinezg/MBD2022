package org.uma.mbd.mdAlturasV2.alturas;

import java.util.Comparator;

public class ComparadorPorAltura  implements Comparator<Pais> {

    @Override
    public int compare(Pais o1, Pais o2) {
        return Double.compare(o1.altura() , o2.altura());
    }
}
