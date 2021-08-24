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

/**
 * FXML Controller class
 *
 * @author fabia
 */
public class HomeController implements Initializable {

    @FXML
    private Button technologyBTN;
    @FXML
    private Button customerBTN;
    @FXML
    private Button technicianBTN;
    @FXML
    private Button rentalBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void technologyBTN(ActionEvent event) throws IOException {
        App.setRoot("TechnologyView");
    }

    @FXML
    private void customerBTN(ActionEvent event) throws IOException {
        App.setRoot("CustomerView");
    }

    @FXML
    private void technicianBTN(ActionEvent event) throws IOException {
        App.setRoot("TechnicianView");
    }

    @FXML
    private void rentalBTN(ActionEvent event) throws IOException {
        App.setRoot("RentalView");
    }
    
}
