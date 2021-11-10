package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ClubManager {
    private String fEntrada;
    private String delimitadores;
    private String fSalida;
    private boolean consola;
    private Club club;

    public ClubManager(Club club){
        this.club = club;
    }

    public ClubManager setEntrada(String fEntrada, String delim){
        this.fEntrada = fEntrada;
        this.delimitadores = delim;
        return this;
    }

    public ClubManager setSalida(String salida){
        this.fSalida = salida;
        return this;
    }

    public ClubManager setConsola(boolean consola){
        this.consola = consola;
        return this;
    }

    private void verify(){
        if(fEntrada == null)
            throw new AmigoException("Fichero de entrada de datos inexistente o erróneo.");

        if(fSalida == null && !consola)
            throw new AmigoException("No hay salida a fichero o consola.");
    }

    public void build() throws IOException, FileNotFoundException{
        verify();
        club.lee(fEntrada,delimitadores);
        club.hacerAmigos();
        if(consola){
            club.presentaAmigos(new PrintWriter(System.out, true));
        }
        if(fSalida!= null){
            club.presentaAmigo(fSalida);

        }
    }
}
