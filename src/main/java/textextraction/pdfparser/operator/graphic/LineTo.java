package textextraction.pdfparser.operator.graphic;

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
 * l: Append straight line segment to path.
 * 
 * @author Claudius Korzen
 */
public class LineTo extends OperatorProcessor {

  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    // Append a straight line segment from the current point to the point.
    COSNumber x = (COSNumber) args.get(0);
    COSNumber y = (COSNumber) args.get(1);
    Point point = new Point(x.floatValue(), y.floatValue());
    this.parser.transform(point);

    this.parser.getLinePath().lineTo(point.getX(), point.getY());
  }

  @Override
  public String getName() {
    return "l";
  }
}
