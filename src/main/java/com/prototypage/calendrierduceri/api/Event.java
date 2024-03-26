package com.prototypage.calendrierduceri.api;

 class Event {
    private final String summary;
    private final String location;
    private final String description;
    private final String startDate;
    private final String endDate;

    public Event(String summary, String location, String description, String startDate, String endDate) {
        this.summary = summary;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSummary() {
        return summary;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}