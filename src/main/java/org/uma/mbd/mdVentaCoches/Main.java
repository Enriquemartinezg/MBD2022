package org.uma.mbd.mdVentaCoches;

import com.sun.source.tree.Tree;
import org.uma.mbd.mdVentaCoches.ventas.Modelo;
import org.uma.mbd.mdVentaCoches.ventas.Ventas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Ventas ventas = new Ventas();
        ventas.leeDatos("recursos/mdVentaCoches/ventaCoches.txt");
        Comparator<Modelo> cm =
                Comparator.comparing(m -> m.marca()); // lambda sustituida por Modelo :: marca

        Comparator<Modelo> cVentasM =
                Comparator.comparingInt(m -> m.ventasMes()); // lambda se puede sustituir por Modelo :: ventaMes

        Comparator<Modelo> cVentasA =
                Comparator.comparing(m -> m.ventasAño());

        List<Modelo> lista = ventas.getVentas();
        //Listado ordenador por marcas, igualdad de marca por ventas/mes de menor a mayor
        lista.sort(cm.thenComparing(cVentasM));
        ventas.guarda("recursos/mdVentaCoches/salida1.txt", lista);

        //Listado por modelo, a igualdad de mayor a menor ventas/año, solo > 5000 unidades
        List<Modelo> lista1 = ventas.filtra(m -> m.ventasAño()>5000);
        lista1.sort(cm.thenComparing(cVentasA.reversed()));
        PrintWriter pw = new PrintWriter(System.out, true);
        ventas.guarda(pw,lista1);

        System.out.println("Conjuntos\n\n");
        Set<Modelo> set = new TreeSet<>(cm.thenComparing(cVentasA.reversed()));
        set.addAll(lista1);
        for(Modelo mod : set){
            System.out.println(mod);
        }

//        List<Modelo> mod = ventas.filtra(p -> p.marca().equals("Toyota"));
//        ventas.guarda("recursos/mdVentaCoches/salida.txt", mod);
    }
}
