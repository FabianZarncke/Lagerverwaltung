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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author fabia
 */
public class TechnologyController implements Initializable {

    @FXML
    private Button homeBTN;
    @FXML
    private ListView<String> listview;
    @FXML
    private MenuButton menuBTN;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField descriptionTF;
    @FXML
    private TextField priceTF;
    @FXML
    private Button doneBTN;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button newTechBTN;
    @FXML
    private TextField customFieldTF;
    @FXML
    private TextField shelfTF;
    @FXML
    private TextField slotTF;
    @FXML
    private Button defectBTN;

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
    private void menuBTN(ActionEvent event) {
    }

    @FXML
    private void doneBTN(ActionEvent event) {
    }

    @FXML
    private void deleteBTN(ActionEvent event) {
    }

    @FXML
    private void newTechBTN(ActionEvent event) {
    }

    @FXML
    private void defectBTN(ActionEvent event) {
    }
    
}
