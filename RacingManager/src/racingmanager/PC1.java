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

    
    
    
    
    public Veiculo clone()
    { Veiculo v = new PC1(this);
        
        return v;
    }
    
    
    @Override
    public int tempoProximaVolta(Corrida c) 
    {   return 0;
    }

    @Override
    public String toString() 
    {   StringBuilder str = new StringBuilder();
    
        str.append(this.getClass().toString());
        str.append(this.getMarca());
        str.append(this.getModelo());
        str.append(this.getPiloto1().toString());
        str.append(this.getPiloto2().toString());
        if (this.getPAtual())
        {str.append(this.getPiloto1().toString());}
        else {str.append(this.getPiloto2().toString());}
        
        return str.toString();
    }

    @Override
    public boolean equals(Object o) 
    {      boolean bool=false;

        if (o instanceof PC1)
            { PC1 c = (PC1) o;
                
                if ( //FORMA SIMPLES
                        this.toString().equals(c.toString()) 
                     /* FORMA COMPLEXA
                     super.getMarca().equals(c.getMarca())      &&
                     super.getModelo().equals(c.getModelo()))   &&
                     super.getPiloto1().equals(c.getPiloto1())  &&
                     super.getPiloto2().equals(c.getPiloto2())      
                     */ 
                   )
                 {bool = true;}
            }
        return bool;  
    }
    
    
    
}
