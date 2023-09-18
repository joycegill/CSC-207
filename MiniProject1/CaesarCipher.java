package MiniProject1;

import java.io.*;

public class CaesarCipher 
{
    public static void main (String [] args) 
    {
        PrintWriter pen = new PrintWriter(System.out, true);

        // Check that the user has entered the correct number of parameters
        if (args.length != 2) 
        {
            pen.println("Incorrect number of parameters");
        }
        
        // If arg[0] is equal to encode, encode arg[1]
        else if(args[0].equals("encode"))
        {
            encodeCaesarCipher(args[1]);
        }

        // If arg[0] is equal to decode, decode arg[1]
        else if(args[0].equals("decode"))
        {
            decodeCaesarCipher(args[1]);
        }

        // Check that the user has entered the correct type of parameters
        else if (!args[1].equals("encode") || !args[1].equals("decode"))
        {
            pen.println("Valid options are \"encode\" or \"decode\"");
        }

    }

    // Helper to check that the plaintext doesn't pass the scope (lowercase letters)
    public static char check (char ascii) 
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
    
    // Helper to encode a plaintext using Caesar Cipher
    public static void encodeCaesarCipher(String plaintext) 
    {
        PrintWriter pen = new PrintWriter(System.out, true);
        String encode;
        char[] result = new char[plaintext.length()];

        // Encrypt using every letter of the alphabet
        for (int i = 0; i <= 25; i++)
        {
            for (int j = 0; j < plaintext.length(); j++)
            {       
                char ch = (char)(((int)plaintext.charAt(j) + i - 97) % 26 + 97);
                
                // Call helper check
                ch = check(ch);

                result[j] = ch;
            }
            // Conver result to string & print
            encode = new String(result);
            pen.printf("n = %d: %s", i, encode);
            pen.println();
        }
    }

    // Helper to decode a plaintext using Caesar Cipher
    public static void decodeCaesarCipher(String plaintext) 
    {
        PrintWriter pen = new PrintWriter(System.out, true);
        String decode;
        char[] result = new char[plaintext.length()];
        
        // Decrypt using every letter of the alphabet
        for (int i = 0; i <= 25; i++)
        {
            for (int j = 0; j < plaintext.length(); j++)
            {       
                char ch = (char) (((int)plaintext.charAt(j) - i - 97) % 26 + 97);
                
                // Call helper check
                ch = check(ch);

                result[j] = ch;
            }
            // Conver result to string & print
            decode = new String(result);
            pen.printf("n = %d: %s", i, decode);
            pen.println();
        }
    }
}
