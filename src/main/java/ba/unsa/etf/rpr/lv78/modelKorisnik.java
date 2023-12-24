package ba.unsa.etf.rpr.lv78;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class modelKorisnik {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public void napuni(){
        korisnici.add(new Korisnik("Mahir", "Residovic", "makac@email.com", "Makac", "2532"));
        korisnici.add(new Korisnik("Abdullah", "Iseric", "ishkee@email.com", "Ishkee", "1234"));
        korisnici.add(new Korisnik("Ibrahim", "Tabakovic", "itit66777@email.com", "Ibro", "2234"));
        trenutniKorisnik.set(null);
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        System.out.println("Korisnik promijenjen");
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }
}
