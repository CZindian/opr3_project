package cz.osu.opr3.project.notepadofexcursionist.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TRIP", schema = "PUBLIC")
@Getter
@Setter
public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIP_ID")
    private int tripId;

    @Basic
    @Column(name = "USER_ID")
    private int userId;

    @Basic
    @Column(name = "TRIP_TITLE")
    private String tripTitle;

    @Basic
    @Column(name = "TRIP_CATEGORY")
    private String tripCategory;

    @Basic
    @Column(name = "TRIP_DATE")
    private String tripDate;

    @Basic
    @Column(name = "TRIP_TIME")
    private String tripTime;

    @Basic
    @Column(name = "TRIP_DISTANCE")
    private String tripDistance;

    @Basic
    @Column(name = "TRIP_NOTES")
    private String tripNotes;

    @Basic
    @Column(name = "TRIP_PLACES")
    private String tripPlaces;

    @Basic
    @Column(name = "TRIP_PICTURES")
    private String tripPicture;

    public TripEntity() {
    }

    public TripEntity(int userId, String tripTitle, String tripCategory,
                      String tripDate, String tripTime, String tripDistance,
                      String tripNotes, String tripPlaces, String tripPicture) {

        this.userId = userId;
        this.tripTitle = tripTitle;
        this.tripCategory = tripCategory;
        this.tripDate = tripDate;
        this.tripTime = tripTime;
        this.tripDistance = tripDistance;
        this.tripNotes = tripNotes;
        this.tripPlaces = tripPlaces;
        this.tripPicture = tripPicture;
    }
}
