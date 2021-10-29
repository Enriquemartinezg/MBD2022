package org.uma.mbd.mdAlturas.alturas;

public class EnContinente implements Seleccion{
    private String texto;

    public EnContinente(String contieneTexto){
        texto = contieneTexto;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.continente().contains(texto);
    }
}
