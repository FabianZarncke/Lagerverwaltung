package fabian;

public class Desk extends Technology {
    
    int channels;

    //constructor for new desk
    public Desk(String name, String description, float price, int channels, int shelf, int slot) {
        super(name, description, price, shelf, slot);
        setChannels(channels);
    }

    //constructor for creation from file
    public Desk(String name, String description, float price, int channels, int shelf, int slot, int id) {
        super(name, description, price, shelf, slot, id);
        setChannels(channels);
    }

    public int getChannels() {
        return this.channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

}
