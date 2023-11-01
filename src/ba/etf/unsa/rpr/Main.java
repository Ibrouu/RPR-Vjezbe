package ba.etf.unsa.rpr;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner ulaz = new Scanner(System.in);

        int a, b;
        System.out.println("Unesite brojeve: ");
        a = ulaz.nextInt();
        b = ulaz.nextInt();
        System.out.println(a + " " + b);

    }
}