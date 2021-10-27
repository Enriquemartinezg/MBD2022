package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.Random;

public class MasterMind {
    public final int TAMANO_POR_DEFECTO = 4;
    private static Random alea = new Random();
    protected String combinacionSecreta;

    public MasterMind(String codigo){
        combinacionSecreta = codigo;
    }

    public MasterMind(){
        generaCombinacionSecreta(TAMANO_POR_DEFECTO);
    }

    public MasterMind(int nCifras){
        if(nCifras>10 || nCifras<0)
            throw new MasterMindException("Número de cifras fuera de rango.");

        generaCombinacionSecreta(nCifras);
    }

    private void generaCombinacionSecreta(int nCifras){
        if(nCifras>10 || nCifras<0)
            throw new MasterMindException("Número de cifras fuera de rango.");

        String codigo ="";
        String num = Integer.toString(alea.nextInt(nCifras));
        codigo = codigo + num;

       while(codigo.length() < nCifras){
            num = Integer.toString(alea.nextInt(nCifras));
            if (codigo.indexOf(num) < 0){
                codigo = codigo + (num);
            }
        }
        combinacionSecreta = codigo;
    }

    /* OTRA OPCION?
    private void generaCombinacionSecreta(int nCifras){
        StringBuilder codigo = new StringBuilder(nCifras);
        char num = Character.forDigit(alea.nextInt(10), 10);
        codigo.insert(0,num);
        for(int i=1; i<nCifras; i++){
            codigo.insert(i, num);
            for(int j=0; j<i; j++) {
                while(codigo.charAt(i) == codigo.charAt(j)){
                    codigo.insert(i,num);
                }
            }
        }
        combinacionSecreta = codigo.toString();
    }
     */

    public int getLongitud(){
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifras){
        int comparar;
        int seRepite = 0;
        //Comprobamos si son numeros
        boolean sonCifras = cifras.matches("[0-9]{"+cifras.length()+"}");
        for(int i=0; i<cifras.length(); i++){
            //Obtengo el Int del String en la pos i
            comparar = Integer.valueOf(String.valueOf(cifras.charAt(i)));
            //recorro todos los Int posteriores al i
            for(int j =i+1; j<cifras.length(); j++){
                //comparo i con i+1 hasta el final y si son iguales aumento un contador
                if(Integer.valueOf(String.valueOf(cifras.charAt(j)))==comparar)
                    seRepite++;
            }
        }
        //si el contador es distinto de 0 o las longitudes no son iguales me devuelve false
        return (cifras.length()==combinacionSecreta.length() && seRepite == 0 && sonCifras);
    }

    public Movimiento intento(String cifras){
        int colocadas = 0;
        int descolocadas = 0;
        if(!validaCombinacion(cifras))
            throw new MasterMindException("La combinación no cumple los criterios.");

        for(int i=0; i<cifras.length(); i++){
            if(cifras.charAt(i)==combinacionSecreta.charAt(i))
                colocadas++;

            for(int j=0; j<cifras.length(); j++){
                if((cifras.charAt(i)==combinacionSecreta.charAt(j)) && j!=i)
                    descolocadas++;
            }
        }
        Movimiento m = new Movimiento(cifras, colocadas, descolocadas);
        return m;
    }

    public String getSecreto(){
        return combinacionSecreta;
    }


}
