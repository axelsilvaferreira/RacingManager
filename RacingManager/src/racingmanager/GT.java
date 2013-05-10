/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;

/**
 * Classe que repsresenta um veiculo do tipo GT
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class GT extends Veiculo implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    private static float fiabilidade;           // Fibilidade da classe.
    private static final int  tClassVolta = 20; // Tempo em seg do desvio da classe ao tempo medio.
    
    
    public GT() {
    }

    public GT(String marca, String modelo, Piloto p1, Piloto p2, boolean pAtual, boolean h, int cc, int cv) {
        super(marca, modelo, p1, p2, pAtual, h, cc, cv);
    }

    public GT(Veiculo v) {
        super(v);
    }

    
    
    @Override
    public int tempoProximaVolta() 
    {   
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() 
    {   throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals() 
    {   throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}