/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;

/**
 * Classe que repsresenta um veiculo do tipo SC
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class SC extends Veiculo implements Serializable 
{   // Versão de serialização
    private static final long serialVersionUID = 1L;

    private static final int  tClassVolta = 40; // Tempo em seg do desvio da classe ao tempo medio.
    
    private static float fiabilidade;

    @Override
    public int tempoProximaVolta() 
    {   throw new UnsupportedOperationException("Not supported yet.");
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