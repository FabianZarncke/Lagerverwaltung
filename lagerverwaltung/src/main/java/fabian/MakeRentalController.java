/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabian;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    private ArrayList<Technician> techiChosen = new ArrayList<Technician>();
    private ArrayList<Technology> techChosen = new ArrayList<Technology>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshTechListview();
        refreshTechiListview();
        refreshCusListview();
    }
    
    public void refreshTechListview() {
        technologyListview.getItems().removeAll();
        technologyListview.getItems().clear();
        for(Technology tech : App.getTechnologies()) {
            technologyListview.getItems().add(tech.getClass().getSimpleName() + ": " + tech.getName() + " " + tech.getDescription() + " |is available: " + tech.getAvailable());
        }
    }
    
    public void refreshTechiListview() {
        technicianListview.getItems().removeAll();
        technicianListview.getItems().clear();
        for(Technician techi : App.getTechnicians()) {
            technicianListview.getItems().add(techi.getFirstname() + " " + techi.getLastname() + " " + techi.getDescription());
        }
    }
    
    public void refreshCusListview() {
        customerListview.getItems().removeAll();
        customerListview.getItems().clear();
        for(Customer cus : App.getCustomers()) {
            String type;
            if(cus.getClass().getSimpleName().equals("PrivateCustomer")) {
                type = "PK";
            } else {
                type = "GK";
            }
            customerListview.getItems().add(type + ": " + cus.getFirstname() + " " + cus.getLastname());
        }
    }
    
    public void refreshTechChosenListview() {
        chTechnologyListview.getItems().removeAll();
        chTechnologyListview.getItems().clear();
        for(Technology tech : this.getTechChosen()) {
            chTechnologyListview.getItems().add(tech.getClass().getSimpleName() + ": " + tech.getName() + " " + tech.getDescription() + " |is available: " + tech.getAvailable());
        }
    }
    
    public void refreshTechiChosenListview() {
        chTechnicanListview.getItems().removeAll();
        chTechnicanListview.getItems().clear();
        for(Technician techi : this.getTechiChosen()) {
            chTechnicanListview.getItems().add(techi.getFirstname() + " " + techi.getLastname() + " " + techi.getDescription());
        }
    }

    @FXML
    private void backBTN(ActionEvent event) throws IOException {
        App.setRoot("RentalView");
    }

    @FXML
    private void technicianListviewBTB(MouseEvent event) {
    }

    @FXML
    private void doneBTN(ActionEvent event) throws IOException {
        Rental.Status status = Rental.Status.open;
        if(statusMenu.getText().equals("Offen")) {
            status = Rental.Status.open;
        } else if(statusMenu.getText().equals("Bezahlt")) {
            status = Rental.Status.payed;
        } else if(statusMenu.getText().equals("Storniert")) {
            status = Rental.Status.cancelled;
        }
        
        if(App.getRent() == null) {
            App.getRentals().add(new Rental(App.getCustomers().get(customerListview.getSelectionModel().getSelectedIndex()), techiChosen, techChosen, status, Integer.parseInt(discountTF.getText()), new Date()));
        }
        App.setRoot("RentalView");
    }

    @FXML
    private void addTechnicianBTN(ActionEvent event) {
        techiChosen.add(App.getTechnicians().get(technicianListview.getSelectionModel().getSelectedIndex()));
        refreshTechiChosenListview();
    }

    @FXML
    private void customerListview(MouseEvent event) {
    }

    @FXML
    private void technologyListviewBTN(MouseEvent event) {
    }

    @FXML
    private void addTechnologyBTN(ActionEvent event) {
        techChosen.add(App.getTechnologies().get(technologyListview.getSelectionModel().getSelectedIndex()));
        refreshTechChosenListview();
    }

    @FXML
    private void chTechnicanListviewBTN(MouseEvent event) {
    }

    @FXML
    private void removetechnicianBTN(ActionEvent event) {
        techiChosen.remove(techiChosen.get(chTechnicanListview.getSelectionModel().getSelectedIndex()));
        refreshTechiChosenListview();
    }

    @FXML
    private void chTechnologyListviewBTN(MouseEvent event) {
    }

    @FXML
    private void removeTechnologyBTN(ActionEvent event) {
        techChosen.remove(techChosen.get(chTechnologyListview.getSelectionModel().getSelectedIndex()));
        refreshTechiChosenListview();
    }

    @FXML
    private void statusMenuBTN(MouseEvent event) {
    }

    public List<Technician> getTechiChosen() {
        return techiChosen;
    }

    public void setTechiChosen(ArrayList<Technician> techiChosen) {
        this.techiChosen = techiChosen;
    }

    public List<Technology> getTechChosen() {
        return techChosen;
    }

    public void setTechChosen(ArrayList<Technology> techChosen) {
        this.techChosen = techChosen;
    }

    @FXML
    private void statusPayedBTN(ActionEvent event) {
        statusMenu.setText("Bezahlt");
    }

    @FXML
    private void statusCancelledBTN(ActionEvent event) {
        statusMenu.setText("Storniert");
    }

    @FXML
    private void statusOpenBTN(ActionEvent event) {
        statusMenu.setText("Offen");
    }
    
    
}
