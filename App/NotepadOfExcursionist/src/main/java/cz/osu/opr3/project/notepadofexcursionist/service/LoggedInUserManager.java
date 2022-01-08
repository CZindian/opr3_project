package cz.osu.opr3.project.notepadofexcursionist.service;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.utils.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cz.osu.opr3.project.notepadofexcursionist.utils.Validator.isNotEmpty;

public class LoggedInUserManager {


    private static boolean isClientLoggedIn = false;
    private static UserEntity userData;
    //TODO get set??
    private static List<TripEntity> tripData;

    public static void initialize(UserEntity loggedInUserData, List<TripEntity> usersTripData) {
        LoggedInUserManager.userData = loggedInUserData;
        LoggedInUserManager.tripData = usersTripData;
        isClientLoggedIn = true;
    }

    public static UserEntity getUserData() {
        return userData;
    }

    public static void setUserData(UserEntity userData) {
        LoggedInUserManager.userData = userData;
    }

    public static List<TripEntity> getTripData() {
        return tripData;
    }

    public static void setTripData(List<TripEntity> tripData) {
        LoggedInUserManager.tripData = tripData;
    }

    //TODO is logged??
    public static boolean isIsClientLoggedIn() {
        return userData != null && isClientLoggedIn;
    }

    public static void setLogOut() {
        userData = null;
        tripData = null;
        isClientLoggedIn = false;
    }

    public static boolean isSetProfilePicture() {
        isAssigned(userData);
        return !userData.getUserProfilePicture().isEmpty();
    }

    public static String getNameAndSurname() {
        isAssigned(userData);
        return userData.getUserName() + " " + userData.getUserSurname();
    }

    public static String getProfilePicture() {
        isAssigned(userData);
        return userData.getUserProfilePicture();
    }

    public static boolean hasTrips() {
        /*isAssigned(userData);

        if (userData.getTrips() == null)
            return false;
        else return !userData.getTrips().isEmpty();*/

        return isNotEmpty(tripData);
    }

    public static List<String> getListOfTripPlaces(int index) {
        //isAssigned(userData);

/*        if (!hasTrips())
            throw new NullPointerException("Current user has not any trips!");
        else {
            List<String> ret = new ArrayList<>();
            String[] trips = userData.getTrips().get(index).getTripPlaces().split(Constants.TRIP_PLACE_STRING_SEPARATOR);
            Collections.addAll(ret, trips);
            return ret;
        }*/

        if (isNotEmpty(tripData)) {
            List<String> ret = new ArrayList<>();
            String[] trips = tripData.get(index).getTripPlaces().split(Constants.TRIP_PLACE_STRING_SEPARATOR);
            Collections.addAll(ret, trips);
            return ret;
        } else
            throw new NullPointerException("Current user has not any trips!");

    }

    public static List<String> getListOfTripPictures(int index) {
/*        isAssigned(userData);

        if (userData.getTrips().get(index) == null)
            throw new NullPointerException("Current user has not any trip pictures!");
        else {
            List<String> ret = new ArrayList<>();
            String[] trips = userData.getTrips().get(index).getTripPictures().split(Constants.TRIP_PICTURE_BASE_SEPARATOR);
            Collections.addAll(ret, trips);
            return ret;
        }*/

        if (isNotEmpty(tripData)) {
            List<String> ret = new ArrayList<>();
            String[] trips = tripData.get(index).getTripPictures().split(Constants.TRIP_PICTURE_BASE_SEPARATOR);
            Collections.addAll(ret, trips);
            return ret;

        } else
            throw new NullPointerException("Current user has not any trips!");
    }

    private static void isAssigned(UserEntity currentUserDada) {
        if (currentUserDada.getUserProfilePicture() == null)
            throw new NullPointerException("currentUserData attribute was not set up!");
    }

}
