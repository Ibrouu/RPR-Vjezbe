package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
        private static GeografijaDAO instance;
        private Connection conn;
        private PreparedStatement glavniGradUpit, dajDrzavuUpit, obrisiDrzavuUpit, obrisiGradoveZaDrzavu, nadjiDrzavuUpit, dajGradoveUpit,
                dodajGradUpit, dodajDrzavuUpit, odrediIdGradaUpit, odrediIdDrzaveUpit, promijeniGradUpit, dajGradUpit;
        public static GeografijaDAO getInstance() {
                if (instance == null) instance = new GeografijaDAO();
                return instance;
        }
        private GeografijaDAO(){
                try {
                        conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                try {
                        glavniGradUpit = conn.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava \n" +
                                "FROM grad \n" +
                                "JOIN drzava ON grad.drzava = drzava.id \n" +
                                "WHERE drzava.naziv = ?");
                } catch (SQLException e) {
                        regenerisiBazu();
                        try {
                                glavniGradUpit = conn.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava \n" +
                                        "FROM grad \n" +
                                        "JOIN drzava ON grad.drzava = drzava.id \n" +
                                        "WHERE drzava.naziv = ?");
                        } catch (SQLException ex) {
                                ex.printStackTrace();
                        }
                }
                try {
                        dajDrzavuUpit = conn.prepareStatement("SELECT * FROM drzava WHERE id =?");
                        dajGradUpit = conn.prepareStatement("SELECT * FROM grad WHERE id =?");
                        obrisiDrzavuUpit = conn.prepareStatement("DELETE FROM drzava WHERE naziv =?");
                        obrisiGradoveZaDrzavu = conn.prepareStatement("DELETE FROM grad WHERE drzava =?");
                        nadjiDrzavuUpit = conn.prepareStatement("SELECT * FROM drzava WHERE naziv=?");
                        dajGradoveUpit = conn.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
                        dodajGradUpit = conn.prepareStatement("INSERT INTO grad VALUES(?,?,?,?)");
                        odrediIdGradaUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM grad");
                        dodajDrzavuUpit = conn.prepareStatement("INSERT INTO drzava VALUES(?,?,?)");
                        odrediIdDrzaveUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM drzava");
                        promijeniGradUpit = conn.prepareStatement("UPDATE grad SET naziv=?, broj_stanovnika=?, drzava=? WHERE id =?");

                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        private void regenerisiBazu(){
                Scanner ulaz = null;
                try {
                        ulaz = new Scanner(new FileInputStream("baza.db.sql"));
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                String sqlUpit = "";
                while(ulaz.hasNext()){
                        sqlUpit += ulaz.nextLine();
                        if(sqlUpit.charAt(sqlUpit.length()-1) == ';'){
                                try {
                                        Statement stmnt = conn.createStatement();
                                        stmnt.execute(sqlUpit);
                                        sqlUpit = "";
                                } catch (SQLException e) {
                                        e.printStackTrace();
                                }
                        }
                }
                ulaz.close();
        }

        public Grad glavniGrad(String drzava){
                try {
                        glavniGradUpit.setString(1,drzava);
                        ResultSet rs = glavniGradUpit.executeQuery();
                        if(!rs.next()) return null;    //ovdje pogledaaj
                        return dajGradIzResultSeta(rs);
                } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }

        }

        private Grad dajGradIzResultSeta(ResultSet rs) throws SQLException {
                Grad grad = new Grad(rs.getInt(1), rs.getString(2), rs.getInt(3), null);
                grad.setDrzava(dajDrzavu(rs.getInt(4), grad));
                return grad;
        }

        private Drzava dajDrzavu(int id, Grad grad){

                try {
                        dajDrzavuUpit.setInt(1,id);
                        ResultSet rs = dajDrzavuUpit.executeQuery();
                        if(!rs.next()) return null;
                        return dajDrzavuIzResultSeta(rs, grad);
                } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }
        }

        private Grad dajGrad(int id){
                try {
                        dajGradUpit.setInt(1,id);
                        ResultSet rs = dajDrzavuUpit.executeQuery();
                        if(!rs.next()) return null;
                        return dajGradIzResultSeta(rs);
                } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }
        }

        private Drzava dajDrzavuIzResultSeta(ResultSet rs, Grad grad) throws SQLException {
                return new Drzava(rs.getInt(1), rs.getString(2), null);
        }

        public void obrisiDrzavu(String nazivDrzave){
                try {
                        nadjiDrzavuUpit.setString(1, nazivDrzave);
                        ResultSet rs = nadjiDrzavuUpit.executeQuery();
                        if(!rs.next()) return;
                        Drzava drzava = dajDrzavuIzResultSeta(rs, null);
                        obrisiGradoveZaDrzavu.setInt(1, drzava.getId());
                        obrisiGradoveZaDrzavu.executeUpdate();
                        obrisiDrzavuUpit.setInt(1, drzava.getId());
                        obrisiDrzavuUpit.executeUpdate();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public ArrayList<Grad> gradovi(){
                ArrayList<Grad> rezultat = new ArrayList<>();
                try {
                        ResultSet rs = dajGradoveUpit.executeQuery();
                        while(rs.next()){
                                Grad grad = dajGradIzResultSeta(rs);
                                rezultat.add(grad);
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return rezultat;
        }
        public void dodajGrad(Grad grad){
                try {
                        ResultSet rs = odrediIdGradaUpit.executeQuery();
                        int id = 1;
                        if(rs.next()){
                                id = rs.getInt(1);
                        }
                        dodajGradUpit.setInt(1, id);
                        dodajGradUpit.setString(2, grad.getNaziv());
                        dodajGradUpit.setInt(3, grad.getBrojStanovnika());
                        dodajGradUpit.setInt(4, grad.getDrzava().getId());
                        dodajGradUpit.executeUpdate();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public void dodajDrzavu(Drzava drzava){
                try {
                        ResultSet rs = odrediIdDrzaveUpit.executeQuery();
                        int id = 1;
                        if(rs.next()){
                                id = rs.getInt(1);
                        }
                        dodajGradUpit.setInt(1, id);
                        dodajGradUpit.setString(2, drzava.getNaziv());
                        dodajGradUpit.setInt(3, drzava.getGlavniGrad().getId());
                        dodajGradUpit.executeUpdate();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        public void izmijeniGrad(Grad grad){
                try {
                        promijeniGradUpit.setString(1, grad.getNaziv());
                        promijeniGradUpit.setInt(2, grad.getBrojStanovnika());
                        promijeniGradUpit.setInt(3, grad.getDrzava().getId());
                        promijeniGradUpit.setInt(4, grad.getId());
                        promijeniGradUpit.executeUpdate();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        public Drzava nadjiDrzavu(String nazivDrzave){
                try {
                        nadjiDrzavuUpit.setString(1, nazivDrzave);
                        ResultSet rs = nadjiDrzavuUpit.executeQuery();
                        if(!rs.next()) return null;
                        return dajDrzavuIzResultSeta(rs,dajGrad(rs.getInt(3)));
                } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                }
        }
}