package org.example;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Vill du avsluta ? (e/E för att avsluta)");
            String exit = sc.nextLine();
            if (exit.equalsIgnoreCase("e")) {
                System.out.println("Programmet avslutas.");
                break;
            }
        }
        sc.close();
    }
    public static void menu() {

        System.out.println("Elpriser");
        System.out.println("=========");
        System.out.println("1.Inmatning");
        System.out.println("2.Min,Max och Medel");
        System.out.println("3.Sortera");
        System.out.println("4.Bästa laddnings tid (4 h)");
        System.out.println("e.Avsluta");
        Scanner s = new Scanner(System.in);
        String userChoice = s.nextLine();

        switch (userChoice) {
            case "1" -> System.out.println("Du har valt -Inmatning- : ");
            //metod for inmatning och return to menu
            case "2" -> System.out.println("Du har valt -Min, Max och Medel- : ");
            //metod och return menu
            case "3" -> System.out.println("Du har valt -Sortera- : ");
            // metod
            case "4"-> System.out.println("Du har valt -Bästa laddnings tid(4h)-");
            //metod
            default -> System.out.println("Ogiltig val.");
        }







    }

}
