package miniProject3;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock line1 = new TextLine("Hello World!");
    TextBlock line2 = new TextLine("Goodbye World");

    TextBlock block1 = new BoxedBlock(line1);
    TextBlock block2 = new BoxedBlock(line2);
    TextBlock block3 = new HComposition(block1, block2);
    TextBlock block4 = new HComposition(block1, block2);
    TextBlock block5 = new VComposition(block1, block2);

    // Print out the block
    TBUtils.print(pen, line1);
    TBUtils.print(pen, line2);

    TBUtils.print(pen, block1);
    TBUtils.print(pen, block2);
    TBUtils.print(pen, block3);
    TBUtils.print(pen, block4);
    TBUtils.print(pen, block5);

    TBUtils.print(pen, new Truncated(line1, 5));
    TBUtils.print(pen, new Centered(line1, 20));
    TBUtils.print(pen, new RightJustified(line1, 20));

    TBUtils.print(pen, new Truncated(block1, 5));
    TBUtils.print(pen, new Centered(block1, 20));
    TBUtils.print(pen, new RightJustified(block1, 20));

    TBUtils.print(pen, new HorizontallyFlipped(line1));
    TBUtils.print(pen, new HorizontallyFlipped(block3));
    TBUtils.print(pen, new VerticallyFlipped(line1));
    TBUtils.print(pen, new VerticallyFlipped(block5));

    pen.println(TBUtils.equal(block1, block1));
    pen.println(TBUtils.equal(block3, block4));

    pen.println(TBUtils.eqv(block1, block2));
    pen.println(TBUtils.eqv(block1, block3));

    pen.println(TBUtils.eq(block1, block1));
    pen.println(TBUtils.eq(block1, block2));

    // Clean up after ourselves.
    pen.close();

  } // main(String[])

} // class TBExpt