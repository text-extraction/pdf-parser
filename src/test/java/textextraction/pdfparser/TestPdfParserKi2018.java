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

  /**
   * Tests the extraction results on the level of figures.
   */
  @Test
  public void testFiguresExtraction() {
    List<Figure> figures = pdf.getPages().get(0).getFigures();
    assertEquals(23, figures.size());

    Figure figure = figures.get(0);
    Position pos = figure.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(471.27173,738.1811,502.88696,769.6623))", pos.toString());

    figure = figures.get(15);
    pos = figure.getPosition();
    assertEquals("Pos(p: 1, bb: Rect(482.32263,762.32495,483.30765,763.366))", pos.toString());

    figures = pdf.getPages().get(1).getFigures();
    assertEquals(1, figures.size());

    figure = figures.get(0);
    pos = figure.getPosition();
    assertEquals("Pos(p: 2, bb: Rect(53.785667,472.5781,541.4897,960.31854))", pos.toString());

    figures = pdf.getPages().get(2).getFigures();
    assertEquals(0, figures.size());
  }

  /**
   * Tests the extraction results on the level of shapes.
   */
  @Test
  public void testShapesExtraction() {
    List<Shape> shapes = pdf.getPages().get(0).getShapes();
    assertEquals(253, shapes.size());

    shapes = pdf.getPages().get(1).getShapes();
    assertEquals(5, shapes.size());

    Shape shape = shapes.get(0);
    Position pos = shape.getPosition();
    assertEquals("Pos(p: 2, bb: Rect(51.0236,745.7852,544.2516,745.7852))", pos.toString());
    Color color = shape.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());

    shape = shapes.get(3);
    pos = shape.getPosition();
    assertEquals("Pos(p: 2, bb: Rect(544.252,733.11,51.024,733.11))", pos.toString());
    color = shape.getColor();
    assertEquals("Color([255, 255, 255])", color.toString());

    shapes = pdf.getPages().get(2).getShapes();
    assertEquals(5, shapes.size());

    shape = shapes.get(4);
    pos = shape.getPosition();
    assertEquals("Pos(p: 3, bb: Rect(306.1417,85.4299,351.2517,85.4299))", pos.toString());
    color = shape.getColor();
    assertEquals("Color([0, 0, 0])", color.toString());
  }
}
