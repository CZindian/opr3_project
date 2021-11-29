package cz.osu.opr3.project.notepadofexcursionist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesService {

    private Map<User, List<Trip>> userNotesMap;

    public void setUserNotesMap(){
        this.userNotesMap = new HashMap<>();
        this.userNotesMap.put(
                new User(), getTrips()
        );
    }

    private List<Trip> getTrips() {

        List<Trip> ret = new ArrayList<>();
        ret.add(
                new Trip(
                        1, Category.CYCLING, "20.11.2021",
                        "1:30:20", 23.5, null,
                );
        )

    }

    private Map<User,List<Trip>> getUserNotesMap(){



    }

}
