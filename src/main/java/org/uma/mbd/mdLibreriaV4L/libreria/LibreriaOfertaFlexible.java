package org.uma.mbd.mdLibreriaV4L.libreria;

public class LibreriaOfertaFlexible extends Libreria {
    private OfertaFlex ofertaFlexible;

    public LibreriaOfertaFlexible(OfertaFlex oferta){
        setOferta(oferta);
    }

    public void setOferta(OfertaFlex oferta){
        ofertaFlexible = oferta;
        // Hay que cambiar todos los libros
        //for (libro: libros)
            //addLibro();
    }

    public OfertaFlex getOferta(){
        return ofertaFlexible;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro = new Libro(autor, titulo, precioBase);
        double descuento = ofertaFlexible.getDescuento(libro);
        if(descuento > 0)
            libro = new LibroEnOferta(autor, titulo, precioBase, descuento);
        addLibro(libro);
    }

    @Override
    public String toString(){
        return ofertaFlexible + super.toString();
    }
}
