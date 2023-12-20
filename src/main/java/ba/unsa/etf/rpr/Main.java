package ba.unsa.etf.rpr;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Kreiranje instance klase LaptopDaoSerializableFile
        File file = new File("laptop.bin"); // Postavite odgovarajuću putanju i ime datoteke
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(file);

        // Dodavanje laptopa u listu i u datoteku

        Laptop laptop1 = new Laptop("Dell", "Inspiron", "Intel i5", "Nvidia GTX 1050", 1200.0, 15.6, 8, 512, 0);
        Laptop laptop2 = new Laptop("HP", "Pavilion", "AMD Ryzen 7", "AMD Radeon RX 5600M", 899.99, 14, 16, 256, 512);
        Laptop laptop3 = new Laptop("Lenovo", "ThinkPad", "Intel i7", "Nvidia Quadro P520", 1800.0, 13.3, 16, 1024, 256);
        Laptop laptop4 = new Laptop("Asus", "ROG Strix", "Intel i9", "Nvidia RTX 3080", 2200.0, 17, 32, 512, 1024);

        dao.dodajLaptopUListu(laptop1);
        dao.dodajLaptopUListu(laptop2);
        dao.dodajLaptopUListu(laptop3);
        dao.dodajLaptopUListu(laptop4);

        dao.dodajLaptopUFile(laptop1);
        dao.dodajLaptopUFile(laptop2);
        dao.dodajLaptopUFile(laptop3);
        dao.dodajLaptopUFile(laptop4);


        // Čitanje podataka iz datoteke i ispis
        ArrayList<Laptop> listaIzDatoteke = new ArrayList<>();
        try {
            listaIzDatoteke = dao.vratiPodatkeIzDatoteke();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(listaIzDatoteke.size());
        // Pronalaženje laptopa po procesoru
        try {
            Laptop pronadjeniLaptop = dao.getLaptop("AMD Ryzen 7");
            System.out.println("Pronađeni laptop: " + pronadjeniLaptop.getBrend());
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }
    }
}