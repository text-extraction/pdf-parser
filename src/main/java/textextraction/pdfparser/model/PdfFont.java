package textextraction.pdfparser.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import textextraction.common.models.Font;

/**
 * A font in a PDF document.
 */
public class PdfFont extends Font {
  /**
   * The boolean flag that indicates whether or not this font is a Type-3 font.
   */
  protected boolean isType3Font;

  /**
   * The base name of this font.
   */
  protected String basename;

  /**
   * The name of the font family.
   */
  protected String fontFamilyName;

  // ==============================================================================================

  /**
   * Returns the basename of this font, that is: the normalized name of this font without the
   * substring behind the "-" sign, without any digits and without any other special characters. For
   * example, if the normalized name of the font is "nimbusromno9l-medi", the base name is
   * "nimbusromnol".
   * 
   * @return The basename of this font.
   */
  public String getBaseName() {
    return this.basename;
  }

  /**
   * Sets the basename of this font.
   * 
   * @param name The basename of this font.
   */
  public void setBasename(String name) {
    this.basename = name;
  }

  // ==============================================================================================

  /**
   * Returns the name of the font family to which this fonts belongs to. For example, if the font is
   * "cmr9", this method returns "computer modern".
   * 
   * @return The name of the font family.
   */
  public String getFontFamilyName() {
    return this.fontFamilyName;
  }

  /**
   * Sets the name of the font family to which this font belongs to.
   * 
   * @param name The name of the font family.
   */
  public void setFontFamilyName(String name) {
    this.fontFamilyName = name;
  }

  // ==============================================================================================

  /**
   * Returns true, if this font is a Type-3 font.
   * 
   * @return True, if this font is a Type-3 font; false otherwise.
   */
  public boolean isType3Font() {
    return this.isType3Font;
  }

  /**
   * Sets the boolean flag that indicates whether or not this font is a Type-3 font.
   * 
   * @param isType3Font The boolean flag that indicates whether or not this font is a Type-3 font.
   */
  public void setIsType3Font(boolean isType3Font) {
    this.isType3Font = isType3Font;
  }

  // ==============================================================================================

  @Override
  public boolean equals(Object other) {
    if (other instanceof PdfFont) {
      PdfFont otherFont = (PdfFont) other;

      EqualsBuilder builder = new EqualsBuilder();
      builder.append(getName(), otherFont.getName());
      builder.append(getBaseName(), otherFont.getBaseName());
      builder.append(getFontFamilyName(), otherFont.getFontFamilyName());
      builder.append(isBold(), otherFont.isBold());
      builder.append(isItalic(), otherFont.isItalic());
      builder.append(isType3Font(), otherFont.isType3Font());

      return builder.isEquals();
    }
    return false;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    builder.append(getName());
    builder.append(getBaseName());
    builder.append(getFontFamilyName());
    builder.append(isBold());
    builder.append(isItalic());
    builder.append(isType3Font());
    return builder.hashCode();
  }
}
