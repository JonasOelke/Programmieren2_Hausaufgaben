package de.haw_hamburg.dailymanager;

import java.util.Calendar;

public class Event implements java.io.Serializable{

    private Calendar time;
    private String name;
    private String location;
    private String note;
    private String reminder;

    public Event(Calendar time, String name, String location, String note, String reminder) {
        this.time = time;
        this.name = name;
        this.location = location;
        this.note = note;
        this.reminder = reminder;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        String string =  "Event{" +
                "time=" + time +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", note='" + note + '\'' +
                ", reminder='" + reminder + '\'' +
                '}';
        return string;
    }
}
