package fabian;

public abstract class Customer extends Person {
    
    String phonenumber;
    String emailaddress;

    //constructor for new customer
    public Customer(String firstname, String lastname, String phonenumber, String emailaddress) {
        super(firstname, lastname);
        setPhonenumber(phonenumber);
        setEmailaddress(emailaddress);
    }

    //constructor for creation from file
    public Customer(String firstname, String lastname, String phonenumber, String emailaddress, int id) {
        super(firstname, lastname, id);
        setPhonenumber(phonenumber);
        setEmailaddress(emailaddress);
    }

    public boolean isPayed() {
        for(Rental rental : App.getRentals()) {
            if((rental.getCustomer() == this) && rental.getStatus() == Rental.Status.open) {
                return false;
            }
        }
        return true;
    }

    public boolean deleteCustomer() {
        if(isPayed()) {
            App.getCustomers().remove(this);
            return true;
        }
        return false;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailaddress() {
        return this.emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

}