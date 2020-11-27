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
 * cs: Sets the non-stroking color space.
 * 
 * @author Claudius Korzen
 */
public class SetNonStrokingColorSpace extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    COSName name = (COSName) args.get(0);
    PDColorSpace cs = this.parser.getResources().getColorSpace(name);
    this.parser.getGraphicsState().setNonStrokingColorSpace(cs);
    this.parser.getGraphicsState().setNonStrokingColor(cs.getInitialColor());
  }

  @Override
  public String getName() {
    return "cs";
  }
}
