package ba.unsa.etf.rpr.lv78;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {
    private SimpleStringProperty Ime;
    private SimpleStringProperty Prezime;
    private SimpleStringProperty Email;
    private SimpleStringProperty korisnickoIme;
    private SimpleStringProperty lozinka;

    public Korisnik(){
        Ime = new SimpleStringProperty("");
        Prezime = new SimpleStringProperty("");
        Email = new SimpleStringProperty("");
        korisnickoIme = new SimpleStringProperty("");
        lozinka = new SimpleStringProperty("");
    }

    public Korisnik(String ime, String prezime, String email, String korisnickoIme,String lozinka) {
        Ime = new SimpleStringProperty(ime);
        Prezime = new SimpleStringProperty(prezime);
        Email = new SimpleStringProperty(email);
        this.korisnickoIme = new SimpleStringProperty(korisnickoIme);
        this.lozinka = new SimpleStringProperty(lozinka);
    }
    @Override
    public String toString(){
        return Ime.get() + " " + Prezime.get();
    }

    public void setIme(String ime) {
        this.Ime.set(ime);
    }

    public void setPrezime(String prezime) {
        this.Prezime.set(prezime);
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    public String getIme() {
        return Ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return Prezime;
    }

    public String getEmail() {
        return Email.get();
    }

    public SimpleStringProperty emailProperty() {
        return Email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public SimpleStringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }



}
