
package ba.unsa.etf.rpr;
import java.util.Scanner;

import static ba.unsa.etf.rpr.Grad.*;

public class Program {

    public static void main(String[] args) {
        int opcija;
        Imenik imenik = new Imenik();
        System.out.println("1 - dodaj\n" +
                "2 - dajBroj\n" +
                "3 - dajIme\n" +
                "4 - naSlovu\n" +
                "5 - izGrada\n" +
                "6 - izGradaBrojevi");


        Scanner ulaz = new Scanner(System.in);
        opcija = ulaz.nextInt();

    }
}
