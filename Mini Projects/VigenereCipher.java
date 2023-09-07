import java.io.*;

public class VigenereCipher 
{
    public static void main (String [] args) 
    {
        PrintWriter pen = new PrintWriter(System.out, true);

        // Check that the user has entered the correct number of parameters
        if (args.length != 3) 
        {
            pen.println("Incorrect number of parameters");
        }

        // Check that the plaintext isn't empty
        else if (args[1].equals("")) 
        {
            pen.println("");
        }

        // Check that the keyword isn't empty
        else if (args[2].equals("")) 
        {
            pen.println(args[1]);
        }
        
        // If arg[0] is equal to encode, encode arg[1]
        else if(args[0].equals("encode"))
        {
            encodeVigenereCipher(args[1], args[2]);
        }

        // If arg[0] is equal to decode, decode arg[1]
        else if(args[0].equals("decode"))
        {
           decodeVigenereCipher(args[1], args[2]);
        }

        // Check that the user has entered the correct type of parameters
        else if (!args[1].equals("encode") || !args[1].equals("decode"))
        {
            pen.println("Valid options are \"encode\" or \"decode\"");
        }

    }

    // Helper to make the keyword equal to the length of the plaintext
    public static String keylengthener (String plaintext, String keyword)
    {
        int x = plaintext.length();
        
        for (int i = 0; i < plaintext.length(); i++)
        {
            if (x == i)
            {
                i = 0;
            }
            if (keyword.length() == plaintext.length())
            {
                break;
            }
            keyword += (keyword.charAt(i));
        }
        return keyword;
    }

    // Helper to check that the plaintext doesn't pass the scope (lowercase letters)
    public static int check (int ascii) 
    { 
        if (ascii < 97)
        {
            ascii += 26;
        }
        else if (ascii > 122)
        {
            ascii -= 26;
        }
        return ascii;
    }

    // Helper to encode a plaintext using Vigenere Cipher
    public static void encodeVigenereCipher(String plaintext, String keyword) 
    {
        PrintWriter pen = new PrintWriter(System.out, true);
        keyword = keylengthener(plaintext, keyword);
        String encode = "";

        // Traverse through every letter in the plaintext
        for(int i = 0; i < plaintext.length(); i++)
        {
            int x = (plaintext.charAt(i) + keyword.charAt(i)) % 26;

            // Make letters equal to the ASCII code (lowercase)
            x += 85;
            
            // Call helper check
            x = check(x);
            
            encode += (char) (x);
        }
        pen.println(encode);
    }
 
    // Helper to decode a plaintext using Vigenere Cipher
    public static void decodeVigenereCipher(String plaintext, String keyword) 
    {
        PrintWriter pen = new PrintWriter(System.out, true);
        keyword = keylengthener(plaintext, keyword);
        String decode = "";

        // Traverse through every letter in the plaintext
        for(int i = 0; i < plaintext.length(); i++)
        {
            int x = (plaintext.charAt(i) - keyword.charAt(i)) % 26;

            // Make letters equal to the ASCII code (lowercase)
            x += 97;

            // Call helper check
            x = check(x);

            decode += (char) (x);
        }
        pen.println(decode);
    }
}
