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
            listview.getItems().add(tech.getClass().getSimpleName() + ": " + tech.getName() + " " + tech.getDescription() + " |is available: " + tech.getAvailable());
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
        nameTF.setText(App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).getName());
        descriptionTF.setText(App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).getDescription());
        priceTF.setText(String.valueOf(App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).getPrice()));
        shelfTF.setText(String.valueOf(App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).getShelf()));
        slotTF.setText(String.valueOf(App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).getSlot()));
        customFieldTF.setVisible(false);
    }

    @FXML
    private void menuBTN(ActionEvent event) {
    }

    @FXML
    private void doneBTN(ActionEvent event) {
        Technology tech;
        if(listview.getSelectionModel().isEmpty()) {
            if(menuBTN.getText().equals("Box")) {
                tech = new Box(nameTF.getText(), descriptionTF.getText(), Float.parseFloat(priceTF.getText()), Double.parseDouble(customFieldTF.getText()), Integer.parseInt(shelfTF.getText()), Integer.parseInt(slotTF.getText()));
                App.getTechnologies().add(tech);
            } else if(menuBTN.getText().equals("Crossbar")){
                tech = new Crossbar(nameTF.getText(), descriptionTF.getText(), Float.parseFloat(priceTF.getText()), Double.parseDouble(customFieldTF.getText()), Integer.parseInt(shelfTF.getText()), Integer.parseInt(slotTF.getText()));
                App.getTechnologies().add(tech);
            } else if(menuBTN.getText().equals("Desk")){
                tech = new Desk(nameTF.getText(), descriptionTF.getText(), Float.parseFloat(priceTF.getText()), Integer.parseInt(customFieldTF.getText()), Integer.parseInt(shelfTF.getText()), Integer.parseInt(slotTF.getText()));
                App.getTechnologies().add(tech);
            } else if(menuBTN.getText().equals("Monitor")){
                tech = new Monitor(nameTF.getText(), descriptionTF.getText(), Float.parseFloat(priceTF.getText()), Integer.parseInt(customFieldTF.getText()), Integer.parseInt(shelfTF.getText()), Integer.parseInt(slotTF.getText()));
                App.getTechnologies().add(tech);
            } else if(menuBTN.getText().equals("Stage")){
                tech = new Stage(nameTF.getText(), descriptionTF.getText(), Float.parseFloat(priceTF.getText()), customFieldTF.getText(), Integer.parseInt(shelfTF.getText()), Integer.parseInt(slotTF.getText()));
                App.getTechnologies().add(tech);
            } else if(menuBTN.getText().equals("Wire")){
                tech = new Wire(nameTF.getText(), descriptionTF.getText(), Float.parseFloat(priceTF.getText()), Double.parseDouble(customFieldTF.getText()), Integer.parseInt(shelfTF.getText()), Integer.parseInt(slotTF.getText()));
                App.getTechnologies().add(tech);
            }
            
        } else {
            App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).setName(nameTF.getText());
            App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).setDescription(descriptionTF.getText());
            App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).setPrice(Float.parseFloat(priceTF.getText()));
            App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).setShelf(Integer.parseInt(shelfTF.getText()));
            App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).setSlot(Integer.parseInt(slotTF.getText()));
        }
        clearFields();
        refreshListview();
    }

    @FXML
    private void deleteBTN(ActionEvent event) {
        App.getTechnologies().remove(App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()));
        refreshListview();
    }

    @FXML
    private void newTechBTN(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void defectBTN(ActionEvent event) {
        if(App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).getAvailable()) {
            App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).setAvailable(false);
        } else {
            App.getTechnologies().get(listview.getSelectionModel().getSelectedIndex()).setAvailable(true);
        }
        refreshListview();
    }

    @FXML
    private void boxBTN(ActionEvent event) {
        menuBTN.setText("Box");
        customFieldTF.setPromptText("gewicht");
        clearFields();
        customFieldTF.setVisible(true);
    }

    @FXML
    private void wireBTN(ActionEvent event) {
        menuBTN.setText("Wire");
        customFieldTF.setPromptText("länge");
        clearFields();
        customFieldTF.setVisible(true);
    }

    @FXML
    private void stageBTN(ActionEvent event) {
        menuBTN.setText("Stage");
        customFieldTF.setPromptText("maße");
        clearFields();
        customFieldTF.setVisible(true);
    }

    @FXML
    private void deskBTN(ActionEvent event) {
        menuBTN.setText("Desk");
        customFieldTF.setPromptText("kanäle");
        clearFields();
        customFieldTF.setVisible(true);
    }

    @FXML
    private void crossbarBTN(ActionEvent event) {
        menuBTN.setText("Crossbar");
        customFieldTF.setPromptText("länge");
        clearFields();
        customFieldTF.setVisible(true);
    }

    @FXML
    private void monitorBTN(ActionEvent event) {
        menuBTN.setText("Monitor");
        customFieldTF.setPromptText("zoll");
        clearFields();
        customFieldTF.setVisible(true);
    }
    
}
