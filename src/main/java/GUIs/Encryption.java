package GUIs;

/*
 * @author muaaz
 */
public class Encryption
{
    //Simple encryption method which shifts the ascII chars 5 to the right
    public String encryptField(String inStr)
    {
        String temp = "";
        char[] chars = inStr.toCharArray();
        for (char c : chars)
        {
            c += 5;
            temp = temp + c;
        }
        return temp;

    }
    //Simple decryption method which undoes the encryption by shifting the ascII chars 5 to the left
    public String decryptField(String inStr)
    {
        String temp = "";
        char[] chars = inStr.toCharArray();
        for (char c : chars)
        {
            c -= 5;
            temp = temp + c;
        }
        return temp;

    }
}
