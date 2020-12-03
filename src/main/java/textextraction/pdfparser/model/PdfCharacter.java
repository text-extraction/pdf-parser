package textextraction.pdfparser.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import textextraction.common.models.Character;

/**
 * A character in a PDF document.
 */
public class PdfCharacter extends Character {
  /**
   * The rank of this character in the extraction order of elements.
   */
  protected int extractionRank;

  // ==============================================================================================

  /**
   * Returns the rank of this character in the extraction order of document elements.
   * 
   * @return The rank of this character in the extraction order of document elements.
   */
  public int getExtractionRank() {
    return this.extractionRank;
  }

  /**
   * Sets the rank of this character in the extraction order of document elements.
   * 
   * @param rank The rank of this character in the extraction order of document elements.
   */
  public void setExtractionRank(int rank) {
    this.extractionRank = rank;
  }

  // ==============================================================================================

  @Override
  public boolean equals(Object other) {
    if (other instanceof PdfCharacter) {
      PdfCharacter otherCharacter = (PdfCharacter) other;

      EqualsBuilder builder = new EqualsBuilder();
      builder.append(getText(), otherCharacter.getText());
      builder.append(getPosition(), otherCharacter.getPosition());
      builder.append(getFontFace(), otherCharacter.getFontFace());
      builder.append(getColor(), otherCharacter.getColor());
      builder.append(getExtractionRank(), otherCharacter.getExtractionRank());

      return builder.isEquals();
    }
    return false;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    builder.append(getText());
    builder.append(getPosition());
    builder.append(getFontFace());
    builder.append(getColor());
    builder.append(getExtractionRank());
    return builder.hashCode();
  }
}
