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
public class Campeonato implements Serializable
{
    
    private Circuitos pistas;       // Estrutura de Circuitos
    private Participantes frota;    // Estrutura de Veiculos
    private HistCorridas hCorridas; // Historico com as corridas feitas
    private Rank equipas;           // Ranking de equipas
    private Rank trofeuH;           // Ranking do trofeu hibrido

    
    public Campeonato() 
    {   this.pistas    = new Circuitos();
        this.frota     = new Participantes();
        this.hCorridas = new HistCorridas();
        this.equipas   = new Rank();
        this.trofeuH   = new Rank();
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
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("::: Pistas :::\n\n");
        s.append(pistas.toString() + "\n");
        s.append("::: Participantes :::\n\n");
        s.append(frota.toString() + "\n");
        s.append(hCorridas.toString() + "\n");
        s.append(equipas.toString() + "\n");
        s.append(trofeuH.toString() + "\n");
        
        return s.toString();
    }
    
    
    
}
