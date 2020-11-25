package textextraction.pdfparser.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;

/**
 * Tr: Set the text rendering mode to render, which shall be an integer.
 * 
 * @author Claudius Korzen
 */
public class SetTextRenderingMode extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    if (args.isEmpty()) {
      throw new MissingOperandException(op, args);
    }

    COSNumber mode = (COSNumber) args.get(0);
    RenderingMode renderingMode = RenderingMode.fromInt(mode.intValue());
    PDTextState textState = this.parser.getGraphicsState().getTextState();
    textState.setRenderingMode(renderingMode);
  }

  @Override
  public String getName() {
    return "Tr";
  }
}
