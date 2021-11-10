package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

abstract public class Indice {
    protected List<String> texto;

    public Indice(){
        texto = new LinkedList<>();
    }

    public void agregarLinea(String linea){
        texto.add(linea);
    }

    abstract public void resolver(String delimitadores, Collection<String> noSignificativas);
    abstract public void presentarIndiceConsola();
}
