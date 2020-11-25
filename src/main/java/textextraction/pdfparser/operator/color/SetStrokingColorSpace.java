package textextraction.pdfparser.operator.color;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * CS: Set color space for stroking operations.
 *
 * @author Claudius Korzen
 */
public class SetStrokingColorSpace extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    COSName name = (COSName) args.get(0);
    PDColorSpace cs = this.parser.getResources().getColorSpace(name);
    this.parser.getGraphicsState().setStrokingColorSpace(cs);
    this.parser.getGraphicsState().setStrokingColor(cs.getInitialColor());
  }

  @Override
  public String getName() {
    return "CS";
  }
}
