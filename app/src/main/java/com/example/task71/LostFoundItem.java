package com.example.task71;

import java.io.Serializable;

public class LostFoundItem implements Serializable {
    public String type; // "Lost" or "Found"
    public String name;
    public String phone;
    public String description;
    public String date;
    public String location;

    public LostFoundItem(String type, String name, String phone, String description, String date, String location) {
        this.type = type;
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    @Override
    public String toString() {
        return (type.equals("Lost") ? "Lost: " : "Found: ") + name;
    }
} 