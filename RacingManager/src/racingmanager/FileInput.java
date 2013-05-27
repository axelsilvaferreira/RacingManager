/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package racingmanager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;


/**
 *
 * @author joaorua
 */
public class FileInput {
    
    private static ArrayList<String> carros;
    private static ArrayList<String> pilotos;
    private static ArrayList<String> circuitos;
    
    private static Circuitos cirs;
    private static Piloto pils;
    private static HashMap<String,Piloto> pS;
    private static Veiculo veis;
    
    public static ArrayList<String> carInput (){
        carros = new ArrayList<String>();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("carros.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) carros.add(fichScan.next());
        }        
        catch (IOException e) { System.out.println(e.getMessage()); }
        //System.out.println(carros);
        return carros;
    }
    
    public static ArrayList<String> cirInput (){
        circuitos = new ArrayList<String>();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("circuitos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) circuitos.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return circuitos;
    }
    
    public static ArrayList<String> pilInput (){
        pilotos = new ArrayList<String>();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("pilotos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) pilotos.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return pilotos;
    }

    public void carLoad (HashMap<String,Piloto> pS) {
        carros = carInput();
        //ArrayList<String> c = carros;
        Piloto p1 = new Piloto();
        Piloto p2 = new Piloto();
        Participantes f = new Participantes();
        Integer categoria,h,cc,cv,fi;
        Boolean pActual;
        
        Veiculo v;
        int index = 0;
        
        while (index < carros.size()) {
            String linha = carros.get(index);
            String[] campos = linha.split(",");
        
            categoria = Integer.parseInt(campos[1]);
            pActual = Boolean.parseBoolean(campos[6]);
            h = Integer.parseInt(campos[7]);
            cc = Integer.parseInt(campos[8]);
            cv = Integer.parseInt(campos[9]);
            fi = Integer.parseInt(campos[10]);
            // Adicionar a Frota
            // 1 - GT ; 2 - PC1 ; 3 - PC2 ; 4 - SC
        
            switch (categoria) {
                case 1:
                    //v = new GT(campos[0], campos[2], campos[3], null, true, pAtual, 0, 0, 0);
                    p1 = pS.get(campos[4]);
                    p2 = pS.get(campos[5]);
                    v = new GT(campos[0],campos[2], campos[3],p1, p2, pActual, h, cc, cv, fi);
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
        
            //System.out.println(output);
            //output = null;
            index++;
        }
    }
    
    public static Circuitos cirLoad () {
        cirs = new Circuitos();
        ArrayList<String> c = cirInput();
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
        return cirs;
    }
    
    public static HashMap<String,Piloto> pilLoad () {
        ArrayList<String> pi = pilInput();
        Piloto p,e;
        pS = new HashMap<String, Piloto>();
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
        //e = new Piloto("a","b",1,2,3,"c");
        //System.out.println("///// " + skill + "\\\\\\");
        //System.out.println(output);
        //output = null;
        //System.out.println(p.getNome());
        pS.put(p.getNome(), p);
        //pS.put("a", e);
        index++;
        }
        //System.out.println(pS.containsKey("Manuel Castro"));
        return pS;
    }
 
    public static void loadAll () {
        pS = new HashMap<String, Piloto>();
        cirs = new Circuitos();
        
        pS = pilLoad();
        cirs = cirLoad();
        System.out.println(pS.toString());
        System.out.println(cirs.getCircuitoAtual());
    }

}
