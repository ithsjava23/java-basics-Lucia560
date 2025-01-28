package org.example;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;



public class App {
 //test
    public static void main(String[] args) {
       /* Locale swedishlocale = new Locale("sv","SE");
        Locale.setDefault(swedishlocale);*/
        Locale.setDefault(new Locale("sv","SE"));
        Scanner sc = new Scanner(System.in);

        int[][] elPriser = new int[24][2]; // priser
        String[] tidInterval = new String[24];//tider
        String userInputMenu; // menu val
        float medel4H = 0;
        int minPris = 0;
        int minFoundAt = 0;
        int maxPris = 0;
        int maxFoundAt = 0;
        double medelPris ;
        double min4H = 0;
        int min4hStartsAt = 0;

        // fylla in tidstabel
        for (int i = 0; i < 24; i++) {
            String tidStr1 = String.format("%02d", i);
            String tidStr2 = String.format("%02d", (i + 1) % 24);

            if (i == 23) {
                tidStr2 = "24";
            }

            tidInterval[i] = tidStr1 + "-" + tidStr2;
        }

        // fylla in index nummer för elpriserna
        for (int i = 0; i < 24; i++) {
            elPriser[i][1] = i;
        }

        do{
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
                        elPriser[k][0] = Integer.parseInt(sc.nextLine());

                    }
                    //sc.nextLine();
                }
                case "2"-> {
                    medelPris = 0;
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
                    System.out.print("Högsta pris: " + tidInterval[maxFoundAt] + ", " + maxPris + " öre/kWh\n");
                    System.out.print("Medelpris: " + String.format("%.02f", medelPris) + " öre/kWh\n");
                    //sc.nextLine();
                 }
                case "3" ->
                {
                    Arrays.sort(elPriser, (a, b) -> {
                        int order = Integer.compare(a[0], b[0]);
                        if (order == 0) {
                           // om lika , prioritera tidigare priser
                            return Integer.compare(b[1], a[1]);
                        }
                        else return order;
                    });
                    int place;
                    for (int i = 23; i >= 0; i--) {
                        place =  elPriser[i][1];
                        System.out.print(tidInterval[place] + " " + elPriser[i][0] + " öre\n");
                    }
                }
                case "4" -> {
                    String str="";
                    medel4H = 0;
                    for(int i = 0; i<= 20 ; i++) {
                        medel4H =(elPriser[i][0] + elPriser[i + 1][0] + elPriser[i + 2][0] + elPriser[i + 3][0])/4f;
                       if(i == 0) {
                           min4H = medel4H;
                           min4hStartsAt = i;
                           str = tidInterval[min4hStartsAt];

                       }else {
                           if(medel4H < min4H){
                               min4H = medel4H;
                               min4hStartsAt = i;
                               str = tidInterval[min4hStartsAt];
                           }
                       }
                    }
                    str = str.substring(0,2);
                    System.out.print("Påbörja laddning klockan " + str +"\n" + "Medelpris 4h: " + String.format("%.01f", min4H) + " öre/kWh\n");
                }
            }
        }while(!userInputMenu.equalsIgnoreCase("e"));

    }

}
