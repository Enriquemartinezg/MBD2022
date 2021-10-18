package org.uma.mbd.mdLibreriaV2L.libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
    private double descuento;
    private String [] oferta;

    public LibreriaOferta(double descuento, String [] oferta){
        //super(); //se puede quitar
        setOferta(descuento, oferta);
    }

    public void setOferta(double nDescuento, String[] nOferta) {
        this.descuento = nDescuento;
        this.oferta = nOferta;
    }

    public String[] getOferta(){
        return oferta;
    }

    public double getDescuento(){
        return descuento;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro;
        if(autorEnOferta(autor))
            libro = new LibroEnOferta(autor, titulo, precioBase, descuento);
        else
            libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    private boolean autorEnOferta(String autor){
        int pos = 0;
        while (pos < oferta.length && !oferta[pos].equalsIgnoreCase(autor))
            pos++;
        return pos < oferta.length;
    }

    @Override
    public String toString() {
        return descuento+"%" + Arrays.toString(oferta) + super.toString();
    }

}
