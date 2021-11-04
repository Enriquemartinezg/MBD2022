package org.uma.mbd.mdVentaCoches.ventas;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Ventas {
    List<Modelo> ventas;

    public Ventas() {
        ventas = new ArrayList<>();
    }

    public void leeDatos(String fichero) throws IOException {
        for (String linea : Files.readAllLines(Paths.get(fichero))) {
            stringToVentasModelo(linea);
        }
    }

    private void stringToVentasModelo(String linea) {
        try (Scanner sc = new Scanner(linea)) {
            sc.useDelimiter(";");
            String marca = sc.next();
            String modelo = sc.next();
            int mes = sc.nextInt();
            int año = sc.nextInt();
            Modelo venta = new Modelo(marca, modelo, mes, año);
            ventas.add(venta);
        } catch (InputMismatchException e) {
            System.out.println(String.format("Dato no numerico en %-50s%n",linea));
        } catch (NoSuchElementException e) {
            System.out.println(String.format("Faltan datos en %-50s%n",linea));
        }
    }

    public List<Modelo> getVentas() {
        return ventas;
    }

    public List<Modelo> filtra(Predicate<Modelo> pred) {
        List<Modelo> res = new ArrayList<>();
        for (Modelo venta: ventas)
            if (pred.test(venta))
                res.add(venta);
        return res;
    }

    public void guarda(String fichero, List<Modelo> lista) throws IOException {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            guarda(pw, lista);
        }
    }

    public void guarda(PrintWriter pw, List<Modelo> lista) {
        for (Modelo venta: lista)
            pw.println(venta);
    }
}
