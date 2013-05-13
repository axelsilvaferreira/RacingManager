/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;

/**
 * Classe que repsresenta um veiculo do tipo PC1
 * 
 * @author axelferreira
 * 
 * @version 1.0
 */
public class PC1 extends Veiculo implements Serializable 
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    private static final int  tClassVolta = 0; // Tempo em seg do desvio da classe ao tempo medio.

    private static float fiabilidade;

    @Override
    public int tempoProximaVolta() 
    {   throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() 
    {   StringBuilder str = new StringBuilder();
    
        str.append(this.getClass().toString());
        str.append(this.getMarca());
        str.append(this.getModelo());
        str.append(this.getPiloto1().toString());
        str.append(this.getPiloto2().toString());
        if (this.getpAtual())
        {str.append(this.getPiloto1().toString());}
        else {str.append(this.getPiloto2().toString());}
        
        return str.toString();
    }

    @Override
    public boolean equals() 
    {   throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
