/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.Random;
import java.lang.Math.*;


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
    
    
    private static final int  tClassVolta = 20; // Tempo em seg do desvio da classe ao tempo medio.
    
    
    public GT() 
    {   super();
        setCC(0);
    }

    public GT(String equipa, String marca, String modelo, Piloto p1, Piloto p2, boolean pAtual, Integer h, int cc, int cv, double f) 
    {   super(equipa, marca, modelo, p1, p2, pAtual, h, cc, cv, f);
        setCC(cc);
    }

    public GT(GT v) 
    {   super(v); 
        setCC(v.getCC());
    }

    @Override
    public void setCC(int cc)
    {
        if ((cc >=3000 ) && (cc<=4500))
        {   Random ran = new Random();
            int cli = showRandomInteger(3000, 4500, ran);
            super.setCC(cli); 
        } 
    }
    
    
    private static int showRandomInteger(int aStart, int aEnd, Random aRandom)
    { if ( aStart > aEnd ) 
      {  throw new IllegalArgumentException("Start cannot exceed End."); }
      //get the range, casting to long to avoid overflow problems
      long range = (long)aEnd - (long)aStart + 1;
      // compute a fraction of the range, 0 <= frac < range
      long fraction = (long)(range * aRandom.nextDouble());
      int randomNumber =  (int)(fraction + aStart);    
      return randomNumber;
    }
    
    
    // PROVAVELMENTE ABSTRACT DE VEICULO
    public void geraFiabilidade(int nVoltas)
    { Integer    i2 = getCC();
      double      i = Double.parseDouble(i2.toString());
      double    hib = Double.parseDouble(getHibrido().toString());
      double      h = 0;
      double f;
      double  start = 1;
      double    end = 999;
      double random = new Random().nextDouble();
      double result = start + (random * (end - start));
      
      if (hib > 0) { h = Math.log(hib);}
      
      // 6K - CC + Ran(0-999) - (ln(hibrido))
      f = 1/((6000)-(i)+(result)-(h));
      f*=100;
      setFiabilidade(f);
    }
    
    
    @Override
    public Veiculo clone()
    { Veiculo v = new GT(this); 
      return v;
    }
    
    
    
    @Override
    public int tempoProximaVolta(Corrida c) 
    { boolean weather = c.getisRain();
      double timeD, hibr;
      int time, skill;  
      Piloto pilot;
      Random ran = new Random();
      double r = showRandomInteger(0, 100, ran);
      double f = getFiabilidade();
      
      // Verifica se completa a volta
      if (f >= r)
      {return -1;}
      
      
      // Escolhe o Piloto
      if (this.getPAtual())
      {pilot = this.getPiloto1();}
      else {pilot = this.getPiloto2();}      
      
      // Verifica as condições climatéricas e dá a skill correspondente
      if (weather)    
      {skill = pilot.getwSkill();}           // Se chover
      else {skill = pilot.getSkill();}       // Se não chover
      // Calcula a skill para a formula
      timeD = skill;
      skill = (int) Math.log(timeD);
      
      // Tempo médio de uma volta á pista para esta classe para as condições climatéricas atuais
      time = ((c.getCircuito().gettMedio()) + tClassVolta);   
      if (weather) {time *= c.getCircuito().gettWett();}    // Acrescenta o tempo extra da chuva se chover
      
      // Calcula a redução do motor hibrido no tempo
      timeD = this.getHibrido();
      if (timeD > 0)
      { hibr = Math.log(timeD); }
      else { hibr = timeD; }
      
      // Calcular uma variação aleatoria no tempo medio
      int tRan = showRandomInteger(-10, 10, ran);
 
      
      timeD = time + tRan - hibr - skill;
      
      // Reduz a fiabilidade em 2%
      setFiabilidade(getFiabilidade() * 0.98);
      
      time = (int) timeD;
        
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
        if (this.getPAtual())
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