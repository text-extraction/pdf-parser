package textextraction.pdfparser.model;

import textextraction.common.models.Page;

/**
 * A single page in a PDF document.
 */
public class PdfPage extends Page {
  /**
   * Creates a new PDF page.
   */
  public PdfPage() {
    super();
  }

  /**
   * Creates a new PDF page.
   * 
   * @param pageNum The page number of this page in the PDF document.
   */
  public PdfPage(int pageNum) {
    super(pageNum);
  }

  // ==============================================================================================

  @Override
  public String toString() {
    return "PdfPage(" + this.pageNumber + ")";
  }
}
