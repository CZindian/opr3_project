package cz.osu.opr3.project.notepadofexcursionist.service;

import cz.osu.opr3.project.notepadofexcursionist.db.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.db.entity.UserEntity;

import java.util.List;
import java.util.Map;

public class NotepadManager {

    private static boolean isClientLoggedIn = false;
    private static Map<UserEntity, List<TripEntity>> userNotesMap;


    public static void setIsClientLoggedIn(boolean value) {
        isClientLoggedIn = value;
    }

    public static Map<UserEntity, List<TripEntity>> getUserNotesMap() {
        return userNotesMap;
    }

    public static void setUserNotesMap(Map<UserEntity, List<TripEntity>> userNotesMap) {
        NotepadManager.userNotesMap = userNotesMap;
    }

    public static boolean isIsClientLoggedIn() {
        return isClientLoggedIn;
    }

    /*    public void setUserNotesMap(){
        this.userNotesMap = new HashMap<>();
        this.userNotesMap.put(
                new User(), getTrips()
        );
    }

    private List<Trip> getTrips() {

        List<Trip> ret = new ArrayList<>();
        ret.add(
                new Trip(
                        1, "Výlet na Javorový", Category.CYCLING, "20.11.2021",
                        "1:30:20", 23.5, null, "Moje úžasné poznámky k výletu",
                        getTestPlacesPictures(), new ArrayList<>().add("")
                );
        )

    }

    private List<String> getTestPlacesPictures() {
        List<String> ret = new ArrayList<>();

    }

    private Map<User,List<Trip>> getUserNotesMap(){



    }*/

}
