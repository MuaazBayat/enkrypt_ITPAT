package GUIs;
/*
 * @author muaaz
 */
public class HelpFunctions
{
    //stores help functions in strings which can only be modified in the backend
    private String signUpWalkthroughTxt = "Only enter details if this is your first time using the application. \n"
            + "\n"
            + "Enter your :\n"
            + "\n"
            + "emailaddress in the email address field\n"
            + "\n"
            + "password in the master password field\n"
            + "\n"
            + "exact same password in the confirm password field\n"
            + "\n"
            + "Click : \"Sign Up\" to continue using the application\n"
            + "\n"
            + "OR click \"test\" to see the strenght of your password\n"
            + "\n"
            + "You can make changes to your password and retest until\n"
            + "you are satisifed with your password strength";
    private String needAnExpertTxt = "Call our help centre on :\n"
            + "\n"
            + "079 786 7873\n"
            + "\n"
            + "Working Hours : \n"
            + "Mon - Fri : 8am - 5pm\n"
            + "Sat - Sun: 8am - 2pm ";
    private String howSignUpInterfaceWorks = "The Interface was built to be familiar to all our users,\n"
            + "however here is a breakdown of each of the components.\n"
            + "\n"
            + "Email Address Field:\n"
            + "- this field requires your email adress to be entered\n"
            + "+ it allows all types of characters, letters and symbols\n"
            + "\n"
            + "Master Password Field:\n"
            + "- this field requires your master password to be entered\n"
            + "+ it allows all types of characters, letters and symbols\n"
            + "\n"
            + "Confirm Master Password Field:\n"
            + "- this field requires your  master password to be re-entered\n"
            + "+ it allows all types of characters, letters and symbols\n"
            + "\n"
            + "Test Button: \n"
            + "- clicking the test button will analyse your password and rank\n"
            + "  it on our scale.\n"
            + "The algorithm works as follows:\n"
            + "V.Weak = Only Numbers & Letters & Password Lenght is less than 7 characters\n"
            + "Weak =  Only Numbers & Letters & Password Lenght is more than 7 characters\n"
            + "Okay = Contains Numbers, Letters, Caps & Password Lenght is more than 10 characters\n"
            + "Strong = Contains Numbers, Letters, Caps, s.chars & Password Lenght is more than 10 characters\n"
            + "\n"
            + "Sign Up:\n"
            + "-buttons verify all the entered details and if its correct enters it into the database\n"
            + "";
    private String reportBugsTxt = "Report Bugs: \n"
            + "\n"
            + "Email us on: muaazbayat@gmail.com\n"
            + "\n"
            + "Or contact us at: 079 796 7873";
    private String howLogInInterfaceWorks = "The Interface was built to be familiar to all our users,\n"
            + "however here is a breakdown of each of the components.\n"
            + "\n"
            + "Email Address Field:\n"
            + "- this field requires your email adress that is on the database to be entered\n"
            + "\n"
            + "Master Password Field:\n"
            + "- this field requires your master password to be entered\n"
            + "\n"
            + "Log In:\n"
            + "- buttons verify all the entered details and if its correct logs you into your dashboard\n"
            + "\n"
            + "Sign Up Here:\n"
            + "- takes you to the sign up page where new users can register themselves into the database";
    private String logInWalkthroughTxt = "Only enter details if this is not your first time using the application. \n"
            + "\n"
            + "Enter your :\n"
            + "\n"
            + "emailaddress in the email address field\n"
            + "\n"
            + "password in the master password field\n"
            + "\n"
            + "exact same password in the confirm password field\n"
            + "\n"
            + "Click : \"Log In\" to continue using the application\n"
            + "\n"
            + "OR click \"Sign Up here\" to sign up to create an account";
    private String homeCreateTxt = "To create an entry:\n"
            + "\n"
            + "Click on \"create\" \n"
            + "\n"
            + "(the create screen will open up) \n"
            + "\n"
            + "Enter the websites name into the \"sitename\" field\n"
            + "\n"
            + "Enter the username into the \"username\" field\n"
            + "\n"
            + "Optional: Enter your password into the \"password\" field\n"
            + "\n"
            + "Aleternatively: use the \"generate\" button and we'll fill one in for you!\n"
            + "\n"
            + "To use the password generator: 	Simply, select which attributes\n"
            + " 			you'd like your password to have\n"
            + "			select the max length and click \"generate\"\n"
            + "\n"
            + "To add the entry into the database: click \"create\"\n"
            + "\n"
            + "(the GUI will close and your entry will be created)\n"
            + "(Click \"relaod\" to refresh the table)";
    private String homeHowItWorks = "The password manager store all entries into a table\n"
            + "\n"
            + "The table on your screen is a graphical representation\n"
            + "\n"
            + "(You can view all of your passwords with their associated\n"
            + "attributes in one single table)\n"
            + "\n"
            + "To use these passwords, simply click on the entry in the table\n"
            + "navigate to the desired row and column, copy the data and paste\n"
            + "it into your browser or application\n"
            + "\n"
            + "To view help on the buttons in this screen: \n"
            + "Navigate to them on the left menu in this help screen";
    private String homeEditText = "To Edit an entry: \n"
            + "\n"
            + "Type the desired entry into the \"sitename\" field \n"
            + "		AND\n"
            + "Click \"...\"\n"
            + "\n"
            + "(if the entry exists, the fields will update)\n"
            + "\n"
            + "To Edit these fields :\n"
            + "\n"
            + "Simply click on them and rearrange the text\n"
            + "\n"
            + "To save your edit: \n"
            + "\n"
            + "Click on the \"edit\" button";
    private String homeDeleteText = "To Delete an entry: \n"
            + "\n"
            + "Type the desired entry into the \"sitename\" field \n"
            + "            	                AND\n"
            + "            	           Click \"...\"\n"
            + "\n"
            + "(if the entry exists, the fields will update)\n"
            + "\n"
            + "\n"
            + " To delete the entry: \n"
            + "\n"
            + " Click on the \"delete\" button\n"
            + "";
    
    
    //getter methods so the helpfunctions can be obtained outside the class

    public String getLogInWalkthroughTxt()
    {
        return logInWalkthroughTxt;
    }

    public String getHomeCreateTxt()
    {
        return homeCreateTxt;
    }

    public String getHomeHowItWorks()
    {
        return homeHowItWorks;
    }

    public String getHomeEditText()
    {
        return homeEditText;
    }

    public String getHomeDeleteText()
    {
        return homeDeleteText;
    }

    public String getReportBugsTxt()
    {
        return reportBugsTxt;
    }

    public String getSignUpWalkthroughTxt()
    {
        return signUpWalkthroughTxt;
    }

    public String getNeedAnExpertTxt()
    {
        return needAnExpertTxt;
    }

    public String getHowSignUpInterfaceWorks()
    {
        return howSignUpInterfaceWorks;
    }

    public String getHowLogInInterfaceWorks()
    {
        return howLogInInterfaceWorks;
    }

}
