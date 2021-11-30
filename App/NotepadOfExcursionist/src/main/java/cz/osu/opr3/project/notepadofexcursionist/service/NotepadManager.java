package cz.osu.opr3.project.notepadofexcursionist.service;

public class NotepadManager {

    private static boolean isClientLoggedIn = false;

    public static boolean isIsClientLoggedIn() {
        return isClientLoggedIn;
    }

    public static void setIsClientLoggedIn(boolean value) {
        isClientLoggedIn = value;
    }


}
