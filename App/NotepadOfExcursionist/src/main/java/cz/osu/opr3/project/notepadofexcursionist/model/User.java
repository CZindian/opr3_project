package cz.osu.opr3.project.notepadofexcursionist.model;

public class User {

    private int id;
    private String profilePicture;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthDate;
    private String telephoneNumber;

    public User(int id, String profilePicture, String name, String surname,
                String email, String password, String birthDate, String telephoneNumber) {

        this.id = id;
        this.profilePicture = profilePicture;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.telephoneNumber = telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    private String getBase64StringExample(){
        return "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAKlBMVEXc3Nz////t7e37+/ve3t7l5eXh4eH4+Pjm5uby8vL19fXv7+/p6ena2tpwjZMDAAAEq0lEQVR4nO2d0XajMAxEARswhv7/765JmjYNIYnlAUas7p597xzJ8kg2TlUZhmEYhmEYhmEYhmEYhmEYhmEYhmEYhgp8+nda/EzopqP/jm1JITxxDL85v0LDMAzDMAzjHd38f2qGIcZhbKa27c7lErshhFhfcMOYFIak8EwSx7p39SOuH5pwjkh2/ULdnc7YtNpVdi/0fRMnzSL9e4Ezg958HT5TeNGoU+SnAhOjPok+NB+HcMa1ujS2MUfdlUmRxE6gr9aUqY1InyKJo1SgFoldkCvUsRY/8DEv0GDjZFXmRs/vb9oigWkp";
    }

}
