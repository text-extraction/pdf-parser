package textextraction.pdfparser.operator.graphic;

import java.awt.geom.Path2D;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * W*: set clipping path using even odd rule.
 * 
 * @author Claudius Korzen
 */
public class ClipEvenOddRule extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    this.parser.setClippingWindingRule(Path2D.WIND_EVEN_ODD);
  }

  @Override
  public String getName() {
    return "W*";
  }
}
