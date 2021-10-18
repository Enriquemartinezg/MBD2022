package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibroEnOferta extends Libro {
    private double porDescuento;
    public LibroEnOferta(String autor, String titulo, double pb, double pd) {
        super(autor, titulo, pb);
        porDescuento = pd;
    }

    public double getDescuento() {
        return porDescuento;
    }

    @Override
    public double getPrecioFinal() {
        return super.getPrecioFinal() * (1 - porDescuento/100);
    }

    @Override
    public String toString() {
        return "(" + getAutor() +"; " + getTitulo() +"; " +
                super.getPrecioFinal() +";" + Libro.getIVA() + "%; " +
                getPrecioBase() + "; " + porDescuento +"%; " + getPrecioFinal()+")";
    }
}
