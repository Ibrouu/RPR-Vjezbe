package ba.unsa.etf.rpr;

public class Osoba {
    private String Ime;
    private String Prezime;

    public Osoba(String Ime, String Prezime){
        this.Ime = Ime;
        this.Prezime = Prezime;
    }

    @Override
    public String toString(){
        return this.Ime + this.Prezime;

    }

}
