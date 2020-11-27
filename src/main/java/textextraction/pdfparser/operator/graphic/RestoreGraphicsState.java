package textextraction.pdfparser.operator.graphic;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * Q: Restore the graphics state by removing the most recently saved state from the stack and making
 * it the current state.
 * 
 * @author Claudius Korzen
 */
public class RestoreGraphicsState extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    if (this.parser.getGraphicsStackSize() > 1) {
      this.parser.restoreGraphicsState();
    }
    // else {
    // this shouldn't happen but it does, see PDFBOX-161
    // throw new EmptyGraphicsStackException();
    // }
  }

  @Override
  public String getName() {
    return "Q";
  }
}
