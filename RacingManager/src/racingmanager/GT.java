/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.Random;

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
    
    // Fiabilidade do Carro de classe GT depende da cilindrada (- é melhor) e decresce a cada volta.
    private Integer fiabilidade ;           // Fibilidade do carro.
    private static final int  tClassVolta = 20; // Tempo em seg do desvio da classe ao tempo medio.
    
    
    public GT() 
    {   super("", "", "", null, null, true, 0, 3000, 240); 
        Random rand = new Random();
        int ran = rand.nextInt(5);  // Taxa de decrescimo a cada volta (equivale a %)
        // criação da fiabilidade do carro
        fiabilidade = 0;
    }

    public GT(String equipa, String marca, String modelo, Piloto p1, Piloto p2, boolean pAtual, Integer h, int cc, int cv) 
    {   super(equipa, marca, modelo, p1, p2, pAtual, h, cc, cv);
        if (cc >=3000 && cc<=4500)
        {   super.setCC(3500); }
        fiabilidade = 0;
    }

    public GT(GT v) 
    {   super(v);  
        fiabilidade = v.getFiabilidade();
    }

    
    public void setCC_GT(int cc)
    {
        if ((cc >=3000 ) && (cc<=4500))
        { super.setCC(cc); } 
    }
    
    public int getFiabilidade()
    { return this.fiabilidade; }
    
    public void setFiabilidade(int f)
    {   this.fiabilidade = f; }
    
    
    // PROVAVELMENTE ABSTRACT DE VEICULO
    public void geraFiabilidade()
    {}
    
    
    
    @Override
    public int tempoProximaVolta(Corrida c) 
    { boolean weather = c.getisRain();
      int time, skill;  
      Piloto pilot;
      
      // Escolhe o Piloto
      if (this.getpAtual())
      {pilot = this.getPiloto1();}
      else {pilot = this.getPiloto2();}      
      
      // Verifica as condições climatéricas e dá a skill correspondente
      if (weather)    
      {skill = pilot.getwSkill();}           // Se chover
      else {skill = pilot.getSkill();}       // Se não chover
      
      // Tempo médio de uma volta á pista para esta classe
      time = ((c.getCircuito().gettMedio()) + tClassVolta);   
      if (weather) {time += c.getCircuito().gettWett();}    // Acrescenta o tempo extra da chuva
      
      
      
      
      
      
      
      // Calcular o tempo medio
      Random rand = new Random();
      boolean val = rand.nextInt(25)==0;
      
      if( new Random().nextDouble() <= 0.04 ) 
      { //we hit the 1/25 ( 4% ) case.
      }
      
      
      
      
      
        
        return time;
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
    public boolean equals(Object o) 
    { boolean ret;
        
        if (o instanceof GT)
            { GT c = (GT) o;
                
                if ( super.getMarca().equals(c.getMarca()) &&
                     super.getModelo().equals(c.getModelo()) &&
                     super.getPiloto1().toString().equals(c.getPiloto1().toString()) &&
                     super.getPiloto2().toString().equals(c.getPiloto2().toString())
                   )
                 {ret = true;}
                
                else {ret = false;}
            }
        else {ret = false;}
        
        return ret;   
    }
    
    
    
    
}