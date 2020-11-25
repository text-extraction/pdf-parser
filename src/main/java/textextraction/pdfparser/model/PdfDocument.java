package textextraction.pdfparser.model;

import java.io.File;
import java.nio.file.Path;
import textextraction.common.models.Document;

/**
 * A single PDF document.
 */
public class PdfDocument extends Document {
  /**
   * Creates a new PDF document.
   * 
   * @param path The path to the PDF file.
   */
  public PdfDocument(String path) {
    super(path);
  }

  /**
   * Creates a new PDF document.
   * 
   * @param file The path to the PDF file.
   */
  public PdfDocument(File file) {
    super(file);
  }

  /**
   * Creates a new PDF document.
   * 
   * @param path The path to the PDF file.
   */
  public PdfDocument(Path path) {
    super(path);
  }

  // ==============================================================================================

  @Override
  public String toString() {
    return "PdfDocument(" + this.path + ")";
  }
}
