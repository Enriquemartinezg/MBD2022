package org.uma.mbd.mdCoches.coches;

public class Programa {
    public static<T> void copiaPrimero(Par<T> origen, Par<? super T> destino){
        destino.primero(origen.primero());
    }

    public static void main(String[] args) {
        Coche c = new Coche("Seat", 10000);
        CocheImportado i = new CocheImportado("Mercedes", 23300, 4000);

        Par<Coche> pc = new Par<>(c,c);
        Par<CocheImportado> pi= new Par<>(i,i);
        Programa.copiaPrimero(pi,pc);
    }
}
