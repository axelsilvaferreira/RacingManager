/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author axelferreira
 */
public class Jogador implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String nome;            // Nome
    private String morada;          // Morada
    private double conta;          // Balanço da Conta Corrente
    private Aposta atual;           // Apostas Atuais
    private HistApostas historico;  // Historico de Apostas

    public Jogador()
    {   nome      = "";
        morada    = "";
        conta     = 0;
        atual     = null;
        historico = null;
    }

    public Jogador(String nome, String morada, double conta, Aposta atual, HistApostas historico) 
    {   this.nome = nome;
        this.morada = morada;
        this.conta = conta;
        this.atual = atual;
        this.historico = historico;
    }
    
    public Jogador(Jogador j)
    {   nome      = j.getNome();
        morada    = j.getMorada();
        conta     = j.getConta();
        atual     = j.getAtual();
        historico = j.getHistorico();
    }

    public String getNome() 
    {   return nome; }

    public void setNome(String nome) 
    {   this.nome = nome;  }

    public String getMorada() 
    {   return morada; }

    public void setMorada(String morada) 
    {   this.morada = morada;  }

    public double getConta() 
    {   return conta;  }

    public void setConta(double conta) 
    {   this.conta = conta;  }

    public Aposta getAtual() 
    {   return atual; }

    public void setAtual(Aposta atual) 
    {   this.atual = atual;  }

    public HistApostas getHistorico() 
    {   return historico;  }

    public void setHistorico(HistApostas historico) 
    {   this.historico = historico; }
    
    public void addGanhos(){
        this.setConta(this.getConta() + this.atual.getGanhos());
        this.historico.addAposta(this.atual);
    }
}
