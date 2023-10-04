package miniProject3;

import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.Test;

/**
 * Tests each of the procedures we implemented
 * 
 * @author Joyce Gill
 */

public class TestBlockTests {

  /** Create objects */
  TextBlock empty = new TextLine("");
  TextBlock line = new TextLine("Hello World!");
  TextBlock block = new BoxedBlock(line);

  /** Test Truncated */
  @Test
  public void testTruncate(){
    try {
      /** Create objects */
      TextBlock test1 = new Truncated(empty, 5);
      TextBlock test2 = new Truncated(block, 20);

      /** Test successful cases */
      assert(TBUtils.equal(empty, test1));
      assert(TBUtils.equal(block, test2));

      /** Test failed cases */
      assertFalse(TBUtils.equal(line, test1));
      assertFalse(TBUtils.equal(line, test2));

    } catch (Exception e) {
       assert (false) : "Error in testTruncate()";
    } // try catch
  } // testTruncate()

} // class TextBlockTests
