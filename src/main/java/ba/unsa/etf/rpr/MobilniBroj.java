package ba.unsa.etf.rpr;
import java.util.Objects;

public class MobilniBroj extends  TelefonskiBroj{
    private String broj;
    private int mobilnaMreza;

    public MobilniBroj(String broj, int mobilnaMreza){
        this.broj = broj;
        this.mobilnaMreza = mobilnaMreza;
    }

    @Override
    public String ispisi(){
        if(broj != null) {
            return "0" + mobilnaMreza + "/" + broj;
        }else{
            return null;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(broj, mobilnaMreza);
    }
}
