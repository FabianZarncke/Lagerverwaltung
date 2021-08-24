package fabian;

public class Crossbar extends Technology {
    
    double length; //length in meters

    //constructor for new crossbar
    public Crossbar(String name, String description, float price, double length, int shelf, int slot) {
        super(name, description, price, shelf, slot);
        setLength(length);
    }

    //constructor for creation from file
    public Crossbar(String name, String description, float price, double length, int shelf, int slot, int id) {
        super(name, description, price, shelf, slot, id);
        setLength(length);
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
