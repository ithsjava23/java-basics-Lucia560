package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;


public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] elPriser = new int[24][2]; // priser
        String[] tidInterval = new String[24];//tider
        String userInputMenu; // menu val

        int minPris = 0;
        int minFoundAt = 0;
        int maxPris = 0;
        int maxFoundAt = 0;
        float medelPris = 0;

        // fylla in tidstabel
        for (int i = 0; i < 24; i++) {
            String tidStr1 = String.format("%02d", i);
            String tidStr2 = String.format("%02d", (i + 1) % 24);
            tidInterval [i]= tidStr1 + "-" + tidStr2;
        }
        // fylla in index nummer för elpriserna
        for (int i = 0; i < 24; i++) {
            elPriser[i][1] = i;
        }

        do {
            String menu = """
                    
                    Elpriser
                    ========
                    1. Inmatning
                    2. Min, Max och Medel
                    3. Sortera
                    4. Bästa Laddningstid (4h)
                    e. Avsluta
                    """;
            System.out.print(menu);

            userInputMenu = sc.nextLine();

            switch(userInputMenu) {
                case "1" -> { //inmatning av priser

                    for (int k = 0; k < elPriser.length; k++) {
                        System.out.print(tidInterval[k] + " ");
                        elPriser[k][0] = sc.nextInt();
                    }
                    sc.nextLine();
                }
                case "2" -> {
                    for (int k = 0; k < elPriser.length; k++) {
                        // initiera min och max pris
                        if (k == 0) {
                            minPris = elPriser[k][0];
                            minFoundAt = k;
                            maxPris = elPriser[k][0];
                            maxFoundAt = k;
                        }
                        if (elPriser[k][0] > maxPris) {
                            maxPris = elPriser[k][0];
                            maxFoundAt = k;
                        }
                        if (elPriser[k][0] < minPris) {
                            minPris = elPriser[k][0];
                            minFoundAt = k;
                        }
                        medelPris = medelPris + elPriser[k][0];
                    }
                    //kalykylera medelpris
                    medelPris = medelPris / 24;

                    //presentera statistik
                    System.out.print("Lägsta pris: " + tidInterval[minFoundAt] + ", " + minPris + " öre/kWh\n");
                    System.out.print("Hogsta pris: " + tidInterval[maxFoundAt] + ", " + maxPris + " öre/kWh\n");
                    System.out.print("Medelpris: " + String.format("%.02f", medelPris) + " öre/kWh\n");
                    sc.nextLine();
                }
                case "3" -> System.out.print("test1");
                case "4" -> System.out.print("test1");
            }
        }while(!userInputMenu.equalsIgnoreCase("e"));

    }

}