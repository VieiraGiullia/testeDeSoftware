package com.example;

public class Main {
    
    public static String imprime(){
        return "teste";
    }
    public static String valor(){
        return "testeUm";
    }

    public static int soma(){
        int a = 2;
        int b = 2;
        return a + b;
    }

    public static boolean ehPar(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(imprime());
        System.out.println(valor());
        System.out.println(soma());
    }
}