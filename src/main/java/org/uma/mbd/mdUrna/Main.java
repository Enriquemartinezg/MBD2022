package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urnas.Urna;

public class Main {
    public static void main(String[] args) {
        try {
            int nn = Integer.parseInt(args[0]); // java Main nn nb
            int nb = Integer.parseInt(args[1]);
            Urna urna = new Urna(nn, nb);
            Urna.ColorBola b1 = null;
            Urna.ColorBola b2 = null;
            Urna.ColorBola b3 = null;
            while (urna.totalBolas() > 0) {
                if (urna.totalBolas() > 1) {
                    b1 = urna.extraerBola();
                    b2 = urna.extraerBola();
                    if (b1 == b2) {
                        urna.ponerBlanca();
                    } else {
                        urna.ponerNegra();
                    }
                    System.out.println("Bola 1: " + b1 + ", Bola 2: " + b2);
                } else {
                    b3 = urna.extraerBola();
                    System.out.println(b3);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("los argumentos deben ser enteros");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("debes dar dos argumentos");
        } catch (IllegalArgumentException e) {
            System.err.println("los argumentos no pueden ser negativos");
        }
        System.out.println("Hemos terminado");
    }
}
