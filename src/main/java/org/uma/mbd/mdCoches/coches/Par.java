package org.uma.mbd.mdCoches.coches;

public class Par<T> {
    private T primero, segundo;

    public Par(T p, T s){
        primero = p;
        segundo = s;
    }

    public T primero() {
        return primero;
    }

    public void primero(T primero) {
        this.primero = primero;
    }

    public T segundo() {
        return segundo;
    }

    public void segundo(T segundo) {
        this.segundo = segundo;
    }
}
