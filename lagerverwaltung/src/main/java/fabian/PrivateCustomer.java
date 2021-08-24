package fabian;

public class PrivateCustomer extends Customer {

    public PrivateCustomer(String firstname, String lastname, String phonenumber, String emailaddress) {
        super(firstname, lastname, phonenumber, emailaddress);
    }

    public PrivateCustomer(String firstname, String lastname, String phonenumber, String emailaddress, int id) {
        super(firstname, lastname, phonenumber, emailaddress, id);
    }
}
