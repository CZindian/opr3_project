package cz.osu.opr3.project.notepadofexcursionist.db.entity;

import cz.osu.opr3.project.notepadofexcursionist.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TRIP", schema = "PUBLIC")
public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIP_ID")
    private int tripID;

    @Basic
    @Column(name = "TRIP_TITLE")
    private String tripTitle;

    @Basic
    @Column(name = "TRIP_CATEGORY")
    private Category tripCategory;

    @Basic
    @Column(name = "TRIP_DATE")
    private String tripDate;

    @Basic
    @Column(name = "TRIP_TIME")
    private String tripTime;

    @Basic
    @Column(name = "TRIP_DISTANCE")
    private double tripDistance;

    @Basic
    @Column(name = "TRIP_GPX_DATA")
    private String tripGpxData;

    @Basic
    @Column(name = "TRIP_NOTES")
    private String tripNotes;

    @Basic
    @Column(name = "TRIP_PLACES")
    private String tripPlaces;

    @Basic
    @Column(name = "TRIP_PICTURES")
    private String tripPictures;

    /*@ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;*/

}
