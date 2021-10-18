package org.uma.mbd.mdLibreriaV3L.libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
    private double porDescuento;
    private String [] autoresEnOferta;

    public OfertaAutor(double pd, String [] aeo) {
        porDescuento = pd;
        autoresEnOferta = aeo;
    }

    public double getDescuento(Libro libro) {
        double des = 0;
        if (esAutorEnOferta(libro.getAutor())) {
            des = porDescuento;
        }
        return des;
    }

    @Override
    public String toString() {
        return porDescuento+"%"+ Arrays.toString(autoresEnOferta);
    }

    private boolean esAutorEnOferta(String autor) {
        int pos = 0;
        while (pos < autoresEnOferta.length && !autoresEnOferta[pos].equalsIgnoreCase(autor)) {
            pos++;
        }
        return pos < autoresEnOferta.length;
    }

}
