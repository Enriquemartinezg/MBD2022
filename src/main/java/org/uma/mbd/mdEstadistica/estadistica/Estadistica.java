package org.uma.mbd.mdEstadistica.estadistica;

public class Estadistica {
    private int numElementos;
    private double sumaX, sumaX2;

    public void agrega(double d){
        this.agrega(d,1);
        //agrega(d,1) igual de válido
    }

    public void agrega(double d, int n){
        numElementos += n;
        sumaX += n*d;
        sumaX2 += Math.pow(d,2) * n;
    }

    public double media() {
        if (numElementos == 0)
            throw new RuntimeException("No hay elementos");
        return sumaX / numElementos;
    }
    public double varianza(){
        if (numElementos == 0)
            throw new RuntimeException("No hay elementos");
        return (sumaX2 / numElementos - Math.pow(media(), 2));
    }

    public double desviacionTipica(){
        return Math.sqrt(varianza());
    }
}

