package textextraction.pdfparser.operator.graphic;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * B: Fill and then stroke the path, using the nonzero winding number rule to determine the region
 * to fill.
 * 
 * @author Claudius Korzen
 */
public class FillNonZeroAndStrokePath extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    GeneralPath path = (GeneralPath) this.parser.getLinePath().clone();

    this.parser.processOperator(pdf, page, "f", args);
    this.parser.setLinePath(path);
    this.parser.processOperator(pdf, page, "S", args);
  }

  @Override
  public String getName() {
    return "B";
  }
}
