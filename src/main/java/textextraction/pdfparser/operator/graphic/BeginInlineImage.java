package textextraction.pdfparser.operator.graphic;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDInlineImage;
import org.apache.pdfbox.util.Matrix;
import textextraction.common.utils.MathUtils;
import textextraction.pdfparser.model.PdfColor;
import textextraction.pdfparser.model.PdfDocument;
import textextraction.pdfparser.model.PdfFigure;
import textextraction.pdfparser.model.PdfPage;
import textextraction.pdfparser.model.PdfPosition;
import textextraction.pdfparser.model.PdfShape;
import textextraction.pdfparser.operator.OperatorProcessor;
import textextraction.pdfparser.utils.ColorUtils;
import textextraction.pdfparser.utils.PdfColorManager;

/**
 * BI: Begin inline image.
 * 
 * @author Claudius Korzen
 */
public class BeginInlineImage extends OperatorProcessor {
  /**
   * The logger.
   */
  protected static Logger LOG = LogManager.getLogger(BeginInlineImage.class);

  // ==============================================================================================

  @Override
  public void process(PdfDocument pdf, PdfPage page, Operator op, List<COSBase> args)
          throws IOException {
    // Type3 streams may also contain BI operands, but we don't want to consider those.
    if (this.parser.isType3Stream()) {
      return;
    }

    COSDictionary params = op.getImageParameters();
    PDImage image = new PDInlineImage(params, op.getImageData(), this.parser.getResources());
    int width = params.getInt(COSName.W, COSName.WIDTH, -1);
    int height = params.getInt(COSName.H, COSName.HEIGHT, -1);

    // Compute the position of the image. TODO: Use engine.transform() instead.
    Matrix ctm = this.parser.getCurrentTransformationMatrix();
    
    int precision = this.parser.getFloatingPointPrecision();
    float minX = MathUtils.round(ctm.getTranslateX(), precision);
    float minY = MathUtils.round(ctm.getTranslateY(), precision);
    float maxX = MathUtils.round(ctm.getTranslateX() + width * ctm.getScaleX(), precision);
    float maxY = MathUtils.round(ctm.getTranslateY() + height * ctm.getScaleY(), precision);
    PdfPosition position = new PdfPosition(page, minX, minY, maxX, maxY);

    // Check, if the image consists of only one color. If so, consider it as a shape.
    int[] colorRgb = ColorUtils.getExclusiveColor(image.getImage());

    if (colorRgb != null) {
      PdfColor color = PdfColorManager.getOrCreatePdfColor(colorRgb);
      LOG.debug("Consider the image as shape, as it solely consists of the color " + color + ".");

      // Consider the image as a shape.
      PdfShape shape = new PdfShape();
      shape.setPosition(position);
      shape.setColor(color);

      this.parser.handlePdfShape(pdf, page, shape);
    } else {
      // Consider the image as a normal figure.
      PdfFigure figure = new PdfFigure();
      figure.setPosition(position);

      this.parser.handlePdfFigure(pdf, page, figure);
    }
  }

  @Override
  public String getName() {
    return "BI";
  }
}
