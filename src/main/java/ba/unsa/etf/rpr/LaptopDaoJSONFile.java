package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(String filePath) {
        this.file = new File(filePath);
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<Laptop> existingLaptops = vratiPodatkeIzDatoteke();
            existingLaptops.add(laptop);
            objectMapper.writeValue(file, existingLaptops);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : vratiPodatkeIzDatoteke()) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa s procesorom: " + procesor);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}