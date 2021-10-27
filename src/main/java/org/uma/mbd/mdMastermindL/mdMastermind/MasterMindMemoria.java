package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMindMemoria extends MasterMind{
    private List<Movimiento> movimientos = new ArrayList<>();

    public MasterMindMemoria(){
        super();
    }

    public MasterMindMemoria(int nCifras){
        super(nCifras);
    }

    public MasterMindMemoria(String codigo){
        super(codigo);
    }

    @Override
    public Movimiento intento(String cifras){
        Movimiento mov = super.intento(cifras);
        if(movimientos.contains(mov))
            throw new MasterMindException("Ya se ha provado esa combinación.");

        movimientos.add(mov);
        return mov;
    }

    public List<Movimiento> movimientos(){
        return movimientos;
    }
}
