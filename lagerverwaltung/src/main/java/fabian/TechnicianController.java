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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author fabia
 */
public class TechnicianController implements Initializable {

    @FXML
    private Button homeBTN;
    @FXML
    private ListView<String> listview;
    @FXML
    private TextField firstnameTF;
    @FXML
    private TextField lastnameTF;
    @FXML
    private TextField wageTF;
    @FXML
    private TextField descriptionTF;
    @FXML
    private Button doneBTN;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button newTechiBTN;

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
        for(Technician techi : App.getTechnicians()) {
            listview.getItems().add(techi.getFirstname() + " " + techi.getLastname() + " " + techi.getDescription());
        }
    }
    
    public void clearFields() {
        firstnameTF.setText("");
        lastnameTF.setText("");
        descriptionTF.setText("");
        wageTF.setText("");
        listview.getSelectionModel().clearSelection();
    }

    @FXML
    private void homeBTN(ActionEvent event) throws IOException {
        App.setRoot("HomeView");
    }

    @FXML
    private void listviewBTB(MouseEvent event) {
        firstnameTF.setText(App.getTechnicians().get(listview.getSelectionModel().getSelectedIndex()).getFirstname());
        lastnameTF.setText(App.getTechnicians().get(listview.getSelectionModel().getSelectedIndex()).getLastname());
        descriptionTF.setText(App.getTechnicians().get(listview.getSelectionModel().getSelectedIndex()).getDescription());
        wageTF.setText(String.valueOf(App.getTechnicians().get(listview.getSelectionModel().getSelectedIndex()).getWage()));
    }

    @FXML
    private void doneBTN(ActionEvent event) {
        Technician techi = new Technician(firstnameTF.getText(), lastnameTF.getText(), Float.parseFloat(wageTF.getText()), descriptionTF.getText());
        if(listview.getSelectionModel().isEmpty()) {
            App.getTechnicians().add(techi);
        } else {
            App.getTechnicians().set(listview.getSelectionModel().getSelectedIndex(), techi);
        }
        clearFields();
        refreshListview();
    }

    @FXML
    private void deleteBTN(ActionEvent event) {
        App.getTechnicians().remove(App.getTechnicians().get(listview.getSelectionModel().getSelectedIndex()));
        refreshListview();
    }

    @FXML
    private void newTechiBTN(ActionEvent event) {
        clearFields();
    }
    
}
