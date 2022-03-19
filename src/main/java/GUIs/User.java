package GUIs;

/*
 * @author muaaz
 */
public class User {
    //attributes which a user has
    private String email, masterpassword,level;
    //constructor (parametised)
    public User(String email, String password, String level) {
        this.email = email;
        this.masterpassword = password;
        this.level = level;
    }
    //getter for the email
    public String getEmail() {
        return email;
    }

    @Override
    //simple toString
    public String toString() {
        return email + "~" + masterpassword + "~" + level;
    }
}
