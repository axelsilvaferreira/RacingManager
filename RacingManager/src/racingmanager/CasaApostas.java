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
public class CasaApostas implements Serializable
{
    private static final long serialVersionUID = 1L;

    
    private Rank apostas;               // Rank dos 3 melhores apostadores
    private Players jogadores;          // Estrutura de Jogadores
    private Campeonato championship;     // Campeonato

   
    
    
    public CasaApostas() 
    {   apostas      = new Rank();
        jogadores    = new Players();
        championship = new Campeonato();
    }

    public CasaApostas(Rank apostas, Players jogadores, Campeonato championship) 
    {   this.apostas     = apostas;
        this.jogadores   = jogadores;
        this.championship = championship;
    }

    
    
    public Rank getApostas() 
    {   return apostas; }

    public void setApostas(Rank apostas) 
    {   this.apostas = apostas;  }

    public Players getJogadores() 
    {   return jogadores;  }

    public void setJogadores(Players jogadores) 
    {   this.jogadores = jogadores;  }

    public Campeonato getChampionship() 
    {   return championship; }

    public void setChampionship(Campeonato championship) 
    {   this.championship = championship; }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        if (apostas != null)s.append(apostas.toString());
        if (jogadores != null) s.append(jogadores.toString());
        s.append(championship.toString());
        
        return s.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
