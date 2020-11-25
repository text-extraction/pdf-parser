package textextraction.pdfparser.operator.color;

import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;

/**
 * SC: Sets the color to use for stroking stroking operations.
 *
 * @author Claudius Korzen
 */
public class SetStrokingColor extends SetColor {
  @Override
  protected void setColor(PDColor color) {
    this.parser.getGraphicsState().setStrokingColor(color);
  }

  @Override
  protected PDColorSpace getColorSpace() {
    return this.parser.getGraphicsState().getStrokingColorSpace();
  }

  @Override
  public String getName() {
    return "SC";
  }
}
