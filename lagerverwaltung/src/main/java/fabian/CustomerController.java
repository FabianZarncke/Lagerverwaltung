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
public class CustomerController implements Initializable {

    @FXML
    private Button homeBTN;
    @FXML
    private ListView<String> listview;
    @FXML
    private MenuButton menuBTN;
    @FXML
    private TextField firstnameTF;
    @FXML
    private TextField lastnameTF;
    @FXML
    private TextField phonenumberTF;
    @FXML
    private TextField emailaddressTF;
    @FXML
    private TextField companyTF;
    @FXML
    private TextField addressTF;
    @FXML
    private Button doneBTN;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button newCusBTN;
    @FXML
    private MenuItem privateCustomerBTN;
    @FXML
    private MenuItem businessCustomerBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshListview();
        
        menuBTN.setText("Privatkunde");
        companyTF.setVisible(false);
        addressTF.setVisible(false);
    }
    
    public void refreshListview() {
        listview.getItems().removeAll();
        listview.getItems().clear();
        for(Customer cus : App.getCustomers()) {
            String type;
            if(cus.getClass().getSimpleName().equals("PrivateCustomer")) {
                type = "PK";
            } else {
                type = "BK";
            }
            listview.getItems().add(type + ": " + cus.getFirstname() + " " + cus.getLastname());
        }
    }

    @FXML
    private void homeBTN(ActionEvent event) throws IOException {
        App.setRoot("HomeView");
    }

    @FXML
    private void menuBTN(ActionEvent event) {
    }

    @FXML
    private void doneBTN(ActionEvent event) {
    }

    @FXML
    private void deleteBTN(ActionEvent event) {
        App.getCustomers().remove(App.getCustomers().get(listview.getSelectionModel().getSelectedIndex()));
        refreshListview();
    }

    @FXML
    private void listviewBTB(MouseEvent event) {
    }

    @FXML
    private void newCusBTN(ActionEvent event) {
        firstnameTF.setText("");
        lastnameTF.setText("");
        phonenumberTF.setText("");
        emailaddressTF.setText("");
        companyTF.setText("");
        addressTF.setText("");
        listview.getSelectionModel().clearSelection();
    }

    @FXML
    private void privateCustomerBTN(ActionEvent event) {
        menuBTN.setText("Privatkunde");
        companyTF.setVisible(false);
        addressTF.setVisible(false);
    }

    @FXML
    private void businessCustomerBTN(ActionEvent event) {
        menuBTN.setText("Geschäftskunde");
        companyTF.setVisible(true);
        addressTF.setVisible(true);
    }
    
}
