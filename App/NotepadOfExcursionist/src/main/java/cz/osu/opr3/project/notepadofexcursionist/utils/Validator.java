package cz.osu.opr3.project.notepadofexcursionist.utils;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Validator {

    public static boolean isNotEmpty(List<TripEntity> tripData) {
        if (tripData != null)
            return !tripData.isEmpty();
        else return false;

    }

    public static String reformatTripValue(String tripCategory) {
        checkStringValidity(tripCategory, "tripCategory", "Validator");

        String ret = tripCategory.toLowerCase().trim();
        ret = ret.replace("\\W", "").         // remove whitespaces between words
                replace("\\-", "_");        // & remove '-' and replace by '_'

        return ret;
    }

    private static void checkStringValidity(String tripCategory, String attributeName, String className) {
        if (tripCategory == null)
            throw new IllegalArgumentException("Attribute '" + attributeName + "' in " + className + " received null String!");
        if (tripCategory.isEmpty())
            throw new IllegalArgumentException("Attribute '" + attributeName + "' in " + className + " received empty String!");
    }

    public static String reformatTripCategory(String tripCategory) {
        String ret = tripCategory.replace("_", " ");
        ret = getStringWithCapital(ret);

        return ret;
    }

    public static String getStringWithCapital(String string) {
        char capital = string.toUpperCase().charAt(0);
        string = string.toLowerCase().substring(1);
        string = capital + string;

        return string;
    }

    public static String formatDate(String tripDate, String fromPattern, String toPattern) {
        LocalDate ldt = LocalDate.parse(tripDate, DateTimeFormatter.ofPattern(fromPattern));
        String ret = ldt.format(DateTimeFormatter.ofPattern(toPattern));

        return ret;
    }

}
