package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo;

    public Vector(double xa, double yb){
        extremo = new Punto(xa, yb);
    }

    public Vector(Punto pto){
        extremo = pto;
    }

    public Vector(Punto inicio, Punto fin){
        double x1, y1;
        x1 = fin.getX() - inicio.getX(); //Podría poner fin.x e inicio.x
        y1 = fin.getY() - inicio.getY(); //Podría poner fin.y e inicio.y
        extremo = new Punto(x1,y1);
    }

    public double getComponenteX(){
        return extremo.getX();
    }

    public double getComponenteY(){
        return extremo.getY();
    }

    public Punto extremoDesde(Punto org){
        double x0, y0;
        x0 = extremo.getX();
        y0 = extremo.getY();
        Punto p = new Punto(org.getX()+x0, org.getY()+y0);
        return p;
    }

    public double modulo(){
        return Math.sqrt(Math.pow(extremo.getX(), 2)+Math.pow(extremo.getY(), 2));
    }

    public Vector ortogonal(){
        double x, y;
        Vector v;
        x = extremo.getX();
        y = extremo.getY();
        v = new Vector(-y, x);

        return v;
    }

    public boolean paraleloA(Vector v){
        double ux, uy, vx, vy;
        ux = extremo.getX();
        uy = extremo.getY();
        vx = v.getComponenteX();
        vy = v.getComponenteY();

        return (vx*uy==vy*ux);
    }

    @Override
    public String toString(){
        return "V ("+getComponenteX()+","+getComponenteY()+")";
    }

}
