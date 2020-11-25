package textextraction.pdfparser.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.afm.CharMetric;
import org.apache.fontbox.afm.FontMetrics;

/**
 * Wrapper for {@link FontMetrics} class to get access to the included CharMetrics.
 *
 * @author Claudius Korzen
 */
public class FontMetricsWrapper {
  /**
   * The wrapped FontMetrics object.
   */
  protected FontMetrics fontMetrics;

  /**
   * The map that maps character names to their CharMetrics.
   */
  protected Map<String, CharMetric> charMetricsMap;

  /**
   * Wraps the given FontMetrics object.
   * 
   * @param fontMetrics The FontMetrics object to wrap.
   */
  public FontMetricsWrapper(FontMetrics fontMetrics) {
    this.charMetricsMap = new HashMap<String, CharMetric>();
    this.fontMetrics = fontMetrics;

    if (fontMetrics != null) {
      for (CharMetric charMetric : fontMetrics.getCharMetrics()) {
        this.charMetricsMap.put(charMetric.getName(), charMetric);
      }
    }
  }

  /**
   * Returns the wrapped FontMetrics object.
   * 
   * @return The wrapped FontMetrics object.
   */
  public FontMetrics getFontMetrics() {
    return this.fontMetrics;
  }

  /**
   * Returns the CharMetrics as map.
   * 
   * @return The CharMetrics as map.
   */
  public Map<String, CharMetric> getCharMetricsMap() {
    return this.charMetricsMap;
  }
}
