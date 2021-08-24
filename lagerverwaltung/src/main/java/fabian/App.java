package fabian;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static ArrayList<Technician> technicians = new ArrayList<Technician>();
    static ArrayList<Technology> technologies = new ArrayList<Technology>();
    static ArrayList<Rental> rentals = new ArrayList<Rental>(); 

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("HomeView"), 1280, 800);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
        
        customers.add(new PrivateCustomer("John", "Wick", "58456475435564", "john-wick@gmail.com"));
        customers.add(new PrivateCustomer("Tony", "Stark", "73289365234", "tony-stark@gmail.com"));
        customers.add(new PrivateCustomer("Jan", "Mustermann", "2635243425", "jan@gmail.com"));
        technologies.add(new Box("Dolby", "8k box", (float) 20.00, 20.00, 3, 4, App.generateId()));
        technicians.add(new Technician("John", "Snow", (float) 10.00, "lion ist ein kek"));
        rentals.add(new Rental(customers.get(0), technicians, technologies, Rental.Status.open, 10, new Date()));
        

        //ReadService.readCustomer();
        /*
        try {
            WriteService.writeCustomer(customers.get(0));
            WriteService.writeRental(rentals.get(0));
            WriteService.writeCustomer(customers.get(1));
            WriteService.writeCustomer(customers.get(2));
            WriteService.writeTechnician(technicians.get(0));
            WriteService.writeTechnology(technologies.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        /*
        ReadService.readAll();
        System.out.println(customers);
        System.out.println(technicians);
        System.out.println(technologies);
        System.out.println(rentals);
        */

        for(Rental rental: App.getRentals()){
            try{
                PrintService.createPDF(rental);
            }catch (IOException e) {
                System.out.println("test");
            }
            
        }

        System.out.println("Hello World!");
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static int generateId() {
        int id = ThreadLocalRandom.current().nextInt(1, 999999999 + 1);
        for (Rental rental : rentals) {
            if (rental.getId() == id) {
                return generateId();
            }
        }
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return generateId();
            }
        }
        for (Technology technology : technologies) {
            if (technology.getId() == id) {
                return generateId();
            }
        }
        for (Technician technician : technicians) {
            if (technician.getId() == id) {
                return generateId();
            }
        }
        return id;
    }

    public static ArrayList<Customer> getCustomers() {
        return App.customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        App.customers = customers;
    }

    public static ArrayList<Technology> getTechnologies() {
        return App.technologies;
    }

    public static void setTechnologies(ArrayList<Technology> technologies) {
        App.technologies = technologies;
    }

    public static ArrayList<Rental> getRentals() {
        return App.rentals;
    }

    public static void setRentals(ArrayList<Rental> rentals) {
        App.rentals = rentals;
    }

    public static ArrayList<Technician> getTechnicians() {
        return App.technicians;
    }

    public static void setTechnicians(ArrayList<Technician> technicians) {
        App.technicians = technicians;
    }
    
}