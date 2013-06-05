/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;

/**
 *
 * @author axelferreira
 */
public class Record implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    private Integer time;       // Tempo record em segundos
    private String pilot;       // Nome do piloto
    private String carro;       // Nome do carro

    
    
    public Record() 
    {
        this.time = 0;
        this.pilot = "";
        this.carro = "";
    }
    
    public Record(Integer time, String pilot, String carro) 
    {
        this.time = time;
        this.pilot = pilot;
        this.carro = carro;
    }

    public Record(Record r) 
    {
        this.time = r.getTime();
        this.pilot = r.getPilot();
        this.carro = r.getCarro();
    }
    
    
    
    public Integer getTime() 
    {   return time;  }

    public void setTime(Integer time) 
    {   this.time = time;  }

    public String getPilot() 
    {   return pilot;  }

    public void setPilot(String p) 
    {   this.pilot = p;  }

    public String getCarro() 
    {   return carro;  }

    public void setCarro(String carro) 
    {   this.carro = carro;  }   
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append("Tempo: " + this.time + "\n");
        s.append("Piloto: " + this.pilot + "\n");
        s.append("Carro: " + this.carro + "\n");
        
        return s.toString();
    }
    
}
