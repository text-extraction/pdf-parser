package textextraction.pdfparser.operator.text;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * ET: End a text object, discarding the text matrix.
 * 
 * @author Claudius Korzen.
 */
public class EndText extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    this.parser.setTextMatrix(null);
    this.parser.setTextLineMatrix(null);
    // context.endText();
  }

  @Override
  public String getName() {
    return "ET";
  }
}
