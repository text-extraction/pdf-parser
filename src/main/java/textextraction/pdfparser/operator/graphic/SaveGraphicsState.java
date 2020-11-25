package textextraction.pdfparser.operator.graphic;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * q: Save the current graphics state on the graphics state stack.
 * 
 * @author Claudius Korzen
 */
public class SaveGraphicsState extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    this.parser.saveGraphicsState();
  }

  @Override
  public String getName() {
    return "q";
  }
}
