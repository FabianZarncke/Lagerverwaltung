package fabian;

public abstract class Person {
    
    String firstname;
    String lastname;
    int id;

    //constructor for new Person
    public Person(String firstname, String lastname) {
        setFirstname(firstname);
        setLastname(lastname);
        setId(App.generateId());
    }

    //constructor for creation from file
    public Person(String firstname, String lastname, int id) {
        setFirstname(firstname);
        setLastname(lastname);
        setId(id);
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
