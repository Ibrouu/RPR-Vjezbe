package ba.unsa.etf.rpr;
import java.util.Objects;

public class MedunarodniBroj extends  TelefonskiBroj {
    String drzava;
    String broj;

    public MedunarodniBroj(String drzava, String broj) throws BrojException{
        if(drzava == null) throw new BrojException("Drzava nije korektno navedena");
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        if(drzava != null && broj != null) {
            return drzava + "/" + broj;
        }else{
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(drzava, broj);
    }
}
