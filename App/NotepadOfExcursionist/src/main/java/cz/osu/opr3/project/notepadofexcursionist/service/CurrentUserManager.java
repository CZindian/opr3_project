package cz.osu.opr3.project.notepadofexcursionist.service;

import cz.osu.opr3.project.notepadofexcursionist.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrentUserManager {


    private static boolean isClientLoggedIn = false;

    private static UserEntity currentUserDada;

    public static UserEntity getCurrentUserDada() {
        return currentUserDada;
    }

    public static void setCurrentUserDada(UserEntity currentUserDada) {
        CurrentUserManager.currentUserDada = currentUserDada;
    }

    public static void initialize(UserEntity currentUserData) {
        CurrentUserManager.currentUserDada = currentUserData;
        isClientLoggedIn = true;

    }

    public static void update(UserEntity currentUserData) {
        CurrentUserManager.currentUserDada = currentUserData;

    }

    public static boolean isIsClientLoggedIn() {
        return isClientLoggedIn;
    }

    public static void setLogOut() {
        isClientLoggedIn = false;
    }

    public static boolean isProfilePicture() {
        if (currentUserDada.getUserProfilePicture() == null)
            throw new NullPointerException("currentUserData was not set up!");
        else return !currentUserDada.getUserProfilePicture().isEmpty();
    }

    public static String getNameSurname() {
        if (currentUserDada.getUserName() == null || currentUserDada.getUserSurname() == null)
            throw new NullPointerException("currentUserData was not set up!");
        else return currentUserDada.getUserName() + " " + currentUserDada.getUserSurname();
    }

    public static String getProfilePicture() {
        if (!isProfilePicture())
            throw new NullPointerException("currentUserData was not set up!");
        else return currentUserDada.getUserProfilePicture();
    }

    public static boolean hasTrips() {
        if (currentUserDada == null)
            throw new NullPointerException("currentUserData was not set up!");
        else if (currentUserDada.getTrips() == null)
            return false;
        else return !currentUserDada.getTrips().isEmpty();
    }

    public static List<String> getListOfTripPlaces(int index) {
        if (currentUserDada == null)
            throw new NullPointerException("currentUserData was not set up!");

        else {
            if (!hasTrips())
                throw new NullPointerException("current user has not any trips!");
            else {
                List<String> ret = new ArrayList<>();
                String[] trips = currentUserDada.getTrips().get(index).getTripPlaces().split(Constants.TRIP_PLACE_STRING_SEPARATOR);
                Collections.addAll(ret, trips);

                return ret;
            }

        }
    }

    public static List<String> getListOfTripPictures(int index) {
        if (currentUserDada == null)
            throw new NullPointerException("currentUserData was not set up!");

        else {
            if (currentUserDada.getTrips().get(index) == null)
                throw new NullPointerException("current user has not any trip pictures!");
            else {
                List<String> ret = new ArrayList<>();
                String[] trips = currentUserDada.getTrips().get(index).getTripPictures().split(Constants.TRIP_PICTURE_BASE_SEPARATOR);
                Collections.addAll(ret, trips);

                return ret;
            }

        }
    }
}
