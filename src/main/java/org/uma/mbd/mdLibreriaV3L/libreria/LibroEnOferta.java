package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibroEnOferta extends Libro {
    private double descuento;

    public LibroEnOferta(String autor, String titulo, double precio, double descuento){
        super(autor, titulo, precio);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioFinal(){
        double PFD = super.getPrecioFinal() - super.getPrecioFinal() * descuento/100;
        return PFD;
    }

    @Override
    public String toString(){
        return "(" +getAutor()+";"+getTitulo()+";"+super.getPrecioFinal()+";"+ getIVA()+"%;"+getPrecioBase()+";"+
                descuento+";"+getPrecioFinal()+")";
    }
}
