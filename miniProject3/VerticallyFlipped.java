package miniProject3;

/**
 * Rearranges the text blocks vertically
 * 
 * @author Joyce Gill
 */

public class VerticallyFlipped implements TextBlock {
  // +--------+----------------------------------------------------
  // | Fields |
  // +--------+----------------------------------------------------

  /** The contents in the block */
  TextBlock block;

  // +--------------+----------------------------------------------
  // | Constructors |
  // +--------------+----------------------------------------------

  /** Build a new line with contents _contents */
  public VerticallyFlipped(TextBlock _block) {
    this.block = _block;
  } // VerticallyFlipped(TextBlock)

  // +---------+---------------------------------------------------
  // | Methods |
  // +---------+---------------------------------------------------

  /**
  * Get one row from the block.
  * 
  * @pre 0 <= i < this.height()
  * @exception Exception if the precondition is not met
  */
  public String row(int i) throws Exception {
    if (i < 0 || i > this.block.height()) { // Check that i is in the valid range
      throw new Exception("Error: Invalid row");
    }
    else{
      return this.block.row(this.block.height() - 1 - i); // Return string flipped vertically
    }
  } // row(int)

  /** Determine how many columns are in the block. */
  public int width() {
    return this.block.width();
  } // width()

  /** Determine how many rows are in the block. */
  public int height() {
    return this.block.height();
  } // height()
} // class VerticallyFlipped
