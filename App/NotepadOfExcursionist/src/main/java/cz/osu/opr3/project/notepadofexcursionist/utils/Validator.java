package cz.osu.opr3.project.notepadofexcursionist.utils;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;

import java.util.List;

public class Validator {

    public static boolean isNotEmpty(List<TripEntity> tripData) {
        if (tripData != null)
            return !tripData.isEmpty();
        else return false;
    }

}
