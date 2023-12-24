package ba.unsa.etf.rpr.lv78;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;



public class HelloController {

  private  modelKorisnik model = new modelKorisnik();

    public PasswordField lozinkaField;
    public TextField kimeField;
    public TextField emailField;
    public TextField prezimeField;
    public TextField imeField;
    public ListView<Korisnik> pregledLista;


    public HelloController(){
       model.napuni();
   }


    @FXML
    public void initialize(){
        pregledLista.setItems(model.getKorisnici());
        model.trenutniKorisnikProperty().addListener(
                (obs, oldKorisnik, newKorisnik)->{
                    if(oldKorisnik != null){
                        imeField.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                        prezimeField.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                        emailField.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                        kimeField.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
                        lozinkaField.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());

                    }
                    if(newKorisnik == null){
                        imeField.setText("");
                        prezimeField.setText("");
                        emailField.setText("");
                        kimeField.setText("");
                        lozinkaField.setText("");
                    }
                    else{
                        imeField.textProperty().bindBidirectional(newKorisnik.imeProperty());
                        prezimeField.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                        emailField.textProperty().bindBidirectional(newKorisnik.emailProperty());
                        kimeField.textProperty().bindBidirectional(newKorisnik.korisnickoImeProperty());
                        lozinkaField.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                    }
                }
        );
    }


   @FXML
    public void akcijaDodaj(ActionEvent actionEvent) {
        Korisnik novi = new Korisnik("Korisnik", "", "", "", "");
        model.getKorisnici().add(novi);
        model.setTrenutniKorisnik(novi);
        pregledLista.refresh();

    }

    public void promjenaKorisnika(MouseEvent mouseEvent) { //ispitati
        model.setTrenutniKorisnik(pregledLista.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void akcijaKraj(ActionEvent actionEvent) {
        System.exit(0);
    }
}