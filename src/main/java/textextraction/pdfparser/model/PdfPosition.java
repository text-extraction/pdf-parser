package textextraction.pdfparser.model;

import textextraction.common.models.Point;
import textextraction.common.models.Position;
import textextraction.common.models.Rectangle;

/**
 * A position in a PDF document.
 */
public class PdfPosition extends Position {
  /**
   * Creates a new PDF position.
   * 
   * @param page The page of the position.
   * @param rect The position in the page represented by a rectangle.
   */
  public PdfPosition(PdfPage page, Rectangle rect) {
    super(page, rect);
  }

  /**
   * Creates a new PDF position.
   * 
   * @param page The page of the position.
   * @param minX The minimum x-coordinate of the rectangle representing the position in the page.
   * @param minY The minimum y-coordinate of the rectangle representing the position in the page.
   * @param maxX The maximum x-coordinate of the rectangle representing the position in the page.
   * @param maxY The maximum y-coordinate of the rectangle representing the position in the page.
   */
  public PdfPosition(PdfPage page, float minX, float minY, float maxX, float maxY) {
    super(page, minX, minY, maxX, maxY);
  }

  /**
   * Creates a new PDF position.
   * 
   * @param page   The page of the position.
   * @param point1 The lower left point of the rectangle representing the position in the page.
   * @param point2 The upper right point of the rectangle representing the position in the page.
   */
  public PdfPosition(PdfPage page, Point point1, Point point2) {
    super(page, point1, point2);
  }
}
