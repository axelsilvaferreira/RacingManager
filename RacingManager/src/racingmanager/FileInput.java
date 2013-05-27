/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/**
 *
 * @author joaorua
 */
public class FileInput {
    
    private ArrayList<String> carros;
    private ArrayList<String> pilotos;
    private ArrayList<String> circuitos;
    
    private Circuitos cirs;
    
    public void carInput (){
        //ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("carros.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) carros.add(fichScan.next());
        }        
        
        catch (IOException e) { System.out.println(e.getMessage()); }
        //return carros;
    }
    
    public void cirInput (){
        //ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("circuitos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) circuitos.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        //return linhas;
    }
    
    public void pilInput (){
        //ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("pilotos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) pilotos.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        //return linhas;
    }

    public void carToString () {
        //ArrayList<String> carros = carInput();
        ArrayList<String> c = carros;
        Participantes f = new Participantes();
        Integer categoria,pAtual,hibrido,cc,cv,tTotal;
        
        Veiculo v;
        int index = 0;
        
        while (index < c.size()) {
        String linha = c.get(index);
        
        String[] campos = linha.split(",");
        
        StringBuilder output = new StringBuilder();
        
        output.append("|Carro| Index nº" + index + "\n\n");
        for (int i=0; i < campos.length; i++) {
            output.append("Campo " + i + ": " + campos[i] + "\n");
        }
        
        // Adicionar a Frota
        // 1 - GT ; 2 - PC1 ; 3 - PC2 ; 4 - SC
        
        categoria = Integer.parseInt(campos[1]);
        pAtual = Integer.parseInt(campos[6]);
        
        
        switch (categoria) {
            case 1:
                //v = new GT(campos[0], campos[2], campos[3], null, true, pAtual, 0, 0, 0);
                break;
            case 2:
                v = new PC1();
                break;
            case 3:
                v = new PC2();
                break;
            case 4:
                v = new SC();
                break;
        }
       
        //f.adVeiculo(v);
        
        System.out.println(output);
        output = null;
        index++;
        }
    }
    
    public void cirLoad () {
        ArrayList<String> c = circuitos;
        Integer l1,l2,l3,l4,l5,l6;
        Record r;
          
        int index = 0;
        Circuito cir;
        
        while (index < c.size()) {
        String linha = c.get(index);
        
        String[] campos = linha.split(",");
        
        //StringBuilder output = new StringBuilder();
        
        //output.append("|Circuito| Index nº" + index + "\n\n");
        //for (int i=0; i < campos.length; i++) {
            //output.append("Campo " + i + ": " + campos[i] + "\n");
        //}
        //System.out.println(output);
        //output = null;
        l1 = Integer.parseInt(campos[1]);
        l2 = Integer.parseInt(campos[2]);
        l3 = Integer.parseInt(campos[3]);
        l4 = Integer.parseInt(campos[4]);
        l5 = Integer.parseInt(campos[5]);
        l6 = Integer.parseInt(campos[6]);
        
        r = new Record(l6, campos[7], campos[8]);
        
        cir = new Circuito(campos[0], l1, l2, l3, l4, l5, r);
        
        cirs.addCircuito(cir.clone());
        index++;
        }
    }
    
    public void pilLoad () {
        ArrayList<String> pi = pilotos;
        Piloto p;
        Integer skill,skillWet,palmares;
        
        int index = 0;
        
        while (index < pi.size()) {
        String linha = pi.get(index);
        
        String[] campos = linha.split(",");
        
        //StringBuilder output = new StringBuilder();
        
        /*
        output.append("|Piloto| Index nº" + index + "\n\n");
        for (int i=0; i < campos.length; i++) {
            output.append("Campo " + i + ": " + campos[i] + "\n");
        }
        */
        
        skill = Integer.parseInt(campos[2]);
        skillWet = Integer.parseInt(campos[3]);
        palmares = Integer.parseInt(campos[4]);
        
        p = new Piloto(campos[0], campos[1], skill, skillWet, palmares, campos[5]);
        //System.out.println("///// " + skill + "\\\\\\");
        //System.out.println(output);
        //output = null;
        
        index++;
        }
    }
 
}
