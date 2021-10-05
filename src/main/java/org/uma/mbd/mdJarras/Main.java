package org.uma.mbd.mdJarras;
import org.uma.mbd.mdJarras.jarras.Jarra;

public class Main {
    public static void main(String[] args) {
        Jarra j1 = new Jarra(7);
        Jarra j2 = new Jarra(5);
        j2.llena(); //j1: 0 litros j2: 5 litros
        j1.llenaDesde(j2); //j1: 5 litros j2: 0 litros
        j2.llena(); //j1: 5 litros j2: 5 litros
        j1.llenaDesde(j2); //j1: 7 litros j2: 3 litros
        j1.vacia(); //j1: 0 litros j2: 3 litros
        j1.llenaDesde(j2); //j1: 3 litros j2: 0 litros
        j2.llena(); //j1: 3 litros j2: 5 litros
        j1.llenaDesde(j2); //j1: 7 litros j2: 1 litros

        System.out.println(j1.getContenido());
        System.out.println(j2.getContenido());
        System.out.println(j1);
        System.out.println(j2);
    }
}
