package org.uma.mbd.mdBusV1.buses;

public class Coincide implements Criterio{
    private Bus bus;

    public Coincide(Bus bus){
        this.bus = bus;
    }

    @Override
    public boolean esSeleccionable(Bus b) {
        return b.equals(bus);
    }

    @Override
    public String toString() {
        return "Autobús "+ bus.toString();
    }
}
