/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabian;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author fabia
 */
public class MakeRentalController implements Initializable {

    @FXML
    private Button backBTN;
    @FXML
    private ListView<String> technicianListview;
    @FXML
    private Button doneBTN;
    @FXML
    private Button addTechnicianBTN;
    @FXML
    private ListView<String> customerListview;
    @FXML
    private ListView<String> technologyListview;
    @FXML
    private Button addTechnologyBTN;
    @FXML
    private ListView<String> chTechnicanListview;
    @FXML
    private Button removetechnicianBTN;
    @FXML
    private ListView<String> chTechnologyListview;
    @FXML
    private Button removeTechnologyBTN;
    @FXML
    private MenuButton statusMenu;
    @FXML
    private TextField discountTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backBTN(ActionEvent event) {
    }

    @FXML
    private void technicianListviewBTB(MouseEvent event) {
    }

    @FXML
    private void doneBTN(ActionEvent event) {
    }

    @FXML
    private void addTechnicianBTN(ActionEvent event) {
    }

    @FXML
    private void customerListview(MouseEvent event) {
    }

    @FXML
    private void technologyListviewBTN(MouseEvent event) {
    }

    @FXML
    private void addTechnologyBTN(ActionEvent event) {
    }

    @FXML
    private void chTechnicanListviewBTN(MouseEvent event) {
    }

    @FXML
    private void removetechnicianBTN(ActionEvent event) {
    }

    @FXML
    private void chTechnologyListviewBTN(MouseEvent event) {
    }

    @FXML
    private void removeTechnologyBTN(ActionEvent event) {
    }

    @FXML
    private void statusMenuBTN(MouseEvent event) {
    }
    
}
