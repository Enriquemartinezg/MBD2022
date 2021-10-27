package org.uma.mbd.mdLibreriaV4L.libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
    private double porDescuento;
    private String [] autoresEnOferta;

    public OfertaAutor(double pd, String [] ofertas){
        porDescuento = pd;
        autoresEnOferta = ofertas;
    }

    @Override
    public double getDescuento(Libro libro) {
        double descuento = 0;
        if(autorEnOferta(libro.getAutor()))
            descuento = porDescuento;
        return descuento;
    }

    private boolean autorEnOferta(String autor){
        int pos = 0;
        while (pos < autoresEnOferta.length && !autoresEnOferta[pos].equalsIgnoreCase(autor))
            pos++;
        return pos < autoresEnOferta.length;
    }

    @Override
    public String toString(){
        return porDescuento+"%"+ Arrays.toString(autoresEnOferta);
    }
}
