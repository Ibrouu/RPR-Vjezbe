package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static ba.unsa.etf.rpr.Grad.SARAJEVO;
import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    @Test
    void dodaj() {
        Imenik imenik = new Imenik();
        TelefonskiBroj  broj = new FiksniBroj(SARAJEVO, "543-233");
        imenik.dodaj("Brzi Gonzales", broj);

        assertEquals("033/543-233", imenik.dajBroj("Brzi Gonzales"));
    }

    @Test
    void dajBroj() {
        Imenik imenik = new Imenik();
        TelefonskiBroj  broj = new FiksniBroj(SARAJEVO, "543-233");
        imenik.dodaj("Brzi Gonzales", broj);

        assertEquals("033/543-233", imenik.dajBroj("Brzi Gonzales"));
    }

    @Test
    void dajIme() {
        Imenik imenik = new Imenik();
        TelefonskiBroj  broj = new FiksniBroj(SARAJEVO, "543-233");
        imenik.dodaj("Brzi Gonzales", broj);

        assertEquals("Brzi Gonzales", imenik.dajIme(broj));


    }
}