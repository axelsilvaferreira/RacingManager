/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

/**
 *
 * @author axelferreira
 */
public class Campeonato 
{
    
    private Circuitos pistas;       // Estrutura de Circuitos
    private Participantes frota;    // Estrutura de Veiculos
    private HistCorridas hCorridas; // Historico com as corridas feitas
    private Rank equipas;           // Ranking de equipas
    private Rank trofeuH;           // Ranking do trofeu hibrido

    
    public Campeonato() 
    {   this.pistas    = null;
        this.frota     = null;
        this.hCorridas = null;
        this.equipas   = null;
        this.trofeuH   = null;
    }

    public Campeonato(Circuitos pistas, Participantes frota, HistCorridas hCorridas, Rank equipas, Rank trofeuH) 
    {   this.pistas    = pistas;
        this.frota     = frota;
        this.hCorridas = hCorridas;
        this.equipas   = equipas;
        this.trofeuH   = trofeuH;
    }

    public Circuitos getPistas() 
    {   return pistas; }

    public void setPistas(Circuitos pistas) 
    {   this.pistas = pistas;  }

    public Participantes getFrota() 
    {   return frota;  }

    public void setFrota(Participantes frota) 
    {   this.frota = frota;  }

    public HistCorridas gethCorridas() 
    {   return hCorridas;  }

    public void sethCorridas(HistCorridas hCorridas) 
    {   this.hCorridas = hCorridas; }

    public Rank getEquipas() 
    {   return equipas;  }

    public void setEquipas(Rank equipas) 
    {   this.equipas = equipas;  }

    public Rank getTrofeuH() 
    {   return trofeuH;  }

    public void setTrofeuH(Rank trofeuH) 
    {   this.trofeuH = trofeuH;  }
    
    
    
    
    
}
