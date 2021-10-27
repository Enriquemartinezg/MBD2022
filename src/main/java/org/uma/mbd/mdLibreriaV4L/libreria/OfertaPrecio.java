package org.uma.mbd.mdLibreriaV4L.libreria;

public class OfertaPrecio implements OfertaFlex {
    private double umbral;
    private double porDescuento;

    public OfertaPrecio(double pd, double umbral){
        this.umbral = umbral;
        porDescuento = pd;
    }

    @Override
    public double getDescuento(Libro libro){
        double descuento = 0;
        if (libro.getPrecioFinal() >= umbral)
            descuento = porDescuento;

        return descuento;
    }

    @Override
    public String toString(){
        return porDescuento+"%("+umbral+")";
    }
}
