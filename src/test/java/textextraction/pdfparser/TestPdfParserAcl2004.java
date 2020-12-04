package textextraction.pdfparser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import textextraction.common.models.Character;
import textextraction.common.models.Color;
import textextraction.common.models.Document;
import textextraction.common.models.Figure;
import textextraction.common.models.Font;
import textextraction.common.models.Position;
import textextraction.common.models.Shape;
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

  /**
   * Tests the extraction results on the level of figures.
   */
  @Test
  public void testFiguresExtraction() {
    List<Figure> figures = pdf.getPages().get(0).getFigures();
    assertEquals(0, figures.size());

    figures = pdf.getPages().get(1).getFigures();
    assertEquals(0, figures.size());

    figures = pdf.getPages().get(2).getFigures();
    assertEquals(0, figures.size());
  }

  /**
   * Tests the extraction results on the level of shapes.
   */
  @Test
  public void testShapesExtraction() {
    List<Shape> shapes = pdf.getPages().get(0).getShapes();
    assertEquals(0, shapes.size());

    shapes = pdf.getPages().get(1).getShapes();
    assertEquals(805, shapes.size());

    Shape shape = shapes.get(0);
    Position pos = shape.getPosition();
    assertEquals("Pos(p: 2, bb: Rect(128.748,482.74802,140.868,482.268))", pos.toString());

    shape = shapes.get(7);
    pos = shape.getPosition();
    assertEquals("Pos(p: 2, bb: Rect(496.815,611.55,496.815,717.175))", pos.toString());

    shapes = pdf.getPages().get(2).getShapes();
    assertEquals(437, shapes.size());

    shape = shapes.get(10);
    pos = shape.getPosition();
    assertEquals("Pos(p: 3, bb: Rect(174.065,611.525,174.065,612.875))", pos.toString());
  }
}
