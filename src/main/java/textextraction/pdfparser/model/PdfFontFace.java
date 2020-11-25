package textextraction.pdfparser.model;

import textextraction.common.models.FontFace;

/**
 * A font face (= font + font size) of piece of text in a PDF document.
 * 
 * @author Claudius Korzen
 */
public class PdfFontFace extends FontFace {
  /**
   * Creates a new font face.
   * 
   * @param font     The font of the font face.
   * @param fontSize The font size of this font face.
   */
  public PdfFontFace(PdfFont font, float fontSize) {
    super(font, fontSize);
  }

  // ==============================================================================================

  @Override
  public String toString() {
    return "PdfFontFace(" + this.font + ", " + this.fontSize + ")";
  }
}
