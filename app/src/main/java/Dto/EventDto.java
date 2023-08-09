package Dto;

import com.google.gson.annotations.SerializedName;

public class EventDto {

    private int eventId;

    private String eventType;


    public EventDto(String eventType, String eventName, String eventDescription, String venue) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.venue = venue;
    }
    public EventDto(int eventId, String eventType, String eventName, String eventDescription, String venue) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.venue = venue;
    }

    public EventDto(String eventName, String eventDescription, String venue) {
        this.eventName=eventName;
        this.eventDescription=eventDescription;
        this.venue=venue;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @SerializedName("activity")
    private String eventName;

    private String eventDescription;

    private String venue;

}
