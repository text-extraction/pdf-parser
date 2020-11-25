package textextraction.pdfparser.model;

import java.util.Arrays;
import textextraction.common.models.Color;

/**
 * A color in a PDF document.
 */
public class PdfColor extends Color {
  @Override
  public String toString() {
    return "PdfColor(" + Arrays.toString(this.rgb) + ")";
  }
}
