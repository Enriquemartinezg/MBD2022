package org.uma.mbd.mdLibreriaV3L.libreria;

public class Libro {
    private String  autor;
    private String titulo;
    private double precioBase;
    private static double IVA = 10;

    public Libro(String au, String tit, double pb) {
        autor = au;
        titulo = tit;
        precioBase = pb;
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

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double IVA) {
        Libro.IVA = IVA;
    }

    public double getPrecioFinal() {
        return precioBase * (1 + IVA/100);
    }

    @Override
    public String toString() {
        return "("+ autor +";" + titulo + ";" + precioBase + ";" + IVA +"%;"
                + getPrecioFinal()+")";
    }
}
