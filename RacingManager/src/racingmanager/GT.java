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
    
    private static float fiabilidade;

    
    
    
    
    public GT() 
    {
        
    }

    public GT(String marca, String modelo, String p1, String p2, boolean h, String categoria) 
    {
        super(marca, modelo, p1, p2, h, categoria);
    }

    public GT(Veiculo v) 
    {
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