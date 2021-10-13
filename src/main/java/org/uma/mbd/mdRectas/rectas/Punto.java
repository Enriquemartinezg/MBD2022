package org.uma.mbd.mdRectas.rectas;

public class Punto {
    private double x;
    private double y;

    public Punto(){
        this(0,0);
    }
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(Punto pto){
        return Math.sqrt(Math.pow((x-pto.x),2)+Math.pow((y-pto.y),2));
    }

    public void trasladar(double a, double b){
        x += a;
        y += b;
    }

    @Override
    public String toString(){
        return "P ("+getX()+","+getY()+")";
    }
}
