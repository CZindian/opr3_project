package cz.osu.opr3.project.notepadofexcursionist;

import java.util.Base64;
import java.util.List;

public class Trip {

    private int userId;
    private Category category;
    private String date;
    private String time;
    private double distance;
    private String gpxData;
    private String notes;
    private List<String> places;
    private List<String> pictures;

    public Trip(int userId, Category category, String date,
                String time, double distance, String gpxData,
                String notes, List<String> places,
                List<String> pictures) {

        this.userId = userId;
        this.category = category;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.gpxData = gpxData;
        this.notes = notes;
        this.places = places;
        this.pictures = pictures;
    }

    public int getUserId() {
        return userId;
    }

    public Category getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }

    public String getGpxData() {
        return gpxData;
    }

    public String getNotes() {
        return notes;
    }

    public List<String> getPlaces() {
        return places;
    }

    public List<String> getPictures() {
        return pictures;
    }
}
