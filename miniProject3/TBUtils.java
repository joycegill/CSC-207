package miniProject3;

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as
   * the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program
   * operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    }
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } // try
      catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /** 
   * Returns true if the textblocks contain the same line
   */
  public static Boolean equal(TextBlock block1, TextBlock block2) throws Exception {
    // Check that both textblocks are the same height
    if (block1.height() != block2.height()) {
      return false;
    }
    // Check that the textblocks contain the same contents
    for (int idx = 0; idx < block1.height(); idx++) {
      if (!block1.row(idx).equals(block2.row(idx))) {
        return false;
      }
    }

    // Otherwise, they are equal
    return true;
  } // equal(TextBlock, TextBlock)

  /** 
   * Returns true if the textblocks were built in the same way
   */ 
  public static Boolean eqv(TextBlock block1, TextBlock block2) {
    return block1.getClass().equals(block2.getClass());
  } // eqv(TextBlock, TextBlock)

  /**
   * Returns true when the textblocks have the same memory location
   */
  public static Boolean eq(TextBlock block1, TextBlock block2) {
    return (block1 == block2);
  } // eq(TextBlock, TextBlock)

} // class TBUtils