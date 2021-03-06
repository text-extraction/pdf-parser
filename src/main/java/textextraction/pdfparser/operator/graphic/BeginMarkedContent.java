package textextraction.pdfparser.operator.graphic;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * BMC: begin marked content.
 * 
 * @author Claudius Korzen
 */
public class BeginMarkedContent extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    // context.beginMarkedContent();
  }

  @Override
  public String getName() {
    return "BMC";
  }
}
