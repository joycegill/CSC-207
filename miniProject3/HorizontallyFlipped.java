package miniProject3;

/**
 * Rearranges the text blocks horizontally
 * 
 * @author Joyce Gill
 */

public class HorizontallyFlipped implements TextBlock {
    // +--------+----------------------------------------------------
    // | Fields |
    // +--------+----------------------------------------------------

    /** The contents in the block */
    TextBlock block;

    // +--------------+----------------------------------------------
    // | Constructors |
    // +--------------+----------------------------------------------

    /** Build a new line with contents _contents */
    public HorizontallyFlipped(TextBlock _block) {
      this.block = _block;
    } // HorizontallyFlipped(TextBlock)

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
        StringBuilder str = new StringBuilder(this.block.row(i));
        return str.reverse().toString(); // Return string flipped horizontally
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
} // class HorizontallyFlipped
