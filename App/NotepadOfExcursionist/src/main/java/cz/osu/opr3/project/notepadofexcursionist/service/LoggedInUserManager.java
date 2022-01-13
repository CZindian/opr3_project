package cz.osu.opr3.project.notepadofexcursionist.service;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.utils.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cz.osu.opr3.project.notepadofexcursionist.utils.Validator.isNotEmpty;

public class LoggedInUserManager {

    //region Attributes
    private static boolean isClientLoggedIn = false;
    private static boolean isErrorRaised = false;
    private static List<TripEntity> tripData;
    private static TripEntity tripEntityToUpdate;
    private static UserEntity userData;
    //endregion

    public static void initialize(UserEntity loggedInUserData, List<TripEntity> usersTripData) {
        LoggedInUserManager.userData = loggedInUserData;
        LoggedInUserManager.tripData = usersTripData;
        isClientLoggedIn = true;

    }

    public static void clearAllData() {
        setUserData(null);
        setUserData(null);
        setIsClientLoggedIn(false);

    }

    public static void clearTripEntityToUpdate() {
        tripEntityToUpdate = null;
    }

    //region Getters and Setters
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

    public static void setIsClientLoggedIn(boolean isClientLoggedIn) {
        LoggedInUserManager.isClientLoggedIn = isClientLoggedIn;
    }

    public static void setTripEntityToUpdate(TripEntity tripEntityToUpdate) {
        LoggedInUserManager.tripEntityToUpdate = tripEntityToUpdate;
    }

    public static TripEntity getTripEntityToUpdate() {
        return tripEntityToUpdate;
    }

    public static boolean isSetProfilePicture() {
        isAssigned(userData);
        return !userData.getUserProfilePicture().isEmpty();
    }

    public static boolean isIsErrorRaised() {
        return isErrorRaised;
    }

    public static void setIsErrorRaised(boolean isErrorRaised) {
        LoggedInUserManager.isErrorRaised = isErrorRaised;
    }
    //endregion

    //region Adjusted methods for jsp
    public static String getNameAndSurname() {
        isAssigned(userData);
        return userData.getUserName() + " " + userData.getUserSurname();
    }

    public static String getProfilePicture() {
        isAssigned(userData);
        return userData.getUserProfilePicture();
    }

    public static List<String> getListOfTripPlaces(int index) {

        if (isNotEmpty(tripData)) {
            List<String> ret = new ArrayList<>();
            String[] trips = tripData.get(index).getTripPlaces().split(Constants.TRIP_PLACE_STRING_SEPARATOR);

            Collections.addAll(ret, trips);
            return ret;

        } else
            throw new NullPointerException("Current user has not any trips!");

    }

    public static String getTripPicture(int index) {
        if (isNotEmpty(tripData)) {
            String tripPicture = tripData.get(index).getTripPicture();
            return tripPicture;

        } else
            throw new NullPointerException("Current user has not any trips!");

    }
    //endregion

    private static void isAssigned(UserEntity currentUserDada) {
        if (currentUserDada.getUserProfilePicture() == null)
            throw new NullPointerException("currentUserData attribute was not set up!");
    }

    public static boolean hasTrips() {
        return isNotEmpty(tripData);
    }

    public static boolean isIsClientLoggedIn() {
        return userData != null && tripData != null && isClientLoggedIn;
    }

}
