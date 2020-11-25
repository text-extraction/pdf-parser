package textextraction.pdfparser.model;

import textextraction.common.models.Shape;

/**
 * A shape in a PDF document.
 */
public class PdfShape extends Shape {
  @Override
  public String toString() {
    return "PdfShape(pos: " + getPosition() + ", color: " + getColor() + ")";
  }
}
