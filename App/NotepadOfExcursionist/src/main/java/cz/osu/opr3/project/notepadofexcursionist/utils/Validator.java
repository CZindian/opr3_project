package cz.osu.opr3.project.notepadofexcursionist.utils;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;

import java.util.List;

public class Validator {

    public static boolean isNotEmpty(List<TripEntity> tripData) {
        if (tripData != null)
            return !tripData.isEmpty();
        else return false;
    }

    public static String reformat(String tripCategory) {
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

}
