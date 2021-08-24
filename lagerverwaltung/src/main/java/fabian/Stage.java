package fabian;

public class Stage extends Technology {
    
    String dimensions;

    //constructor for new stage
    public Stage(String name, String description, float price, String dimensions, int shelf, int slot) {
        super(name, description, price, shelf, slot);
        setDimensions(dimensions);
    }

    //constructor for creation from file
    public Stage(String name, String description, float price, String dimensions, int shelf, int slot, int id) {
        super(name, description, price, shelf, slot, id);
        setDimensions(dimensions);
    }

    public String getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

}
