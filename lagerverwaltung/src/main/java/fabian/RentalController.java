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
        refreshListview();
    }
    
    public void refreshListview() {
        listview.getItems().removeAll();
        listview.getItems().clear();
        for(Rental rent : App.getRentals()) {
            listview.getItems().add(rent.getId() + " " + rent.getCustomer() + " " + rent.getTechnologies());
        }
    }

    @FXML
    private void homeBTN(ActionEvent event) throws IOException {
        App.setRoot("HomeView");
    }

    @FXML
    private void listviewBTB(MouseEvent event) {
    }

    @FXML
    private void newRentalBTN(ActionEvent event) throws IOException {
        App.setRoot("MakeRentalView");
    }

    @FXML
    private void deleteBTN(ActionEvent event) {
        App.getRentals().remove(App.getRentals().get(listview.getSelectionModel().getSelectedIndex()));
        refreshListview();
    }

    @FXML
    private void payedBTN(ActionEvent event) {
        App.getRentals().get(listview.getSelectionModel().getSelectedIndex()).setStatus(Rental.Status.payed);
    }


    @FXML
    private void editBTN(ActionEvent event) throws IOException {
        App.setRent(App.getRentals().get(listview.getSelectionModel().getSelectedIndex()));
        App.setRoot("MakeRentalView");
    }

    @FXML
    private void printBTN(ActionEvent event) throws IOException {
        PrintService.createPDF(App.getRentals().get(listview.getSelectionModel().getSelectedIndex()));
    }
    
}
