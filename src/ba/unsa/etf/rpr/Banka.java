package ba.unsa.etf.rpr;

import java.util.List;

import java.util.Scanner;

public class Banka {
    private Long brojRacuna;
    private List<Korisnik>  korisnici;
    private List<Uposlenik> uposlenici;

    public Banka(){
        brojRacuna = null;
        korisnici = null;
        uposlenici = null;
    }

    public Korisnik kreirajNovogKorisnika(String Ime, String Prezime){
        Korisnik novi = new Korisnik(Ime, Prezime);
        korisnici.add(novi);
        return novi;
    }

    public Uposlenik kreirajNovogUposlenika(String Ime, String Prezime){
        Uposlenik novi = new Uposlenik(Ime, Prezime);
        uposlenici.add(novi);
        return novi;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik k){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj racuna:");
        Long temp;

        temp = ulaz.nextLong();
        Racun racun= new Racun(temp, k);

        k.dodajRacun(racun);

        korisnici.add(k);
        brojRacuna = brojRacuna + 1;
        return racun;
    }


}
