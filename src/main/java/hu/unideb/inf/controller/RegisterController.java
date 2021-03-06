package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private AnchorPane handleScreen;

    @FXML
    private TextField addressLabel;

    @FXML
    private Button backButton;

    @FXML
    private TextField emailLabel;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField passwordAgainLabel;

    @FXML
    private TextField passwordLabel;

    @FXML
    private Button registerButton;

    @FXML
    private TextField telefonnumberLabel;

    @FXML
    private Label noMatchingPass;

    @FXML
    private Label noValidAddress;

    @FXML
    private Label noValidEmail;

    @FXML
    private Label noValidName;

    @FXML
    private Label noValidPass;

    @FXML
    private Label noValidPhone;

    @FXML
    void clickedBackButton(ActionEvent event) {
        Stage stage = (Stage) handleScreen.getScene().getWindow();
        stage.close();
    }

    @FXML
    void clickedRegistButton(ActionEvent event) {

        boolean cont = true;
        noValidName.setVisible(false);
        noValidEmail.setVisible(false);
        noValidAddress.setVisible(false);
        noValidPhone.setVisible(false);
        noValidPass.setVisible(false);
        noMatchingPass.setVisible(false);
        //eloszor nincs hibauzenet
        if(nameLabel.getText().isEmpty()){
            noValidName.setVisible(true);
            cont = false;
        }
        if(addressLabel.getText().isEmpty()){
            noValidAddress.setVisible(true);
            cont = false;
        }
        if(telefonnumberLabel.getText().isEmpty()){
            noValidPhone.setVisible(true);
            cont = false;
        }
        if(!passwordLabel.getText().equals(passwordAgainLabel.getText())){
            noMatchingPass.setVisible(true);
            cont = false;
        }
        if(!emailLabel.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            noValidEmail.setVisible(true);
            cont = false;

        }
        if(!passwordLabel.getText().matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()???[{}]:;',?/*~$^+=<>]).{8,20}$")){
            noValidPass.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "A jelsz??nak tartalmaznia kell legal??bb egy kisbet??t, nagybet??t, sz??mot, speci??lis karaktert, valamint 8 ??s 20 karakter k??z??tti hossz??s??g??nak kell lennie!");
            alert.showAndWait();
            cont = false;
        }


        if(cont==true){
            //
            // do the register
            //
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sikeresen regisztr??lt!");
            alert.showAndWait();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        }
    }

    
}