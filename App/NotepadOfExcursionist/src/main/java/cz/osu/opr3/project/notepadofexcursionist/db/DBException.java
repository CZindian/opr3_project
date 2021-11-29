package cz.osu.opr3.project.notepadofexcursionist.db;

public class DBException extends RuntimeException {

    public DBException(String message, Exception cause){
        super(message, cause);
    }

}
