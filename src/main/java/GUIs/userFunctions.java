package GUIs;
//@muaazbayat

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class userFunctions
{

    private int userPos;

    /* the  "authenticate" method verifies the users login details. 
       It returns a boolean flag as to whether the details correspond with that
       which is in the database.
     */
    public boolean authenticate(String inEmail, String inMPass)
    {
        /*the method instantiates a temp bolean which is a flag.
        a resultSet object is created and a loop goes through the resultSet, 
        searching for a match between the email that the user enters (parameter).
        
        if the match is found and the second parameter (password) is correct, 
        the flag will be true.
        
        if either the email is not found or the password does not match,
        the flag will return false.
         */
        boolean temp = false;
        try
        {
            Encryption encObj = new Encryption();
            ucanaccess obj = new ucanaccess();
            ResultSet rs = obj.ExQuery("SELECT * FROM tblUsers");
            String email, masterpassword, level, phoneNumber, name, surname;
            while (rs.next())
            {
                email = encObj.decryptField(rs.getString("emailaddress"));
                masterpassword = encObj.decryptField(rs.getString("masterpassword"));
                level = rs.getString("level");
                phoneNumber = encObj.decryptField(rs.getString("phoneNumber"));
                name = encObj.decryptField(rs.getString("firstname"));
                surname = encObj.decryptField(rs.getString("surname")) ;

                if ((inEmail.equalsIgnoreCase(email)) && (inMPass.equals(masterpassword)))
                {
                    temp = true;
                }
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    /* the "isFieldBlank()" method checks if a field is blank
     */
    public boolean isFieldBlank(String inStr, String inStr1, String inStr2)
    {
        //using
        boolean temp = false;

        if (inStr.equals("") || inStr1.equals("") || inStr2.equals(""))
        {
            temp = true;
        } else
        {
            temp = false;
        }
        return temp;
    }

    /* the "doesUsernameExist()" method checks if the userEmail exists already
     */
    public boolean doesUsernameExist(String inStr)
    {
        //using
        boolean temp = false;
        try
        {
            Encryption encObj = new Encryption();
            ucanaccess obj = new ucanaccess();
            ResultSet rs = obj.ExQuery("SELECT * FROM tblUsers");
            String email, masterpassword, level, phoneNumber, name, surname;
            while (rs.next())
            {
                email = encObj.decryptField(rs.getString("emailaddress"));
                if (email.equalsIgnoreCase(inStr))
                {
                    temp = true;
                }
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;

    }

    /* the "doPasswordsMatch()" method checks if the passwords entered match
     */
    public boolean doPasswordsMatch(String inP1, String inP2)
    {
        //using
        boolean temp;

        temp = inP1.equals(inP2);

        return temp;
    }

    /*the verifyDetails() method performs the neccessary validations returning a flag value if they all are met*/
    public boolean verifyDetails(String inEmail, String inP1, String inP2)
    {
        //using
        boolean temp = false;
        if ((isFieldBlank(inEmail, inP1, inP2) == false) && (doesUsernameExist(inEmail) == false) && (doPasswordsMatch(inP1, inP2)))
        {
            temp = true;
        }

        return temp;
    }


    /*the createUser() method inserts the relevant data read in from parameters into the database*/
    public void createUser(String inEmail, String inMasterPassword)
    {
        Encryption encObj = new Encryption();
        //using
        try
        {
            ucanaccess obj = new ucanaccess();
            obj.UpdateTable("INSERT INTO tblUsers VALUES ('" + encObj.encryptField(inMasterPassword) + "', '" + encObj.encryptField(inEmail) + "'  , 'incomplete', '-', '-','-')");
        } catch (SQLException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /*the signUserIn() method writes the users data into the userdata.txt text file*/
    public void signUserIn(String inEmail)
    {
        //using
        PrintWriter outFile = null;
        try
        {
            arrUsers obj = new arrUsers();
           // System.out.println(obj.SearchUsers(inEmail));
            outFile = new PrintWriter(new FileWriter("userdata.txt"));
            outFile.print(obj.arrUsers[obj.SearchUsers(inEmail)].toString());
            outFile.close();
        } catch (IOException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            outFile.close();
        }
    }
    /*the getUserEmail()method gets the users eamil from the userdata.txt textfile*/
    public String getUserEmail()
    {
        String email = "";
        String Line = "";
        try
        {
            Scanner scFile = new Scanner(new File("userdata.txt"));
            while (scFile.hasNext())
            {
                Line = scFile.nextLine();
                Scanner scLine = new Scanner(Line).useDelimiter("~");
                email = scLine.next();
                scLine.close();
            }
            scFile.close();
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return email;
    }
 /*the "updateEntryTable()" method updates a record in the tblEntries table */
    public void updateUserTbl(String inName, String inSurname, String inEmail,String inPhoneNumber)
    {
         ucanaccess obj = new ucanaccess();
         Encryption encObj = new Encryption();
         try
        {
            obj.UpdateTable("UPDATE tblUsers SET emailaddress = '"+encObj.encryptField(inEmail)+"',phoneNumber = '"
                    +encObj.encryptField(inPhoneNumber)+"',firstname = '"
                    +encObj.encryptField(inName)+"',surname = '"
                    +encObj.encryptField(inSurname)+"' WHERE emailaddress = '"
                    +encObj.encryptField(inEmail)+"'");
            
        } catch (SQLException ex)
        {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*the signPos()method writes the users position into the userpos.txt textfile*/
    public void signPos(String inEmail)
    {
        
        PrintWriter outFile = null;
        try
        {
            arrUsers obj = new arrUsers();
            outFile = new PrintWriter(new FileWriter("userpos.txt"));
            outFile.print(obj.SearchUsers(inEmail));
            outFile.close();
        } catch (IOException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            outFile.close();
        }
    }
/*the getUserPos()method gets the users position from the userpos.txt textfile*/
    public int getUserPosition()
    {
        int temp = 0;
        try
        {
            Scanner sc = new Scanner(new File("userpos.txt"));
            while (sc.hasNext())
            {

                temp = sc.nextInt();
            }
                sc.close();

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
}
