package GUIs;
/*
 * @author muaaz
 */
public class completeUser extends User
{
    //complete user inherits the user attributes
    //and has the following
    protected String name;
    protected String surname;
    protected String phonenumber;

    
    //paramatised constructor
    public completeUser(String email, String masterpassword, String level, String phoneNumber, String name, String surname)
    {
        super(email, masterpassword, level);
        this.phonenumber = phoneNumber;
        this.name = name;
        this.surname = surname;
    }

    //getters for the name, surname and phone Number
    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }
    
    //simple toString
    public String toString()
    {
        String temp;
        temp = super.toString();
        temp = temp + "~" + name + "~" + surname + "~" + phonenumber;
        return temp;
    }

}
