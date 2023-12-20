package ba.unsa.etf.rpr;

import java.io.Serializable;
import java.util.ArrayList;

public interface LaptopDao extends Serializable {
   public void dodajLaptopUListu(Laptop laptop);
    public void dodajLaptopUFile(Laptop laptop);
   public Laptop getLaptop(String procesor);
    public void napuniListu(ArrayList<Laptop> laptopi);
    public ArrayList<Laptop> vratiPodatkeIzDatoteke();

}
