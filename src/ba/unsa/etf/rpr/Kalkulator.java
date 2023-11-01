package ba.unsa.etf.rpr;


public class Kalkulator {
    public static double izracunajSinus(double x){
        return Math.sin(x);
    }

    public static int izracunajFaktorijel(int x){
        int f=1;
        for(int i=1; i<=x; i++){
            f = f * i;
        }
        return f;
    }

}
