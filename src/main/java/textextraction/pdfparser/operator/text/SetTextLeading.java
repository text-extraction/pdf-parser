package textextraction.pdfparser.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * TL: Set the text leading to leading, which shall be a number expressed in unscaled text space
 * units.
 * 
 * @author Claudius Korzen
 */
public class SetTextLeading extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    if (args.isEmpty()) {
      throw new MissingOperandException(op, args);
    }

    COSNumber leading = (COSNumber) args.get(0);
    PDTextState textState = this.parser.getGraphicsState().getTextState();
    textState.setLeading(leading.floatValue());
  }

  @Override
  public String getName() {
    return "TL";
  }
}
