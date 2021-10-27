package org.uma.mbd.mdLibreriaV4L.libreria;

import java.util.Objects;

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

    public static double getIVA(){
        return Libro.IVA;
    }

    public static void setIVA(double IVA){
        Libro.IVA = IVA;
    }

    @Override
    public String toString(){
        return "(" +autor+";"+titulo+";"+precioBase+";"+ Libro.IVA+"%;"+getPrecioFinal()+")";
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof Libro libro && autor.equalsIgnoreCase(libro.autor) &&
                titulo.equalsIgnoreCase(libro.titulo);
    }// tanto Object como Libro son referencias del mismo objeto pero con cada una puedes ver los métodos

    @Override
    public int hashCode(){
        return Objects.hash(autor.toUpperCase(), titulo.toLowerCase());
    }
}
