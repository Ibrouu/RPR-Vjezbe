package ba.unsa.etf.rpr;

public class Korisnik extends Osoba {
    private Racun racun;

    public void dodajRacun(Racun A){
        racun = A;
    }


    public Korisnik(String Ime, String Prezime) {
        super(Ime, Prezime);
    }



}
