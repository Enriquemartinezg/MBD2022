package org.uma.mbd.mdNPI.npi;

public class NPI {
    private double x, y, z, t;

    public void entra(double valor){
        if(x==0){
            x = valor;
        }else if(y==0){
            y = x;
            x = valor;
        }else if(z==0){
            z = y;
            y = x;
            x = valor;
        }else{
            t = z;
            z = y;
            y = x;
            x = valor;
        }
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
