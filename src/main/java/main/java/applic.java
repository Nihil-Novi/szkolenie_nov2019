package main.java;

import java.util.Scanner;

public class applic {
    public static void main(String[] args) {
        //definicja zmiennej przechowującej input
        Scanner input = new Scanner(System.in);

        //wyświetlenie tekstu
        System.out.println("Hello, World!");

        //inicjalizacja zmiennej przechowującej input, wyświetlenie promptu, zebranie inputu
        String polecenie = null;
        System.out.println("Zakończ proces przez wpisanie ''exit'': ");
        polecenie = input.nextLine();

        //Porównaj input ze wzorcem. Jeśli jest ok, zamknij proces; jeśli nie jest ok,
        //powtórz input do moment wpisania poprawnego polecenia
        while (!polecenie.equals("exit")) {
            System.out.println("Błędne polecenie - wpisz ''exit'': ");
            polecenie = input.nextLine();
        }
        System.out.println("Zakończono proces");

    }
}
