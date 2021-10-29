package org.uma.mbd.mdAlturas.alturas;

public class MayoresQue implements Seleccion{
    private double alturaMin;

    public MayoresQue(double alt){
        alturaMin = alt;
    }

    @Override
    public boolean test(Pais pais){
        return pais.altura() >= alturaMin;
    }
}
