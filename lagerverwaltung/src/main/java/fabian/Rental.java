package fabian;

import java.util.ArrayList;
import java.util.Date;

public class Rental {
    
    enum Status {open, payed, cancelled}

    Customer customer;
    ArrayList<Technician> technicians = new ArrayList<Technician>();
    ArrayList<Technology> technologies = new ArrayList<Technology>();
    Status status;
    int discount; //discount in percent
    int id;
    Date date;

    //constructor for new rental
    public Rental(Customer customer, ArrayList<Technician> technicians, ArrayList<Technology> technologies, Status status, int discount, Date date) {
        setCustomer(customer);
        setTechnicians(technicians);
        setTechnologies(technologies);
        setStatus(status);
        setDiscount(discount);
        setId(App.generateId());
        setDate(date);
    }

    //constructor fro creation from file
    public Rental(Customer customer, ArrayList<Technician> technicians, ArrayList<Technology> technologies, Status status, int discount, int id, Date date) {
        setCustomer(customer);
        setTechnicians(technicians);
        setTechnologies(technologies);
        setStatus(status);
        setDiscount(discount);
        setId(id);
        setDate(date);
    }

    public float calcPrice() {
        float totalPrice = 0;
        for(Technology tech : technologies) {
            totalPrice += tech.getPrice();
        }
        totalPrice -= totalPrice / 100 * discount;
        return totalPrice;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Technician> getTechnicians() {
        return this.technicians;
    }

    public void setTechnicians(ArrayList<Technician> technicians) {
        this.technicians = technicians;
    }

    public ArrayList<Technology> getTechnologies() {
        return this.technologies;
    }

    public void setTechnologies(ArrayList<Technology> technologies) {
        this.technologies = technologies;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

}
