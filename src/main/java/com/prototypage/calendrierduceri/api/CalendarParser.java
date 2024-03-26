package com.prototypage.calendrierduceri.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalendarParser {
    public static void main(String[] args) {
        String filePath = "test.ics";
        List<Event> events = parseICalendarFile(filePath);
        for (Event event : events) {
            System.out.println("SUMMARY: " + event.getSummary());
            System.out.println("Location: " + event.getLocation());
            System.out.println("DESCRIPTION: " + event.getDescription());
            System.out.println("Start Date: " + event.getStartDate());
            System.out.println("End Date: " + event.getEndDate());
            System.out.println();
        }
    }

    public static List<Event> parseICalendarFile(String filePath) {
        List<Event> events = new ArrayList<>();
        StringBuilder eventBuilder = new StringBuilder();
        boolean insideEvent = false;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("BEGIN:VEVENT")) {
                    insideEvent = true;
                    eventBuilder = new StringBuilder();
                } else if (line.startsWith("END:VEVENT")) {
                    insideEvent = false;
                    String eventData = eventBuilder.toString();
                    Event event = parseEvent(eventData);
                    events.add(event);
                } else if (insideEvent) {
                    eventBuilder.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    public static Event parseEvent(String eventData) {
        String summary = extractValue(eventData, "SUMMARY;");
        String location = extractValue(eventData, "LOCATION;");
        String description = extractValue(eventData, "DESCRIPTION;");
        String startDate = extractValue(eventData, "DTSTART:");
        String endDate = extractValue(eventData, "DTEND:");
        return new Event(summary, location, description, startDate, endDate);
    }

    private static String extractValue(String eventData, String propertyName) {
        StringBuilder value = new StringBuilder();
        String[] lines = eventData.split("\n");
        boolean propertyFound = false;
        for (String line : lines) {
            if (line.startsWith(propertyName)) {
                propertyFound = true;
                value.append(line.substring(line.indexOf(":") + 1).trim());
            } else if (propertyFound && line.startsWith(" ") || line.startsWith("\t")) {
                value.append(line.trim());
            } else if (propertyFound) {
                break;
            }
        }
        return value.toString();
    }
}
