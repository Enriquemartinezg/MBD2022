package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Club {
    protected List<Persona> socios;

    public Club(){
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws IOException {
        for(String linea : Files.readAllLines(Paths.get(fEntrada))){
            leeSocios(linea,delim);
        }
    }

    public void leeSocios(String linea, String delim){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter(delim);
            while(sc.hasNext()){
                String nombre = sc.next();
                creaSocioDesdeString(nombre);
            }
        } catch (InputMismatchException e) {
            System.err.println("ERROR: Valor numérico erróneo: " + linea);
        } catch (NoSuchElementException e) {
            System.err.println("ERROR: Faltan datos: " + linea);
        }
    }

    protected void creaSocioDesdeString(String nombre){
        Persona p = new Persona(nombre);
        socios.add(p);
    }

    protected void hacerAmigos(){
        List<Integer> posAmigos = new ArrayList<>();
        for(int i=0; i<socios.size(); i++){
            posAmigos.add(i);
        }
        while(hayCoincidendia(posAmigos)){
            Collections.shuffle(posAmigos);
        }

        for(int i=0; i<socios.size(); i++){
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
        }
    }
/*
    private static boolean hayCoincidendia(List<Integer> lista){
        int i = 0;
        while ( i<lista.size() && i!=lista.get(i)){
            i++;
        }
        return i<lista.size();
    }

 */
    private static boolean hayCoincidendia(List<Integer> lista){ //Funciona pero ocurre algo raro
        for(int i=0; i< lista.size(); i++){
            if(lista.get(i) == i)
                return true;
        }
        return false;
    }

    public void presentaAmigo(String fSalida) throws FileNotFoundException{
        try(PrintWriter pw = new PrintWriter(fSalida)){
            presentaAmigos(pw);
        }
    }

    public void presentaAmigos(PrintWriter pw) {
        Set<Persona> salida = new TreeSet(socios);
        pw.println("Amigos Invisibles");
        for (Persona p : salida) {
            pw.println(p);
        }
    }
}
