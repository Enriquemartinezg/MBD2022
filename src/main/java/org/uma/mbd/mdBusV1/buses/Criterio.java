package org.uma.mbd.mdBusV1.buses;
@FunctionalInterface
public interface Criterio {
    boolean esSeleccionable(Bus bus);
}
