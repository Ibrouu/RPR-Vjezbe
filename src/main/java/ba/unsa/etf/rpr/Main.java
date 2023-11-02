package ba.unsa.etf.rpr;

import java.util.ArrayList;
import  java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);

        List<Double> brojevi = new ArrayList<>();

        String unos = new String(); //treba li???


        System.out.println("Unesite brojeve: ");

        while (true) {
            String input = ulaz.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                double number = Double.parseDouble(input);
                brojevi.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Neispravan unos. Molimo unesite broj ili stop.");
            }
        }//while


        if (brojevi.isEmpty()) {
            System.out.println("Niste unijeli nijedan broj.");
        } else {
            double min = brojevi.get(0);
            double max = brojevi.get(0);
            double suma = 0.0;
            for (double number : brojevi) {
                if (number < min) {
                    min = number;
                }
                if (number > max) {
                    max = number;
                }
                suma += number;
            }
            double mean = suma / brojevi.size();

            double sumaKvadrata = 0.0;
            for (double number : brojevi) {
                sumaKvadrata += Math.pow(number - mean, 2);
            }
            double standardaDevijacija = Math.sqrt(sumaKvadrata / brojevi.size());

            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);
            System.out.println("Mean: " + mean);
            System.out.println("Standardna devijacija: " + standardaDevijacija);
        }





    }
}
