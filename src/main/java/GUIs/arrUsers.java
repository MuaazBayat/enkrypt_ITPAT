/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muaaz
 */
public class arrUsers
{

    protected completeUser[] arrUsers = new completeUser[100];
    private int size = 0;
    private int userPos =0;

    public arrUsers()
    {
        ucanaccess obj = new ucanaccess();
        try
        {
            Encryption encObj = new  Encryption();
            ResultSet rs = obj.ExQuery("SELECT * FROM tblUsers");
            String email, mpassword, level, phoneNumber, firstname, surname;
            
            while (rs.next())
            {
                email = encObj.decryptField(rs.getString("emailaddress"));
                mpassword = encObj.decryptField(rs.getString("masterpassword"));
                level = encObj.decryptField(rs.getString("level"));
               
                if (!(encObj.decryptField(rs.getString("phoneNumber")).equals("-")))
                {
                    phoneNumber = encObj.decryptField(rs.getString("phoneNumber"));
                    firstname = encObj.decryptField(rs.getString("firstname"));
                    surname = encObj.decryptField(rs.getString("surname"));
                    arrUsers[size] = new completeUser(email, mpassword, level, phoneNumber, firstname, surname);
                } else
                {
                    arrUsers[size] = (completeUser) new User(email, mpassword, level);
                }
                size++;
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String toString()
    {
        String temp = "";
        for (int loop = 0; loop < size; loop++)
        {
            temp = temp + arrUsers[loop] + "\n";
        }
        return temp;
    }

    public void setUserPos(int userPos)
    {
        this.userPos = userPos;
    }
    public int getUserPos()
    {
        return userPos;
    }

    public int SearchUsers(String inStr)
    {
        for (int i = 0; i < arrUsers.length; i++)
        {
            if (arrUsers[i].getEmail().equals(inStr))
            {
                return i;
            }
        }
        return -1;
    }

}
