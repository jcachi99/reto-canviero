/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto.canviero;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jcachi
 */
public class MainEjercicios {
    
    public static void main(String[] args) {
        
        
        Scanner lee = new Scanner(System.in);
        int tamanio = consigueNumeroXConsolaTryCatch(lee,"numero tamanio de matriz");
        char matriz[][] = new char[tamanio][tamanio];
        char[] matrizy = new char[tamanio];
        lee.nextLine();
        for(int i=0;i<tamanio;i++){
            System.out.println("---- Elementos de la fila "+(i+1)+" ----");
            for(int j=0;j<tamanio;j++){
                matriz[i][j] = consigueStringXConsola(lee,"elemento "+(j+1));
            }
        }
        
        //imprimiendo matriz
        
        for(int i=0;i<tamanio;i++){
            for(int j=0;j<tamanio;j++){
                System.out.print(""+matriz[i][j]);
            }
            System.out.println("");
        }
        
        int salarioF=0;
        
        for(int i=0;i<tamanio;i++){
            for(int j=0;j<tamanio;j++){
                matrizy[j] = matriz[i][j];
            }
            salarioF+=calcularSalario(matrizy, i);
        }
        
        
        
        
        
        System.out.println("salario total: "+salarioF);
        
    }
    
    public static int calcularSalario(char[] matrizy, int posicion){
        
        int salario=0;
        for(int i=(matrizy.length-1);i>=0;i--){
            if(i<(matrizy.length-1)){
                if(matrizy[i+1]=='Y'){
                    salario+=1;
                }
            }
        }
        
        if(salario>0){
            System.out.println("Salario("+posicion+"):"+salario);
            return salario;
        }else{
            System.out.println("Salario("+posicion+"):"+1);
            return 1;
        }
    }
    
    public static int consigueNumeroXConsolaTryCatch(Scanner x, String msg) {
        int n=0;
        boolean ok = false;
        do {            
            try {
                System.out.println("Ingrese "+ msg + " : ");
                n = x.nextInt();
                ok=true;
            } catch (Exception e) {
                System.out.println("Error en numero ingresado, por favor vuelve a intentar");
                x.nextLine();
            }
        } while (ok!=true);
        
        return n;
    }
    
    public static char consigueStringXConsola(Scanner x, String msg) {
        char n;
        System.out.println("Ingrese "+ msg + ": ");
        try{
            n = x.nextLine().charAt(0);
            return n;
        }catch(Exception e){
            System.out.println("error, se retorna N: "+e.getMessage());
            return 'N';
        }
    }
    
}
