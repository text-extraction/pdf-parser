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

public class TestPdfParserAcl2004 {
  /**
   * The PDF document to examine in this test.
   */
  protected static Document pdf;

  /**
   * Parses the PDF document.
   */
  @BeforeClass
  public static void setup() throws PdfParserException {
    pdf = new PdfParser().parse("src/test/resources/ACL_2004.pdf");
  }

  /**
   * Tests the extraction results on the level of characters.
   */
  @Test
  public void testCharactersExtraction() {
    Character character = pdf.getFirstPage().getCharacters().get(0);
    assertEquals("A", character.getText());
    Position pos = character.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(135.0,701.16,145.35796,709.43054))", pos.toString());
    Font font = character.getFontFace().getFont();
    assertEquals("Font(times-bold, bold: true, italic: false)", font.toString());
    float fontsize = character.getFontFace().getFontSize();
    assertEquals("14.3", String.format("%.1f", fontsize));
    Color color = character.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());

    character = pdf.getFirstPage().getCharacters().get(75);
    assertEquals("F", character.getText());
    pos = character.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(170.4,643.7999,177.70462,650.6921))", pos.toString());
    font = character.getFontFace().getFont();
    assertEquals("Font(times-bold, bold: true, italic: false)", font.toString());
    fontsize = character.getFontFace().getFontSize();
    assertEquals("12.0", String.format("%.1f", fontsize));
    color = character.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());

    character = pdf.getFirstPage().getCharacters().get(281);
    assertEquals("W", character.getText());
    pos = character.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(91.92001,499.80008,101.324745,505.35922))", pos.toString());
    font = character.getFontFace().getFont();
    assertEquals("Font(times-roman, bold: false, italic: false)", font.toString());
    fontsize = character.getFontFace().getFontSize();
    assertEquals("10.0", String.format("%.1f", fontsize));
    color = character.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());
  }
}
