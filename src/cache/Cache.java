/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pedago
 */
public class Cache {

    public int tbloc; //taille bloc
    public int lignes; // nb ligne du cache (2^n)
    public int nbentrees; //nombre d'entrées
    public int succes;
    public int echecs;
    public int temps;
    public int[] cachee;
    
    
    public Cache (int l){
        this.tbloc=32;
        this.lignes=(int)Math.pow(2,l);
        this.nbentrees=2;
        this.succes=0;
        this.echecs=0;
        this.temps=0;
        this.cachee = new int[this.lignes];
    }
    public void lecture(){
    try {
            Scanner scanner = new Scanner(new File("C:/Users/pedago/Documents/NetBeansProjects/cache/nbproject/matrice10.txt"));
            String line;
            while(scanner.hasNextLine())
            {
                line = scanner.nextLine();
                System.out.println(line);
                String[] lec = line.split(":");
                int a=Integer.parseInt(lec[0]);
                System.out.println(a);
                if ("R".equals(lec[1])){   
                    this.succes+=1;
                }else{
                    this.echecs+=1;
                }
                
                int[] res = {0,0,0};
                res[0]= a/this.nbentrees/this.lignes;
                res[1]= a/this.nbentrees%this.lignes;
                res[2]= a/this.nbentrees%this.tbloc;
                
                
                
                
                
                
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(this.echecs );
        this.temps = this.echecs*50 + this.succes*5;
        System.out.println(this.temps);
        
        
        
        
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cache m = new Cache(2);
        m.lecture();
    }
    
}
