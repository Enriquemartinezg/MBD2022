package org.uma.mbd.mdBusV2.buses;

@FunctionalInterface
public interface Criterio {
    boolean esSeleccionable(Bus bus);
}
