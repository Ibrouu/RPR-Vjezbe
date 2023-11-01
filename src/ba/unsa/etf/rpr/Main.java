package ba.unsa.etf.rpr;


public class Main {

    public static void main(String[] args) {
	// write your code here
    double broj1=Double.parseDouble(args[0]);
    double sinus = Kalkulator.izracunajSinus(broj1);


    int faktorijel = Kalkulator.izracunajFaktorijel((int)broj1);
    System.out.println("Sinus iznosi " + sinus + ", a faktorijel " + faktorijel);




    }
}
