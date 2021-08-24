package fabian;

public class Box extends Technology {
    
    double weight; //weight in kg

    //constructor for new box
    public Box(String name, String description, float price, double weight, int shelf, int slot) {
        super(name, description, price, shelf, slot);
        setWeight(weight);
    }

    //constructor for creation from file
    public Box(String name, String description, float price, double weight, int shelf, int slot, int id) {
        super(name, description, price, shelf, slot, id);
        setWeight(weight);
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
