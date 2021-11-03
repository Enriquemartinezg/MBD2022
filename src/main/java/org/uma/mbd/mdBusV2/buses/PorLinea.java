package org.uma.mbd.mdBusV2.buses;

public class PorLinea implements Criterio {
    private int codLinea;

    public PorLinea(int cL){
        codLinea = cL;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.getCodLinea() == codLinea;
    }

    @Override
    public String toString() {
        return "Autobuses de la línea "+ codLinea;
    }
}
