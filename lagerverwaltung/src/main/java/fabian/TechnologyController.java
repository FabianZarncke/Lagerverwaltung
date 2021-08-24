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
import javafx.scene.control.MenuItem;
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
    @FXML
    private MenuItem boxBTN;
    @FXML
    private MenuItem wireBTN;
    @FXML
    private MenuItem stageBTN;
    @FXML
    private MenuItem deskBTN;
    @FXML
    private MenuItem crossbarBTN;
    @FXML
    private MenuItem monitorBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshListview();
    }
    
    public void refreshListview() {
        listview.getItems().removeAll();
        listview.getItems().clear();
        for(Technology tech : App.getTechnologies()) {
            listview.getItems().add(tech.getClass().getSimpleName() + ": " + tech.getName() + " " + tech.getDescription());
        }
    }
    
    public void clearFields() {
        nameTF.setText("");
        descriptionTF.setText("");
        priceTF.setText("");
        shelfTF.setText("");
        slotTF.setText("");
        customFieldTF.setText("");
        listview.getSelectionModel().clearSelection();
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
        clearFields();
    }

    @FXML
    private void defectBTN(ActionEvent event) {
    }

    @FXML
    private void boxBTN(ActionEvent event) {
    }

    @FXML
    private void wireBTN(ActionEvent event) {
    }

    @FXML
    private void stageBTN(ActionEvent event) {
    }

    @FXML
    private void deskBTN(ActionEvent event) {
    }

    @FXML
    private void crossbarBTN(ActionEvent event) {
    }

    @FXML
    private void monitorBTN(ActionEvent event) {
    }
    
}
