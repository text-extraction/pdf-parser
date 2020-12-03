package textextraction.pdfparser;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import textextraction.common.models.Character;
import textextraction.common.models.Color;
import textextraction.common.models.Document;
import textextraction.common.models.Font;
import textextraction.common.models.Position;
import textextraction.pdfparser.exception.PdfParserException;

public class TestPdfParserKi2018 {
  /**
   * The PDF document to examine in this test.
   */
  protected static Document pdf;

  /**
   * Parses the PDF document.
   */
  @BeforeClass
  public static void setup() throws PdfParserException {
    pdf = new PdfParser().parse("src/test/resources/KI_2018.pdf");
  }

  /**
   * Tests the extraction results on the level of characters.
   */
  @Test
  public void testCharactersExtraction() {
    Character character = pdf.getFirstPage().getCharacters().get(101);
    assertEquals("A", character.getText());
    Position pos = character.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(51.0236,672.6245,62.5756,683.6645))", pos.toString());
    Font font = character.getFontFace().getFont();
    assertEquals("Font(cpdgqbstix-bold, bold: true, italic: false)", font.toString());
    float fontsize = character.getFontFace().getFontSize();
    assertEquals("16.0", String.format("%.1f", fontsize));
    Color color = character.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());

    character = pdf.getFirstPage().getCharacters().get(161);
    assertEquals("a", character.getText());
    pos = character.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(51.0236,654.4005,59.0236,662.1925))", pos.toString());
    font = character.getFontFace().getFont();
    assertEquals("Font(cpdgqbstix-bold, bold: true, italic: false)", font.toString());
    fontsize = character.getFontFace().getFontSize();
    assertEquals("16.0", String.format("%.1f", fontsize));
    color = character.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());

    character = pdf.getFirstPage().getCharacters().get(260);
    assertEquals("t", character.getText());
    pos = character.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(198.48247,540.2812,200.85397,545.2877))", pos.toString());
    font = character.getFontFace().getFont();
    assertEquals("Font(gyqmjgstix-regular, bold: false, italic: false)", font.toString());
    fontsize = character.getFontFace().getFontSize();
    assertEquals("8.5", String.format("%.1f", fontsize));
    color = character.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());
  }
}
