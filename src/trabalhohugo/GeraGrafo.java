/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhohugo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Edson
 */
public class GeraGrafo {
   private int numVertices;
   private int numArestas;
   private int[][] matriz;
   
    public GeraGrafo(int numVertices) throws IOException{
        this.numVertices = numVertices;
        this.numArestas = ((numVertices*numVertices)-numVertices)/2;
        this.matriz = matriz = new int[numVertices][numVertices];
        Random gerador = new Random();
        for(int i=0,n=0, m=0, peso=0;i<this.numArestas;i++){
            n=gerador.nextInt(numVertices);
            m=gerador.nextInt(numVertices);
            peso=gerador.nextInt(15);
            if(matriz[n][m]!=peso){
                matriz[n][m]=peso;
                matriz[m][n]=peso;
            }
            else{
                i--;
            }
        }
        Scanner ler = new Scanner(System.in);
        FileWriter fw = new FileWriter("Grafo.dat");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(numVertices);
        for(int i=0;i<this.numVertices;i++){
            for(int j=0;j<this.numVertices;j++){
               if(matriz[i][j]!=0 && i!=j && i<j){
                   pw.println(i+" "+j+" "+matriz[i][j]);

               }        
            }
        }
        fw.close();
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumArestas() {
        return numArestas;
    }

    public void setNumArestas(int numArestas) {
        this.numArestas = numArestas;
    }
    
   
}
