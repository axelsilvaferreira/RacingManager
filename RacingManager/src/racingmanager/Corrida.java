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
public class Corrida implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    //Estrutura de Dados
    
    private Record primeiro;
    private Record segundo;
    private Record terceiro;
    private Circuito circuito;
    private Participantes participant;
    
}
