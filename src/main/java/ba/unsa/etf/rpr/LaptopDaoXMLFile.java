package ba.unsa.etf.rpr;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop l){
        laptopi.add(l);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            List<Laptop> listaIzDatoteke = vratiPodatkeIzDatoteke();
            listaIzDatoteke.add(laptop);

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(file, listaIzDatoteke);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa sa traženim procesorom: " + procesor);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        try{
            ObjectMapper xmlMapper=new XmlMapper();
            InputStream inputStream=new FileInputStream(new File("laptopi.xml"));
            TypeReference<ArrayList<Laptop>> typeReference=new TypeReference<ArrayList<Laptop>>() {};
            ArrayList<Laptop> lapTopi= xmlMapper.readValue(inputStream,typeReference);
            for(Laptop l : lapTopi){
                System.out.println(l.toString());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}