package org.uma.mbd.mdUrna.urnas;

import java.awt.*;
import java.util.Random;

public class Urna {
    private static Random alea = new Random();
    private int negras;
    private int blancas;

    public Urna(int nNegras, int nBlancas){
        if(nNegras < 0 || nBlancas < 0)
            throw new IllegalArgumentException("Se ha introducido un numero de bolas negativo");

        this.negras = nNegras;
        this.blancas = nBlancas;
    }

    public int totalBolas(){
        return negras + blancas;
    }

    public void ponerBlanca(){
        blancas++;
    }

    public void ponerNegra(){
        negras++;
    }

    static public enum ColorBola{Blanca, Negra};

   /* public ColorBola extraerBola() {
        ColorBola sacaBola = null;
        int n = alea.nextInt(totalBolas());

        while (totalBolas() > 0) {
            if (n <= blancas) {
                sacaBola = ColorBola.Blanca;
                blancas--;
            } else {
                sacaBola = ColorBola.Negra;
                negras--;
            }
        }
    }*/
}
