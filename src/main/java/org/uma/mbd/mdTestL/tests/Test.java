package org.uma.mbd.mdTestL.tests;

public record Test(String nombre, int aciertos, int errores) {
    @Override
    public boolean equals(Object obj){
        return obj instanceof Test t && nombre.equalsIgnoreCase(t.nombre);
    }

    @Override
    public int hashCode(){
        return nombre.toLowerCase().hashCode();
    }

    public double calificacion(double vAC, double vEr){
        return vAC*aciertos + vEr*errores;
    }
}
