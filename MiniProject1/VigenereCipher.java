package MiniProject1;

import java.io.*;

/**
 * Allows users to encode and decode text through the Vigenere Cipher. 
 * 
 * @author Joyce Gill
 */

public class VigenereCipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Check that the user has entered the correct number of parameters
    if (args.length != 3) {
      pen.println("Incorrect number of parameters");
    }

    // Check that the plaintext isn't empty
    else if (args[1].equals("")) {
      pen.println("");
    }

    // Check that the keyword isn't empty
    else if (args[2].equals("")) {
      pen.println(args[1]);
    }

    // If arg[0] is equal to encode, encode arg[1]
    else if (args[0].equals("encode")) {
      edVigenereCipher("encode", args[1], args[2]);
    }

    // If arg[0] is equal to decode, decode arg[1]
    else if (args[0].equals("decode")) {
      edVigenereCipher("decode", args[1], args[2]);
    }

    // Check that the user has entered the correct type of parameters
    else if (!args[1].equals("encode") || !args[1].equals("decode")) {
      pen.println("Valid options are \"encode\" or \"decode\"");
    }

  } // main(String[])

  /** Helper to make the keyword equal to the length of the plaintext */
  public static String keylengthener(String plaintext, String keyword) {
    int x = plaintext.length();

    for (int i = 0; i < plaintext.length(); i++) {
      if (x == i) {
        i = 0;
      }
      if (keyword.length() == plaintext.length()) {
        break; // break if keyword & plaintext are the same length
      }
      keyword += (keyword.charAt(i));
    }
    return keyword;
  } //keylengthener(String, String)

  /** Helper to check that the plaintext doesn't pass the scope (lowercase letters) */
  public static int check(int ascii) {
    if (ascii < 'a') {
      ascii += 26;
    } else if (ascii > 'z') {
      ascii -= 26;
    }
    return ascii;
  } // check(int)

  /** Helper to encode & decode a plaintext using Vigenere Cipher */
  public static void edVigenereCipher(String cipher, String plaintext, String keyword) {
    PrintWriter pen = new PrintWriter(System.out, true);

    keyword = keylengthener(plaintext, keyword); // make sure plaintext & keyword are the same length
    
    String newText = "";
    int x;

    // Traverse through every letter in the plaintext
    for (int i = 0; i < plaintext.length(); i++) {
      if (cipher.equals("encode")) {
        x = (plaintext.charAt(i) + keyword.charAt(i)) % 26;

        // Make letters equal to the ASCII code (lowercase)
        x += 'U';

        // Call helper check
        x = check(x);

        newText += (char) (x);
      } // if user says to encode
      else { 
        x = (plaintext.charAt(i) - keyword.charAt(i)) % 26;

        // Make letters equal to the ASCII code (lowercase)
        x += 'a';

        // Call helper check
        x = check(x);

        newText += (char) (x);
      } // if user says to decode
    } // traverse through the entire given text
    pen.println(newText);
  } // edVigenereCipher (String, String, String)
} // class VigenereCipher
