package miniProject3;

import static org.junit.*;
import org.junit.*;

/**
 * Test to make sure that the procedures for TextBlock works correctly
 * 
 * @author Joyce Gill
 */

@Test
public class TextBlockTests {
  TextBlock emptyTest = new TextLine("");
  TextBlock lineTest = new TextLine("Hello World");
  TextBlock boxTest = new BoxedBlock("Hello World");

  /* Test the truncated class */
  public void truncateTest() {
    try { 
        // Create objects
        TextBlock emptyTest_ = new Truncated(emptyTest, 0); 
        TextBlock lineTest_ = new Truncated(lineTest, 5);
        TextBlock boxTest_ = new Truncated(boxTest, 5);

        // Make sure they work correctly 
        assert(TBUtils.equal(emptyTest, emptyTest_));
        assert(TBUtils.equal(lineTest, lineTest_));
        assert(TBUtils.equal(boxTest, boxTest_));

    } catch (Exception e) {
        assert(false): "Error: Truncate working incorrectly";
    } // try/catch
  } // truncateTest()

  @Test
  public void centeredTest() {
    try { 
        // Create objects
        TextBlock emptyTest_ = new Centered(emptyTest, 0); 
        TextBlock lineTest_ = new Centered(lineTest, 5);
        TextBlock boxTest_ = new Centered(boxTest, 5);

        // Make sure they work correctly 
        assert(TBUtils.equal(emptyTest, emptyTest_));
        assert(TBUtils.equal(lineTest, lineTest_));
        assert(TBUtils.equal(boxTest, boxTest_));

    } catch (Exception e) {
        assert(false): "Error: Centered working incorrectly";
    } // try/catch
  } // centeredTest()

  @Test
  public void rightJustifiedTest() {
    try { 
        // Create objects
        TextBlock emptyTest_ = new RightJustified(emptyTest, 0); 
        TextBlock lineTest_ = new RightJustified(lineTest, 5);
        TextBlock boxTest_ = new RightJustified(boxTest, 5);

        // Make sure they work correctly 
        assert(TBUtils.equal(emptyTest, emptyTest_));
        assert(TBUtils.equal(lineTest, lineTest_));
        assert(TBUtils.equal(boxTest, boxTest_));

    } catch (Exception e) {
        assert(false): "Error: RightJustified working incorrectly";
    } // try/catch
  } // rightJustified()

  @Test
  public void horizontallyFlippedTest() {
    try { 
        // Create objects
        TextBlock emptyTest_ = new HorizontallyFlipped(emptyTest); 
        TextBlock lineTest_ = new HorizontallyFlipped(lineTest);
        TextBlock boxTest_ = new HorizontallyFlipped(boxTest);

        // Make sure they work correctly 
        assert(TBUtils.equal(emptyTest, emptyTest_));
        assert(TBUtils.equal(new TextLine("dlrow olleH"), lineTest_));
        assertFalse(TBUtils.equal(lineTest, lineTest_));
        assertFalse(TBUtils.equal(boxTest, boxTest_));

    } catch (Exception e) {
        assert(false): "Error: Horizontally Flipped working incorrectly";
    } // try/catch
  } // horizontallyFlipped()

  @Test
  public void verticallyFlipped() {
    try { 
        // Create objects
        TextBlock emptyTest_ = new verticallyFlipped(emptyTest); 
        TextBlock lineTest_ = new verticallyFlipped(lineTest);
        TextBlock boxTest_ = new verticallyFlipped(boxTest);

        // Make sure they work correctly 
        assert(TBUtils.equal(emptyTest, emptyTest_));
        assert(TBUtils.equal(lineTest, lineTest_));
        assert(TBUtils.equal(boxTest, boxTest_));

    } catch (Exception e) {
        assert(false): "Error: Vertically Flipped working incorrectly";
    } // try/catch
  } // verticallyFlipped()

} // class TextBlockTests