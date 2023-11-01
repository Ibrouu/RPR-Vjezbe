package ba.unsa.etf.rpr;

import java.util.Scanner;


public class Main {
    public static void sumaCifara(int n){
        int  suma=0;
        int temp=0;

        for(int i=1; i<=n; i++){
            temp = i;
            suma = 0;
            while(temp!=0){
                suma = suma + temp%10;
                temp=temp/10;
            }
            if(i % suma == 0) {
                System.out.println(i + " ");
            }
        }


    }
    public static void main(String[] args) {
        int n;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite n: ");
        n = ulaz.nextInt();
        sumaCifara(n);

    }
}
