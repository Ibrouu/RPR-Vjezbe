package ba.unsa.etf.rpr;
import java.util.*;


public class Imenik {
    private Map<String, TelefonskiBroj> brojevi;

    public Imenik(){
        this.brojevi = new HashMap<String, TelefonskiBroj>();
    }


    public void dodaj(String ime, TelefonskiBroj broj){
        brojevi.put(ime, broj);
    }

    public String dajBroj(String ime){
        TelefonskiBroj broj = this.brojevi.get(ime);
        if(broj != null) return broj.ispisi();
        return null;
    }

    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> entry : brojevi.entrySet()){
            TelefonskiBroj temp = entry.getValue();
            if(temp.equals(broj)) return entry.getKey();

        }
        return null;
    }


    public String naSlovo(char s){
    StringBuilder builder = new StringBuilder();
    int counter  = 1;

    for(Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
        if(entry.getKey().startsWith(String.valueOf(s))){
            builder.append(counter)
                    .append(". ")
                    .append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue().ispisi())
                    .append(System.lineSeparator());
        }
        counter++;
    }

    return builder.toString();
    }


    public Set<String> izGrada(Grad g){
        Set<String> skup = new TreeSet();
        for(Map.Entry<String, TelefonskiBroj> entry : brojevi.entrySet()){
            if(entry.getValue() instanceof FiksniBroj){
                String broj = entry.getValue().ispisi();
                String pozivni = broj.substring(0,3);
                if(pozivni.equals(g.dajBroj())) skup.add(entry.getKey());
            }
        }
        return skup;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> skup = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for(Map.Entry<String, TelefonskiBroj> entry : brojevi.entrySet()){
            if(entry.getValue() instanceof FiksniBroj){
                String broj = entry.getValue().ispisi();
                String pozivni = broj.substring(0,3);
                if(pozivni.equals(g.dajBroj())) {
                    skup.add(entry.getValue());
                }
            }
        }
        return skup;
    }



}
