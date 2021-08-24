package fabian;

public class Technician extends Person {

    float wage; //wage per hour
    String description;

    //constructor for new Technician
    public Technician(String firstname, String lastname, float wage, String description) {
        super(firstname, lastname);
        setWage(wage);
        setDescription(description);
    }

    //constructor for creation from file
    public Technician(String firstname, String lastname, float wage, String description,int id) {
        super(firstname, lastname, id);
        setWage(wage);
        setDescription(description);
    }

    public float getWage() {
        return this.wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
