package cz.osu.opr3.project.notepadofexcursionist.service;

import java.util.ArrayList;
import java.util.List;

import cz.osu.opr3.project.notepadofexcursionist.repository.TripDBRepository;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.UserDBRepository;

import static cz.osu.opr3.project.notepadofexcursionist.utils.Validator.isNotEmpty;

public class DBService {

    public static UserEntity getUserEntity(String email, String password) {
        try {
            List<UserEntity> users = new UserDBRepository().findAll();

            for (UserEntity userEntity : users)
                if (userEntity.getUserEmail().equals(email) &&
                        userEntity.getUserPassword().equals(password))
                    return userEntity;
            throw new IllegalArgumentException("Password does not match!");

        } catch (Exception e) {
            throw new IllegalArgumentException("User could not be found!");
        }
    }

    public static List<TripEntity> getUsersTrips(int userId) {
        List<TripEntity> trips = new TripDBRepository().findAll();
        List<TripEntity> usersTrips = new ArrayList<>();

        if (isNotEmpty(trips)) {
            for (TripEntity usersTrip : trips)
                if (usersTrip.getUserId() == userId)
                    usersTrips.add(usersTrip);

        }
        return usersTrips;
    }

    public static void deleteTrip(int tripId) {
        new TripDBRepository().delete(tripId);
    }

    public static TripEntity getTripById(int tripId) {
        TripEntity ret = new TripDBRepository().findById(tripId);
        return ret;
    }

    public static void updateTripEntity(TripEntity tripEntity) {
        new TripDBRepository().update(tripEntity);
    }

    public static void saveNewTrip(
            String title, String category, String date, String time,
            String distance, String notes, String places, String picture,
            UserEntity loggedInUser
    ) {
        TripEntity tripEntity = new TripEntity(
                loggedInUser.getUserId(),
                title, category, date, time,
                distance, notes, places, picture
        );
        new TripDBRepository().create(tripEntity);
    }

}
