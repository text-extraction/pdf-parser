package textextraction.pdfparser.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * ': Move to the next line and show a text string. This operator shall have the same effect as the
 * code T* string T
 * 
 * @author Claudius Korzen
 */
public class MoveToNextLineAndShowText extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    this.parser.processOperator(pdf, page, "T*", null);
    this.parser.processOperator(pdf, page, "Tj", args);
  }

  @Override
  public String getName() {
    return "'";
  }
}
