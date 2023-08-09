package Models;

public class Order {

    private String EventName;
    private int NumberOfTickets;
    private int Totalprice;
    private int imageResourceId;

    public Order(String eventName, int numberOfTickets, int totalprice, int imageResourceId) {
        EventName = eventName;
        NumberOfTickets = numberOfTickets;
        Totalprice = totalprice;
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public Order(String eventName, int numberOfTickets, int totalprice) {
        EventName = eventName;
        NumberOfTickets = numberOfTickets;
        Totalprice = totalprice;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public int getNumberOfTickets() {
        return NumberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        NumberOfTickets = numberOfTickets;
    }

    public int getTotalprice() {
        return Totalprice;
    }

    public void setTotalprice(int totalprice) {
        Totalprice = totalprice;
    }
}
