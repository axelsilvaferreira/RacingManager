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
public class Circuito implements Serializable
{   // Versão de serialização
    private static final long serialVersionUID = 1L;
    
    // Estrutura de dados
        private String Nome ;       // Nome do circuito
        private Integer nVoltas ;   // Numero de voltas
        private Integer tMedio ;    // Tempo Médio por volta
        private Integer tWett;      // Tempo extra (ou %) do piso molhado
        private Integer pRain;      // Percentagem de chuver
        private Integer tBox;       // Tempo dispendido para ir a box
        private Record record;      // Record 
        
       

        
        
}
