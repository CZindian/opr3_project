package cz.osu.opr3.project.notepadofexcursionist.service;

import cz.osu.opr3.project.notepadofexcursionist.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrentUserManager {


    private static boolean isClientLoggedIn = false;
    private static UserEntity currentUserDada;

    public static void initialize(UserEntity currentUserData) {
        CurrentUserManager.currentUserDada = currentUserData;
        isClientLoggedIn = true;
    }


    public static UserEntity getCurrentUserDada() {
        return currentUserDada;
    }

    public static void setCurrentUserDada(UserEntity currentUserDada) {
        CurrentUserManager.currentUserDada = currentUserDada;
    }

    public static boolean isIsClientLoggedIn() {
        return currentUserDada != null && isClientLoggedIn;
    }

    public static void setLogOut() {
        currentUserDada = null;
        isClientLoggedIn = false;
    }


    public static boolean isSetProfilePicture() {
        isAssigned(currentUserDada);
        return !currentUserDada.getUserProfilePicture().isEmpty();
    }

    public static String getNameAndSurname() {
        isAssigned(currentUserDada);
        return currentUserDada.getUserName() + " " + currentUserDada.getUserSurname();
    }

    public static String getProfilePicture() {
        isAssigned(currentUserDada);
        return currentUserDada.getUserProfilePicture();
    }

    public static boolean hasTrips() {
        isAssigned(currentUserDada);

        if (currentUserDada.getTrips() == null)
            return false;
        else return !currentUserDada.getTrips().isEmpty();
    }

    public static List<String> getListOfTripPlaces(int index) {
        isAssigned(currentUserDada);

        if (!hasTrips())
            throw new NullPointerException("Current user has not any trips!");
        else {
            List<String> ret = new ArrayList<>();
            String[] trips = currentUserDada.getTrips().get(index).getTripPlaces().split(Constants.TRIP_PLACE_STRING_SEPARATOR);
            Collections.addAll(ret, trips);
            return ret;
        }
    }

    public static List<String> getListOfTripPictures(int index) {
        isAssigned(currentUserDada);

        if (currentUserDada.getTrips().get(index) == null)
            throw new NullPointerException("Current user has not any trip pictures!");
        else {
            List<String> ret = new ArrayList<>();
            String[] trips = currentUserDada.getTrips().get(index).getTripPictures().split(Constants.TRIP_PICTURE_BASE_SEPARATOR);
            Collections.addAll(ret, trips);
            return ret;
        }
    }

    private static void isAssigned(UserEntity currentUserDada) {
        if (currentUserDada.getUserProfilePicture() == null)
            throw new NullPointerException("currentUserData attribute was not set up!");
    }
}
