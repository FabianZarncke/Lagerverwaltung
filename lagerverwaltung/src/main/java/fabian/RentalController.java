/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabian;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author fabia
 */
public class RentalController implements Initializable {

    @FXML
    private Button homeBTN;
    @FXML
    private ListView<String> listview;
    @FXML
    private Button newRentalBTN;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button payedBTN;
    @FXML
    private Button editBTN;
    @FXML
    private Button printBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeBTN(ActionEvent event) throws IOException {
        App.setRoot("HomeView");
    }

    @FXML
    private void listviewBTB(MouseEvent event) {
    }

    @FXML
    private void newRentalBTN(ActionEvent event) {
    }

    @FXML
    private void deleteBTN(ActionEvent event) {
    }

    @FXML
    private void payedBTN(ActionEvent event) {
    }


    @FXML
    private void editBTN(ActionEvent event) {
    }

    @FXML
    private void printBTN(ActionEvent event) {
    }
    
}
