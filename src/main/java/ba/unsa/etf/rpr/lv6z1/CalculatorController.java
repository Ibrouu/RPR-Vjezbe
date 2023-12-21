package ba.unsa.etf.rpr.lv6z1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private Label txtDisplay;

    private int decimalClick = 0;
    private Double firstDouble;
    private String generalOperationObject;


    @FXML
    private void handlerGeneralAction(ActionEvent event){
       generalOperationObject = ((Button) event.getSource()).getText();
        switch(generalOperationObject){
            case "+":
            case "-":
            case "x":
            case "%":
            case "/":
                String currentText = txtDisplay.getText();
                firstDouble  = Double.parseDouble(currentText);
                txtDisplay.setText("");
                decimalClick=0;
                break;
            default:

        }

    }
    @FXML
    void handlerEqualAction(ActionEvent event) {
        Double secondDouble;
        double result = 0;
        String secondText = txtDisplay.getText();
        secondDouble = Double.parseDouble(secondText);
        switch (generalOperationObject){
            case "+":
                result = firstDouble + secondDouble;
                break;
            case "-":
                result = firstDouble - secondDouble;
                break;
            case "X":
                result = firstDouble * secondDouble;
                break;
            case "/":
                result = firstDouble / secondDouble;
                break;
            case "%":
                result = firstDouble % secondDouble;
                break;
            default:
        }
        String format = String.format("%.1f",result);
        txtDisplay.setText(format);
    }


    @FXML
    private void handlerDigitAction(ActionEvent event){
        String digitObject = ((Button)event.getSource()).getText();
        String oldText = txtDisplay.getText();
        String newText = oldText + digitObject;
        txtDisplay.setText(newText);
    }

    @FXML
    private void handlerDecimalAction(ActionEvent event){
        if(decimalClick==0){
            String decimalObject = ((Button)event.getSource()).getText();
            String oldText = txtDisplay.getText();
            String newText = oldText + decimalObject;
            txtDisplay.setText(newText);
            decimalClick = 1;
        }
    }




}
