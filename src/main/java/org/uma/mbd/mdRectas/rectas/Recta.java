package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;

    public Recta(Punto pto1, Punto pto2){
        direccion = new Vector(pto1, pto2);
        pto = pto1;
    }

    public Recta(Vector v, Punto pto){
        direccion = v;
        this.pto = pto;
    }

    public boolean paralelaA(Recta r){
        return direccion.paraleloA(r.direccion);
    }

    public Recta paralelaPor(Punto p){
        Recta r = new Recta(direccion,p);
        return r;
    }

    public Recta perpendicularPor(Punto p){
        Recta r = new Recta(direccion.ortogonal(),p);
        return r;
    }

    private double determinante(double a11, double a12, double a21, double a22){
        return a11 * a22 - a12 * a21;
    }

    private Implicita implicita(){
        double a, b, c;
        Implicita imp;
        a = direccion.getComponenteY();
        b = -direccion.getComponenteX();
        c = -pto.getX()* direccion.getComponenteY()+pto.getY()* direccion.getComponenteX();
        imp = new Implicita(a,b,c);

        return imp;
    }

    public Punto interseccionCon(Recta r) {
        double x1, y1;
        double cb, ac, ab;
        Implicita i1, i2;
        i2 = r.implicita();
        i1 = this.implicita();
        Punto p;
        if (this.paralelaA(r)) {
            throw new RuntimeException("Rectas paralelas");
        }

        cb = determinante(-i1.c(), i1.b(), -i2.c(), i2.b());
        ac = determinante(i1.a(), -i1.c(), i2.a(), -i2.c());
        ab = determinante(i1.a(), i1.b(), i2.a(), i2.b());

        if (ab == 0) {
            throw new RuntimeException("Rectas paralelas o coincidentes");
        }

        x1 = cb / ab;
        y1 = ac / ab;
        p = new Punto(x1, y1);

        return p;
    }


    public double distanciaDesde(Punto p){
        double distancia;
        Recta orto = new Recta(direccion.ortogonal(),p);
        Punto interseccion = new Punto(interseccionCon(orto).getX(),interseccionCon(orto).getY());
        distancia = interseccion.distancia(p);

        return distancia;
    }

    public boolean pasaPor(Punto p){
        double distancia;
        distancia = distanciaDesde(p);

        return (distancia == 0);
    }

    @Override
    public String toString() {
        return "R ("+direccion+","+pto+")";
    }
}
