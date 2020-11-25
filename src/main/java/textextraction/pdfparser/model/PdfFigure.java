package textextraction.pdfparser.model;

import textextraction.common.models.Figure;

/**
 * A figure in a PDF document.
 */
public class PdfFigure extends Figure {
  @Override
  public String toString() {
    return "PdfFigure(pos: " + getPosition() + ")";
  }
}
