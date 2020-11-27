package textextraction.pdfparser.operator;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

import textextraction.pdfparser.PdfParser;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;

/**
 * A class to process a specific operator in a content stream of a PDF file.
 * 
 * @author Claudius Korzen
 */
public abstract class OperatorProcessor {
  /**
   * The PDF parser.
   */
  protected PdfParser parser;

  // ==============================================================================================

  /**
   * Sets the PDF parser, so that this operator processor can access e.g., the current resources
   * stack.
   * 
   * @param parser The PDF parser.
   */
  public void setPdfParser(PdfParser parser) {
    this.parser = parser;
  }

  // ==============================================================================================

  /**
   * Processes the given operator.
   * 
   * @param pdf  The PDF document to which the given operator belongs to.
   * @param page The PDF page to which the given operator belongs to.
   * @param op   The operator to process
   * @param args The operands to use when processing
   * @throws IOException if the operator cannot be processed
   */
  public abstract void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException;

  /**
   * Returns the name of this operator, e.g. "BI".
   * 
   * @return The name of of this operator.
   */
  public abstract String getName();
}
