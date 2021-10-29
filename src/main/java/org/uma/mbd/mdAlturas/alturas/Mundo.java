package org.uma.mbd.mdAlturas.alturas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Mundo {
    private List<Pais> paises;

    public Mundo(){
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws IOException{
        for(String linea : Files.readAllLines(Paths.get(file))){
            stringAPais(linea);
        }
    }

    public void stringAPais(String linea){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[,]");
            sc.useLocale(Locale.ENGLISH);
            String nomPais = sc.next();
            String nomContinente = sc.next();
            double altura = sc.nextDouble();
            Pais p = new Pais(nomPais, nomContinente, altura);
            paises.add(p);
        } catch (InputMismatchException e) {
            System.err.println("ERROR: Valor numérico erróneo: " + linea);
        } catch (NoSuchElementException e) {
            System.err.println("ERROR: Faltan datos: " + linea);
        }
    }

    public List<Pais> selecciona (Seleccion sel){
        List<Pais> cumplenSelec = new ArrayList<>();

        for(Pais p : paises){
            if(sel.test(p))
                cumplenSelec.add(p);
        }
        return cumplenSelec;
    }
}
