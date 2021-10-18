package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibreriaOfertaFlexible extends Libreria {
    private OfertaFlex ofertaFlexible;

    public LibreriaOfertaFlexible(OfertaFlex of) {
        ofertaFlexible = of;
    }

    @Override
    public void addLibro(String autor, String titulo, double pb) {
        Libro libro = new Libro(autor, titulo, pb);
        double des = ofertaFlexible.getDescuento(libro);
        if (des > 0) {
            libro = new LibroEnOferta(autor, titulo, pb, des);
        }
        addLibro(libro);
    }

    @Override
    public String toString() {
        return ofertaFlexible.toString() + super.toString();
    }
}
