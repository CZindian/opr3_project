package cz.osu.opr3.project.notepadofexcursionist.model;

import cz.osu.opr3.project.notepadofexcursionist.db.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.db.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CurrentUser {

    private UserEntity currentUserDada;
    private List<TripEntity> currentUserTrips;

    public CurrentUser(){}

    public CurrentUser(UserEntity currentUserDada, List<TripEntity> currentUserTrips) {
        this.currentUserDada = currentUserDada;
        this.currentUserTrips = currentUserTrips;
    }

}
