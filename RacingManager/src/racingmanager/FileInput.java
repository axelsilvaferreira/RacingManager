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
    public static ArrayList<String> carInput (){
        ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("carros.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) linhas.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return linhas;
    }
    
    public static ArrayList<String> cirInput (){
        ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("circuitos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) linhas.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return linhas;
    }
    
    public static ArrayList<String> pilInput (){
        ArrayList<String> linhas = new ArrayList<String> ();
        Scanner fichScan = null;
        try {
            fichScan = new Scanner(new FileReader("pilotos.txt"));
            fichScan.useDelimiter(System.getProperty("line.separator"));
            while (fichScan.hasNext()) linhas.add(fichScan.next());
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
        return linhas;
    }

    public static void carToString () {
        ArrayList<String> carros = carInput();
        Participantes f = new Participantes();
        Integer categoria,pAtual,hibrido,cc,cv,tTotal;
        
        Veiculo v;
        int index = 0;
        
        while (index < carros.size()) {
        String linha = carros.get(index);
        
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
    
    public static void cirToString () {
        ArrayList<String> circuitos = cirInput();
        int index = 0;
        
        while (index < circuitos.size()) {
        String linha = circuitos.get(index);
        
        String[] campos = linha.split(",");
        
        StringBuilder output = new StringBuilder();
        
        output.append("|Circuito| Index nº" + index + "\n\n");
        for (int i=0; i < campos.length; i++) {
            output.append("Campo " + i + ": " + campos[i] + "\n");
        }
        System.out.println(output);
        output = null;
        index++;
        }
    }
    
    public static void pilToString () {
        ArrayList<String> pilotos = pilInput();
        Piloto p;
        Integer skill,skillWet,palmares;
        
        int index = 0;
        
        while (index < pilotos.size()) {
        String linha = pilotos.get(index);
        
        String[] campos = linha.split(",");
        
        StringBuilder output = new StringBuilder();
        
        output.append("|Piloto| Index nº" + index + "\n\n");
        for (int i=0; i < campos.length; i++) {
            output.append("Campo " + i + ": " + campos[i] + "\n");
        }
        
        skill = Integer.parseInt(campos[2]);
        skillWet = Integer.parseInt(campos[3]);
        palmares = Integer.parseInt(campos[4]);
        
        p = new Piloto(campos[0], campos[1], skill, skillWet, palmares, campos[5]);
        //System.out.println("///// " + skill + "\\\\\\");
        System.out.println(output);
        output = null;
        index++;
        }
    }
}
