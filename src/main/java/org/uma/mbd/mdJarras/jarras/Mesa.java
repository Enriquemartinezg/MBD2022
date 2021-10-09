package org.uma.mbd.mdJarras.jarras;

public class Mesa {
    private Jarra jarraA;
    private Jarra jarraB;
    public Mesa(int capInicialA, int capInicialB){
        jarraA = new Jarra(capInicialA);
        jarraB = new Jarra(capInicialB);
    }

    public void llenaA(){
        jarraA.llena();
    }

    public void llenaB(){
        jarraB.llena();
    }

    public void vaciaA(){
        jarraA.vacia();
    }

    public void vaciaB(){
        jarraB.vacia();
    }

    public int getContenidoA(){
        return jarraA.getContenido();
    }

    public int getContenidoB(){
        return jarraB.getContenido();
    }

    public int getCapacidadA(){
        return jarraA.getCapacidad();
    }

    public int getCapacidadB(){
        return jarraB.getCapacidad();
    }

    public int getContenido(){
        return jarraA.getContenido() + jarraB.getContenido();
    }

    @Override
    public String toString(){
        return "La mesa tiene la Jarra A con: " + jarraA.getContenido() + "/" + jarraA.getCapacidad() + " litros y la " +
                "Jarra B con: " + jarraB.getContenido() + "/" + jarraB.getCapacidad() + " litros.";
    }
}


