package textextraction.pdfparser.operator.text;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.util.Matrix;

import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

public class BeginText extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    this.parser.setTextMatrix(new Matrix());
    this.parser.setTextLineMatrix(new Matrix());
    // context.beginText();
  }

  @Override
  public String getName() {
    return "BT";
  }
}
