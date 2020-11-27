package textextraction.pdfparser.operator.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;

import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.operator.OperatorProcessor;


/**
 * TD: Move to the start of the next line, offset from the start of the current line by (tx, ty). As
 * a side effect, this operator shall set the leading parameter in the text state. This operator
 * shall have the same effect as this code: -ty TL tx ty Td
 * 
 * @author Claudius Korzen
 */
public class MoveTextSetLeading extends OperatorProcessor {
  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    if (args.size() < 2) {
      throw new MissingOperandException(op, args);
    }

    // move text position and set leading
    COSNumber y = (COSNumber) args.get(1);

    ArrayList<COSBase> otherArgs = new ArrayList<COSBase>();
    otherArgs.add(new COSFloat(-1 * y.floatValue()));
    this.parser.processOperator(pdf, page, "TL", otherArgs);
    this.parser.processOperator(pdf, page, "Td", args);
  }

  @Override
  public String getName() {
    return "TD";
  }
}
