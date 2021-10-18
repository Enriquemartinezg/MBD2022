package org.uma.mbd.mdCoches.coches;

public class CocheImportado extends Coche {
    private double homologacion;

    public CocheImportado(String modelo, double p, double homologacion){
        super(modelo, p);
        this.homologacion = homologacion;
    }

    @Override
    public double precioTotal(){
        double precioT;
        precioT = super.precioTotal() + homologacion;
        return precioT;
    }
}
