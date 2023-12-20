package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao, Serializable{

    private ArrayList<Laptop> laptopi;
    private File file;



    public LaptopDaoSerializableFile(File file) {
        this.file = file;
        laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            // Koristite konstruktor koji omogućuje pisanje na kraj datoteke
            ObjectOutputStream izlaz = new ObjectOutputStream(new FileOutputStream(file, true));

            // Dodajte laptop na kraj datoteke
            izlaz.writeObject(laptop);

            // Zatvorite ObjectOutputStream
            izlaz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Laptop getLaptop(String procesor) {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nije pronađen laptop sa procesorom: " + procesor);

    }


    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> rez = new ArrayList<>();

        try  {
            ObjectInputStream ulaz = new ObjectInputStream(new FileInputStream(file));
            while (ulaz.available() > 0) {
                Laptop lap = (Laptop) ulaz.readObject();
                rez.add(lap);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rez;
    }


    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }
}
