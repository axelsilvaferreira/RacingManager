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

    public Circuito(String Nome, Integer nVoltas, Integer tMedio, Integer tWett, Integer pRain, Integer tBox, Record record) {
        this.Nome = Nome;
        this.nVoltas = nVoltas;
        this.tMedio = tMedio;
        this.tWett = tWett;
        this.pRain = pRain;
        this.tBox = tBox;
        this.record = record;
    }
    
    public Circuito(){
        this.Nome = "";
        this.nVoltas = 0;
        this.tMedio = 0;
        this.tWett = 0;
        this.pRain = 0;
        this.tBox = 0;
        this.record = null;
    }
        
     public Circuito(Circuito c) {
        this.Nome = c.getNome();
        this.nVoltas = c.getnVoltas();
        this.tMedio = c.gettMedio();
        this.tWett = c.gettWett();
        this.pRain = c.getpRain();
        this.tBox = c.gettBox();
        this.record = c.getRecord();
    }

        
        
        
        
        
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getnVoltas() {
        return nVoltas;
    }

    public void setnVoltas(Integer nVoltas) {
        this.nVoltas = nVoltas;
    }

    public Integer gettMedio() {
        return tMedio;
    }

    public void settMedio(Integer tMedio) {
        this.tMedio = tMedio;
    }

    public Integer gettWett() {
        return tWett;
    }

    public void settWett(Integer tWett) {
        this.tWett = tWett;
    }

    public Integer getpRain() {
        return pRain;
    }

    public void setpRain(Integer pRain) {
        this.pRain = pRain;
    }

    public Integer gettBox() {
        return tBox;
    }

    public void settBox(Integer tBox) {
        this.tBox = tBox;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
        
       

        
        
}
