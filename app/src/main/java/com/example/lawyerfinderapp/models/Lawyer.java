package com.example.lawyerfinderapp.models;

public class Lawyer {
    private int id;  // ✅ Add this field
    private String name;
    private String specialty; // Previously "type"
    private int imageResId;
    private float rating;
    private String location;

    // ✅ Update Constructor to include `id`
    public Lawyer(int id, String name, String specialty, int imageResId, float rating, String location) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.imageResId = imageResId;
        this.rating = rating;
        this.location = location;
    }

    public int getId() { // ✅ Add this method
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getImageResId() {
        return imageResId;
    }

    public float getRating() {
        return rating;
    }

    public String getLocation() {
        return location;
    }
}
