package Models;

public class Event {

    private String EventName;
    private String EventDescription;
    private int imageResourceId;

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public Event(String eventName, String eventDescription, int imageResourceId, String venue) {
        EventName = eventName;
        EventDescription = eventDescription;
        this.imageResourceId = imageResourceId;
        Venue = venue;
    }

    public Event(String eventName, String eventDescription, String venue) {
        EventName = eventName;
        EventDescription = eventDescription;
        Venue = venue;
    }

    public String getEventName() {
        return EventName;
    }

    public Event(String eventName, int festival2) {
        EventName = eventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    private String Venue;
}
