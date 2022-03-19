package GUIs;
//@muaazbayat

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class programmeFunctions
{

    /*the "containsNumbers()" method checks to see if a string has numbers within it
     */
    public boolean containsNumbers(String inStr)
    {
        String numbers = "0123456789";
        boolean temp = false;

        for (int i = 0; i < numbers.length(); i++)
        {
            if (inStr.indexOf(numbers.charAt(i)) > -1)
            {
                temp = true;
            }
        }
        return temp;
    }

    /*the "containsSpecialCharacters()" method checks to see if a string has special characters within it */
    public boolean containsSpecialCharacters(String inStr)
    {
        String numbers = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        boolean temp = false;

        for (int i = 0; i < numbers.length(); i++)
        {
            if (inStr.indexOf(numbers.charAt(i)) > -1)
            {
                temp = true;
            }
        }
        return temp;
    }

    /*the "containsLetters()" method checks to see if a string has alphabets within it */
    public boolean containsLetters(String inStr)
    {
        String alphas = "abcdefghijklmnopqrstuvwxyz";
        boolean temp = false;

        for (int i = 0; i < alphas.length(); i++)
        {
            if (inStr.indexOf(alphas.charAt(i)) > -1)
            {
                temp = true;
            }
        }
        return temp;
    }

    /*the "containsCapital()" method checks to see if a string has capital letters within it */
    public boolean containsCapital(String inStr)
    {
        String alphas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean temp = false;

        for (int i = 0; i < alphas.length(); i++)
        {
            if (inStr.indexOf(alphas.charAt(i)) > -1)
            {
                temp = true;
            }
        }
        return temp;
    }
     /*the "calcStrength()" method ranks a string based on the diversity of characters*/
    public int calcStrength(String inStr)
    {
        int temp = 0;
        if ((inStr.length() > 15) && (containsNumbers(inStr)) && (containsCapital(inStr)) && (containsLetters(inStr)) && (containsSpecialCharacters(inStr)))
        {
            temp = 5;
        } else
        {
            if ((inStr.length() > 10) && (containsNumbers(inStr)) && (containsCapital(inStr)) && (containsLetters(inStr)))
            {
                temp = 4;
            } else
            {
                if ((inStr.length() > 7) && (containsNumbers(inStr)) && (containsLetters(inStr)))
                {
                    temp = 3;
                } else
                {
                    if ((containsNumbers(inStr)) && (containsLetters(inStr)))
                    {
                        temp = 2;
                    } else
                    {
                        temp = 1;
                    }
                }
            }
        }
        return temp;
    }
 /*the "createEntry()" method inserts an entry into the tblEntries table */
    public void createEntry(String SiteName, String Username, String Password)
    {
        arrUsers obj3 = new arrUsers();
        Encryption encObj =  new Encryption();
        userFunctions obj = new userFunctions();
        try
        {
            ucanaccess obj1 = new ucanaccess();
            obj1.UpdateTable("INSERT INTO tblEntries VALUES ('" + encObj.encryptField(Username) + "','" + encObj.encryptField(Password) + "','" + encObj.encryptField(SiteName) + "','" + encObj.encryptField(obj.getUserEmail()) + "')");
        } catch (SQLException ex)
        {
            Logger.getLogger(userFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 /*the "updateEntryTable()" method updates a record in the tblEntries table */
    public void updateEntryTbl(String inUsername, String inEmail, String inSiteName,String inPassword)
    {
         ucanaccess obj = new ucanaccess();
         Encryption encObj = new Encryption();
         try
        {
            obj.UpdateTable("UPDATE tblEntries SET Username = '"+encObj.encryptField(inUsername)+"',Password = '"+encObj.encryptField(inPassword)+"' WHERE email = '"+encObj.encryptField(inEmail)+"' AND SiteName = '"+encObj.encryptField(inSiteName)+"'");
            
        } catch (SQLException ex)
        {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /*the "deleteEntry()" method deletes a record in the tblEntries table */
     public void deleteEntry(String inEmail, String inSiteName)
    {
         ucanaccess obj = new ucanaccess();
         Encryption encObj = new Encryption();
         try
        {

            obj.UpdateTable("DELETE FROM tblEntries WHERE email = '"+encObj.encryptField(inEmail)+"' AND SiteName = '"+encObj.encryptField(inSiteName)+"'");
            
        } catch (SQLException ex)
        {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 /*the "searchAndGetEntry()" method searches the database for the record with a field value and returns the record */
    public String searchAndGetEntry(String inSiteName, String inUsername)
    {
        String DBsiteName = "", password = "", username = "", error = "";
        String temp = "";
        ucanaccess obj = new ucanaccess();
        Encryption encObj = new Encryption();

        try
        {

            ResultSet rs = obj.ExQuery("SELECT * FROM tblEntries WHERE SiteName = '" + encObj.encryptField(inSiteName) + "' AND email = '" + encObj.encryptField(inUsername) + "'");
            while (rs.next())
            {
                DBsiteName = encObj.decryptField(rs.getString("SiteName"));
                username = encObj.decryptField(rs.getString("Username"));
                password = encObj.decryptField(rs.getString("Password"));

            }
            if (inSiteName.equalsIgnoreCase(DBsiteName))
            {
                temp = username + "#" + password + "#";

            } else
            {
                temp = username + "#" + password + "#" + "PLEASE CHECK THE ENTERED SITENAME: NO ENTRIES FOUND";
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
 /*the "getPassType()" method checks to see which attributes a generated password must have */
    public int getPassType(boolean inSchars, boolean inCaps, boolean inNum)
    {

        int schars = 0;
        int num = 0;
        int caps = 0;
        int passType = 0;
        if (inSchars)
        {
            schars = 1;
        }
        if (inCaps)
        {
            caps = 5;
        }
        if (inNum)
        {
            num = 2;
        }
        passType = schars + num + caps;
        return passType;
    }
 /*the "containsCapital()" method generates a password based on the type needed from the getPassType() method */
    public String generatePass(int passType, int len)
    {

        String passwordGenerated = "";
        switch (passType)
        {
            case 1:
                // code block
                passwordGenerated = generateAlphaChars(len);
                break;
            case 2:
                // code block
                passwordGenerated = generateAlphaNum(len);
                break;
            case 5:
                // code block
                passwordGenerated = generateAlphaCaps(len);
                break;
            case 3:
                // code block
                passwordGenerated = generateAlphaNumChars(len);
                break;
            case 8:
                // code block
                passwordGenerated = generateAlphaCapsNumChars(len);
                break;
            case 6:
                // code block
                passwordGenerated = generateAlphaCharsCaps(len);
                break;
            case 7:
                // code block
                passwordGenerated = generateAlphaNumCaps(len);
                break;

            default:
                // code block
                passwordGenerated = generateAlpha(len);
        }
        return passwordGenerated;

    }
 /*this generate method : creates a random string containing: alphabets + special characters + capitals */
    public String generateAlphaCharsCaps(int len)
    {
        int leftlimit = 58;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
/*this generate method : creates a random string containing: alphabets + special characters */
    public String generateAlphaChars(int len)
    {
        int leftlimit = 58;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .filter(i -> (i < 65 || i > 90))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
/*this generate method : creates a random string containing: alphabets + numbers + capitals  */
    public String generateAlphaNumCaps(int len)
    {
        int leftlimit = 48;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .filter(i -> (i < +57 || i >= 65) && (i <= 90 || i >= 97))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
/*this generate method : creates a random string containing: alphabets + numbers + special characters  */
    public String generateAlphaNumChars(int len)
    {
        int leftlimit = 48;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .filter(i -> (i < 65 || i > 90))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
/*this generate method : creates a random string containing:alphabets + numbers  */
    public String generateAlphaNum(int len)
    {
        int leftlimit = 48;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .filter(i -> (i <= 90 || i >= 97) && (i < 58 || i > 90))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
/*this generate method : creates a random string containing:alphabets + capitals + numbers + special characters  */
    public String generateAlphaCapsNumChars(int len)
    {

        int leftlimit = 48;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
/*this generate method : creates a random string containing: alphabets + capitals + numbers  */
    public String generateAlphaCapsNum(int len)
    {
        int leftlimit = 48;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .filter(i -> (i <= 90 || i >= 97) && (i < 58 || i > 64))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
/*this generate method : creates a random string containing:alphabets + capitals  */
    public String generateAlphaCaps(int len)
    {
        int leftlimit = 65;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .filter(i -> (i <= 90 || i >= 97))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
/*this generate method : creates a random string containing: only alphabets  */
    public String generateAlpha(int len)
    {
        int leftlimit = 97;
        int rightlimit = 122;
        int targetStringLenght = len;
        Random random = new Random();
        String generatedString = random.ints(leftlimit, rightlimit + 1)
                .limit(targetStringLenght)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

}
