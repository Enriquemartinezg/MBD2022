package org.uma.mbd.mdCoches.coches;

public class Coche {
    private String nombre;
    protected double precio;
    static private double IVA = 0.16;
    public Coche(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public static void setPiva(double nIVA){
        IVA = nIVA;
    }

    public double precioTotal(){
        double precioT;
        precioT = precio + precio*IVA;
        return precioT;
    }

    @Override
    public String toString(){
        return "<"+nombre+" -> <"+precioTotal()+">";
    }
}
