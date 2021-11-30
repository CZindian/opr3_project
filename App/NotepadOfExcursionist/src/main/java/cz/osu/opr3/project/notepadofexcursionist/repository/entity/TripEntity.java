package cz.osu.opr3.project.notepadofexcursionist.repository.entity;

import cz.osu.opr3.project.notepadofexcursionist.model.Category;
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
    private int tripID;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
    private UserEntity userEntity;

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

}
