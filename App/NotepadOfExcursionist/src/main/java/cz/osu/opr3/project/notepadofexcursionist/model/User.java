package cz.osu.opr3.project.notepadofexcursionist;

import java.util.Base64;

public class User {

    private int id;
    private String profilePicture;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthDate;
    private String telephoneNumber;

    public User(){
        this.id = 1;
        this.profilePicture = getBase64StringExample();
        this.name = "Marek";
        this.surname = "Janů";
        this.email = "marek.janu@post.cz";
        this.password = "encode";
        this.birthDate = "12.1.2000";
        this.telephoneNumber = "+420768346897";
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
