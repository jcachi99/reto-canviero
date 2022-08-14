/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto.canviero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jcachi
 */
public class MainEjercicios {
    
    public static void main(String[] args) {
        
        aplicacion();
        
    }
    
    public static void aplicacion(){
        menu();
    }
    
    public static void menu(){
        int opcion;
        Scanner lee = new Scanner(System.in);
        do {
          letrero();
          opcion =consigueNumeroXConsolaTryCatch(lee, "opcion (para salir cero)");
          procesarOpcion(opcion, lee);
        } while (opcion !=0);
        lee.close();
    }
    
    public static void letrero(){
        System.out.println(" *************************************************** ");
        System.out.println(" 1.- Problema: Calculo de Salarios");
        System.out.println(" 2.- Problema: Buenos Amigos");
        System.out.println(" 0.- Para salir cero ");
        System.out.println(" *************************************************** ");
        
    }
    
    public static void procesarOpcion(int opcion,Scanner lee){
        
        switch (opcion) {
            case 1:{
                problemaSalarios(lee);
                break;
            }
            case 2:{
                problemaBuenosAmigos(lee);
                break;
            }
            case 0:{
                System.out.println(" Gracias por su visita");
                break;
            }
            default:{
                System.out.println(" opcion no valida ....");
                break;
            }
                
        }
    }
    
    public static void problemaBuenosAmigos(Scanner lee){
        lee.nextLine();
        System.out.println("ingrese cadena: ");
        String cadena = lee.nextLine();
        
        String[] arregloCad = cadena.split(" ");
        long[] enteros = new long[5];
        enteros = obtenerEnteros(arregloCad);
        
        validar(enteros);
    }
    
    public static void validar(long[] enteros){
        
        long dtotal = enteros[0]*2;
        long c1 = enteros[1];
        long d1 = enteros[2];
        long c2 = enteros[3];
        long d2 = enteros[4];
        
        //validar si c1 d1 pueden llegar a dtotal
        int r = -1;
        for(int i=0;i<=c1;i++){
            r = (dtotal<=i*d1)?1:-1;
        }
        
        if(r!=1){
            //validar si c1 d1 pueden llegar a dtotal
            for(int i=0;i<=c2;i++){
                r = (dtotal<=i*d2)?1:-1;
            }
        }
        
        //validar el c1 d1 aumentando el d2
        if(r!=1){
            for(int i=0;i<=c1;i++){
                long res1 = dtotal - (i*d1);
                    for(int j=0;j<=c2;j++){
                    long res2 = (j*d2) - (res1*2);
                    if(res2>=0){
                        r=i+j;
                    }
                }
            }
        }
        
        System.out.println("cantidad de personas final: "+r);
        
        
    }
    
    public static long[] obtenerEnteros(String[] arregloCad){
        long[] enteros = new long[5];
        boolean ok = false;
        do {            
            try {
                for(int i=0;i<5;i++){
                    enteros[i] = Long.parseLong(arregloCad[i]);
                }
                ok=true;
            } catch (Exception e) {
                System.out.println("Error al obtener enteros, digitar nuevamente la cadena "+e.getMessage());
            }
        } while (ok!=true);
        return enteros;
    }
    
    public static void problemaSalarios(Scanner lee){
        int tamanio = consigueNumeroXConsolaTryCatch(lee,"ingresar tamanio de matriz");
        char matriz[][] = new char[tamanio][tamanio];
        char[] matrizy = new char[tamanio];
        lee.nextLine();
        for(int i=0;i<tamanio;i++){
            System.out.println("---- Elementos de la fila "+(i+1)+" ----");
            for(int j=0;j<tamanio;j++){
                matriz[i][j] = consigueCaracterXConsola(lee,"elemento "+(j+1));
            }
        }
        
        //imprimiendo matriz
        System.out.println("---- Matriz ingresada ----");
        for(int i=0;i<tamanio;i++){
            for(int j=0;j<tamanio;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        
        int salarioF=0;
        
        System.out.println("---- Resultado ----");
        
        for(int i=0;i<tamanio;i++){
            for(int j=0;j<tamanio;j++){
                matrizy[j] = matriz[i][j];
            }
            salarioF+=calcularSalario(matrizy, i);
        }
        System.out.println("");
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
    
    public static char consigueCaracterXConsola(Scanner x, String msg) {
        char n='N';
        
        boolean ok = false;
        do {            
            try {
                System.out.println("Ingrese "+ msg + " : ");
                n = Character.toUpperCase(x.nextLine().charAt(0));
                if(n=='N' || n=='Y'){
                    ok=true;
                }else{
                    System.out.println("Caracter incorrecto, por favor vuelve a intentar");
                }
            } catch (Exception e) {
                System.out.println("Error en caracter ingresado, por favor vuelve a intentar");
                x.nextLine();
            }
        } while (ok!=true);
        
        return n;
    }
    
}
