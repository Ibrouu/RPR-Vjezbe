package ba.unsa.etf.rpr;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;



    public Racun(Long brojRacuna, Osoba korisnikRacuna){
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
        this.odobrenjePrekoracenja = false;
        this.stanjeRacuna = 0.0;
    }

    private boolean provjeriOdobrenjePrekoracenja(Double x){
        return odobrenjePrekoracenja;
    }

    public void odobriPrekoracenje(Double x){
        this.stanjeRacuna = -x;
        this.odobrenjePrekoracenja = true;
    }

    public boolean izvrsiUplatu(double p){
        if (p < 0) {
            System.out.println("Unijeli ste negativan broj.");
            return false;
        }

        stanjeRacuna += p;
        return true;
    }

    public boolean izvrsiIsplatu(double x){
        if (!odobrenjePrekoracenja && (stanjeRacuna - x) < 0) {
            System.out.println("Sredstva na racunu nisu dovoljna za isplatu.");
            return false;
        } else if((stanjeRacuna - x) < 0){
            System.out.println("Sredstva na racunu nisu dovoljna za isplatu.");

        }

        stanjeRacuna -= x;
        return true;
    }



}
