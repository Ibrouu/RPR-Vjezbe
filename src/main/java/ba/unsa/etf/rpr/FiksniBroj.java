package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) throws BrojException{
        if(grad == null) throw new BrojException("Pozivni broj nije naveden");
         this.grad = grad;
         this.broj = broj;
        }

    @Override
    public String ispisi(){
        if(grad != null && broj!=null) {
            String vrati;
            vrati = grad.dajBroj() + "/" + broj;
            return vrati;
        }else{
            return null;
        }

    }

    @Override
    public int hashCode(){
        return Objects.hash(grad, broj);
    }

    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }
}
