package miniProject3;

/**
 * Given a text block and a width, builds a new block that left-justifies the input block within that width.
 * 
 * @author Joyce Gill
 */

public class LeftJustified implements TextBlock {
  // +--------+---------------------------------------------------------
  // | Fields |
  // +--------+---------------------------------------------------------

  /** The contents in the block */
  TextBlock block;

  /** The width of the block */
  int max;

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+---------------------------------------------------

  /** Build a new line with block  */
  public LeftJustified(TextBlock _block, int _max) {
    this.max = _max;
    this.block = _block;
  } // LeftJustified (TextBlock, int)

  // +---------+--------------------------------------------------------
  // | Methods |
  // +---------+--------------------------------------------------------

  /**
  * Get one row from the block.
  * 
  * @pre 0 <= 1 < this.height()
  * @exception Exception if the precondition is not met
  */
  public String row(int i) throws Exception {
    if (i < 0 || i >= this.block.height()) { // Check that i is in the valid range
      throw new Exception("Error: Invalid row");
    }

    if (this.block.width() > this.max) { // If this.max's width is greater than the block's width
      return this.block.row(i);
    } else { 
      int pad = this.max - this.block.width(); // Pad the row to left-justify the string
      return this.block.row(i) + TBUtils.spaces(pad);
    }
  } // row(int)

  /** Determine how many rows are in the block. */
  public int width() {
    return this.block.width();
  } // width()

  /** Determine how many columns are in the block. */
  public int height() {
    return this.block.height();
  } // height()
} // class LeftJustified
