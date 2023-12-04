package MiniProject1;

import java.io.*;

/**
 * Allows users to encode and decode text through the Caesar Cipher. 
 * 
 * @author Joyce Gill
 */
public class CaesarCipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Check that the user has entered the correct number of parameters
    if (args.length != 2) {
      pen.println("Incorrect number of parameters");
    } // if

    // If arg[0] is equal to encode, encode arg[1]
    else if (args[0].equals("encode")) {
      edCaesarCipher(args[1], "encode");
    } // else if

    // If arg[0] is equal to decode, decode arg[1]
    else if (args[0].equals("decode")) {
      edCaesarCipher(args[1], "decode");
    } // else if

    // Check that the user has entered the correct type of parameters
    else if (!args[1].equals("encode") || !args[1].equals("decode")) {
      pen.println("Valid options are \"encode\" or \"decode\"");
    } // else
  } // main(String[])

  /**
   * Helper to check that the plaintext doesn't pass the scope (lowercase letters)
   * 
   * @param ascii The ASCII value of a character
   * @return The corrected ASCII value within the scope of lowercase 'a' ~ 'z'
   */
  public static char check(char ascii) {
    // If the char is beyond the scope of lowercase 'a' ~ 'z'
    if (ascii < 'a') {
      ascii += 26;
    } else if (ascii > 'z') {
      ascii -= 26;
    } // if/else if
    return ascii;
  } // check(char)

  /** 
   * Helper to encode/decode a plaintext using Caesar Cipher 
   * 
   * @param plaintext The text to be encoded or decoded
   * @param cipher The operation to perform - "encode" or "decode"
  */
  public static void edCaesarCipher(String plaintext, String cipher) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String newText;
    char ch;
    char[] result = new char[plaintext.length()];

    // Encrypt using every letter of the alphabet
    for (int i = 0; i <= 25; i++) {
      for (int j = 0; j < plaintext.length(); j++) {
        if (cipher.equals("encode")) {
          ch = (char) (((int) plaintext.charAt(j) + i - 'a') % 26 + 'a');
        } // if the user says to encode
        else {
          ch = (char) (((int) plaintext.charAt(j) - i - 'a') % 26 + 'a');
        } // if the user says to decode

        // Call helper check
        ch = check(ch);

        result[j] = ch;
      } // for loop through the given plaintext
      // Conver result to string & print
      newText = new String(result);
      pen.printf("n = %d: %s", i, newText);
      pen.println();
    } // for loop through every letter of the alphabet
  } // edCaesarCipher(String, String)

} // class CaesarCipher
