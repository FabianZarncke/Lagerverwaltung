package fabian;

public class BusinessCustomer extends Customer {

    String company;
    String address;

    public BusinessCustomer(String firstname, String lastname, String phonenumber, String emailaddress, String address, String company) {
        super(firstname, lastname, phonenumber, emailaddress);
        setCompany(company);
        setAddress(address);
    }

    public BusinessCustomer(String firstname, String lastname, String phonenumber, String emailaddress, String address, String company, int id) {
        super(firstname, lastname, phonenumber, emailaddress, id);
        setCompany(company);
        setAddress(address);
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
