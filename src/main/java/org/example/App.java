package org.example;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        while (true)
            menu();

    }
    public static float minPris = 0;
    public static float maxPris = 0;
    public static float medelPris = 0;
    public static void inmatningData() {
        Scanner scanner = new Scanner(System.in);

        float[][] elPriser = new float[24][2];

        for(int i = 0; i < 24; i++ ){
            elPriser[i][0] = i;
        }

        System.out.println("Skriv in elpriserna i hela öre :");
        // tid i format 00-23
        String[][] tidInterval = new String[24][1];
        int tid1;
        int tid2;
        String tidStr1 = "";
        String tidStr2 = "";

        for (int i = 0; i < 24; i++) {
            tid1 = i;
            tid2 = i + 1;

            if (i <= 9) {
                tidStr1 = String.format("%02d", tid1);
                tidStr2 = String.format("%02d", tid2);
            } else{
                if (i == 23) {
                    tid2 = 0;
                    tidStr2 = String.format("%02d", tid2);
                }
                tidStr1 = String.valueOf(tid1);
                if (i != 23) {
                    tidStr2 = String.valueOf(tid2);
                }
            }


            tidInterval[i][0] = tidStr1 + " - " + tidStr2;
        }

        // ta userinput
        for (int k = 0; k < elPriser.length; k++) {
            System.out.print(tidInterval[k][0] + " ");
            elPriser[k][0] = scanner.nextFloat();
            // initiera min och max pris
            if(k==0){
                minPris = elPriser[k][0];
                maxPris = elPriser[k][0];
            }
            if(elPriser[k][0] > maxPris){
                maxPris = elPriser[k][0];
            }
            if(elPriser[k][0] < minPris){
                minPris = elPriser[k][0];
            }
            medelPris = medelPris + elPriser[k][0];
        }
        medelPris = medelPris /24;
        // Skriv ut elpriserna
        System.out.println(" ");
        System.out.println("Elpriserna per timme:");
        for (int j = 0; j < elPriser.length; j++) {
            System.out.println(tidInterval[j][0] + elPriser[j][0] + " öre");
        }
    }

    private static void menu() {
        System.out.println(" ");
        System.out.println("Elpriser");
        System.out.println("=========");
        System.out.println("1.Inmatning");
        System.out.println("2.Min, Max och Medel");
        System.out.println("3.Sortera");
        System.out.println("4.Bästa laddningstid (4 h)");
        System.out.println("e.Avsluta");
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine();


        switch (userChoice) {
            case "1":
                System.out.println("Du har valt -Inmatning-" );
                inmatningData();
                break;
            case "2":
                System.out.println("Du har valt -Min, Max och Medel- : ");
                System.out.println("Längsta priset är :" + String.format("%.02f", minPris) +" öre");
                System.out.println("Hogsta priset är :" +String.format("%.02f", maxPris) +" öre");
                System.out.println("Medelvärdet är :" + String.format("%.02f", medelPris) +" öre");


                break;
            case "3":
                System.out.println("Du har valt -Sortera- : ");
                break;
            case "4":
                System.out.println("Du har valt -Bästa laddningstid(4h)-");
                break;
            case "e":
            case "E":
                System.out.println("Programet avslutas.");
                System.exit(0);
            default:
                System.out.println("Ogiltig val. Försök igen");
                break;
        }

    }





}



