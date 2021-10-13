package org.uma.mbd.mdNPI.npi;

public class NPI {
    private double x, y, z, t;

    public void entra(double valor){
            x = valor;
            y = x;
            z = y;
            t = z;
    }

    public void suma(){
        x = y + x;
        y = z;
        z = t;
        t = 0;
    }

    public void resta(){
        x = y - x;
        y = z;
        z = t;
        t = 0;
    }

    public void multiplica(){
        x = y * x;
        y = z;
        z = t;
        t = 0;
    }

    public void divide(){
        x = y / x;
        y = z;
        z = t;
        t = 0;
    }

    public double getResultado(){
        return x;
    }

    @Override
    public String toString(){
        return "NPI(x = " + x + ", y = " + y + ", z = " + z + ", t = " + t + ")";
    }
}
