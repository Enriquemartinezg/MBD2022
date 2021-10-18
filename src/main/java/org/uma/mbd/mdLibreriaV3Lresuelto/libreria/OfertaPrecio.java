package org.uma.mbd.mdLibreriaV3L.libreria;

public class OfertaPrecio implements OfertaFlex {
    private double porDescuento;
    private double umbralPrecioBase;

    public OfertaPrecio(double pd, double upb) {
        porDescuento = pd;
        umbralPrecioBase = upb;
    }

    public double getDescuento(Libro libro) {
        double des  = 0;
        if (libro.getPrecioBase() >= umbralPrecioBase) {
            des = porDescuento;
        }
        return des;
    }

    @Override
    public String toString() {
        return porDescuento+"%(" + umbralPrecioBase + ")";
    }
}
