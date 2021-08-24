package fabian;

public abstract class Technology {

    String name;
    String description;
    float price;
    int shelf;
    int slot;
    boolean available;
    int id;

    //constructor for new technology
    public Technology(String name, String description, float price, int shelf, int slot) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setShelf(shelf);
        setSlot(slot);
        setAvailable(true);
        setId(App.generateId());
    }

    //constructor for creation from file
    public Technology(String name, String description, float price, int shelf, int slot, int id) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setShelf(shelf);
        setSlot(slot);
        setAvailable(true);
        setId(id);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getShelf() {
        return this.shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
