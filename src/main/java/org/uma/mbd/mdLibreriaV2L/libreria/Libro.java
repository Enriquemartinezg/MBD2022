package org.uma.mbd.mdLibreriaV2L.libreria;

public class Libro {
    private String autor;
    private String titulo;
    private double precioBase;
    private static double IVA = 10;

    public Libro(String autor, String titulo, double precioBase){ //argumentos
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal(){
        return precioBase + precioBase* Libro.IVA/100;
    }

    @Override
    public String toString(){
        return "(" +autor+";"+titulo+";"+precioBase+";"+ Libro.IVA+"%;"+getPrecioFinal()+")";
    }

    public static double getIVA(){
        return Libro.IVA;
    }

    public static void setIVA(double IVA){
        Libro.IVA = IVA;
    }

}
