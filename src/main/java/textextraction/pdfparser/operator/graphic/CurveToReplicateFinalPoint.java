package textextraction.pdfparser.operator.graphic;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;
import textextraction.common.models.Point;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * y: Append curved segment to path with final point replicated.
 *
 * @author Claudius Korzen
 */
public class CurveToReplicateFinalPoint extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    COSNumber x1 = (COSNumber) args.get(0);
    COSNumber y1 = (COSNumber) args.get(1);
    Point p1 = new Point(x1.floatValue(), y1.floatValue());
    this.parser.transform(p1);

    COSNumber x3 = (COSNumber) args.get(2);
    COSNumber y3 = (COSNumber) args.get(3);
    Point p3 = new Point(x3.floatValue(), y3.floatValue());
    this.parser.transform(p3);

    GeneralPath path = this.parser.getLinePath();
    path.curveTo(p1.getX(), p1.getY(), p3.getX(), p3.getY(), p3.getX(), p3.getY());
  }

  @Override
  public String getName() {
    return "y";
  }
}
