package fabian;

public class Monitor extends Technology {
    
    int inch;

    //constructor for new monitor
    public Monitor(String name, String description, float price, int inch, int shelf, int slot) {
        super(name, description, price, shelf, slot);
        setInch(inch);
    }

    //constructor for creation from file
    public Monitor(String name, String description, float price, int inch, int shelf, int slot, int id) {
        super(name, description, price, shelf, slot, id);
        setInch(inch);
    }

    public int getInch() {
        return this.inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

}
