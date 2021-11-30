package cz.osu.opr3.project.notepadofexcursionist.db.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "USER", schema = "PUBLIC")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @Basic
    @Column(name = "USER_PROFILE_PICTURE")
    private String userProfilePicture;

    @Basic
    @Column(name = "USER_NAME")
    private String userName;

    @Basic
    @Column(name = "USER_SURNAME")
    private String userSurname;

    @Basic
    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Basic
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Basic
    @Column(name = "USER_BIRTHDATE")
    private String userBirthDate;

    @Basic
    @Column(name = "USER_TELEPHONE_NUMBER")
    private String userTelephoneNumber;

    /*@OneToMany(mappedBy = "userEntity")
    private List<TripEntity> trips;*/



}
