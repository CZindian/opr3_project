package cz.osu.opr3.project.notepadofexcursionist.service;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;

import java.util.List;

public class CurrentUserManager {


    private static boolean isClientLoggedIn = false;

    private static UserEntity currentUserDada;
    private static List<TripEntity> currentUserTrips;

    public static UserEntity getCurrentUserDada() {
        return currentUserDada;
    }

    public static void setCurrentUserDada(UserEntity currentUserDada) {
        CurrentUserManager.currentUserDada = currentUserDada;
    }

    public static List<TripEntity> getCurrentUserTrips() {
        return currentUserTrips;
    }

    public static void setCurrentUserTrips(List<TripEntity> currentUserTrips) {
        CurrentUserManager.currentUserTrips = currentUserTrips;
    }

    public static void initialize(UserEntity currentUserData, List<TripEntity> currentUserTrips) {
        CurrentUserManager.currentUserDada = currentUserData;
        CurrentUserManager.currentUserTrips = currentUserTrips;
        isClientLoggedIn = true;

    }

    public static boolean isIsClientLoggedIn() {
        return isClientLoggedIn;
    }

    public static void setLogOut() {
        isClientLoggedIn = false;
    }

    public static boolean isProfilePicture() {
        if(currentUserDada.getUserProfilePicture() == null)
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
}
