package com.example.speedflatmating;

public class Venue implements Comparable<Venue> {

    private String venue, location, cost;
    private String startTime, endTime;
    private String imageUrl;

    public Venue(String cost, String venue, String location, String startTime, String endTime, String imageUrl) {
        this.cost = cost;
        this.venue = venue;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.imageUrl = imageUrl;
    }

    public String getVenue() {
        return venue;
    }

    public String getLocation() {
        return location;
    }

    public String getCost() {
        return cost;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    //This method is to sort the venues by date and time
    @Override
    public int compareTo(Venue o) {
        return getStartTime().compareTo(o.getStartTime());
    }
}
