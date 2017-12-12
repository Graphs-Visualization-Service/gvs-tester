/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Dec  5 22:00:14 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung12;

import gvs.business.graph.GVSRelativeVertex;
import gvs.business.styles.GVSStyle;

public class Vertex implements Comparable<Vertex>, GVSRelativeVertex {

  private String label;
  private GVSStyle style;
  private double xPos;
  private double yPos;

  /**
   * The vertex-constructor.
   * 
   * @param label
   *          The label to be shown on the vertex. 'null' for an empty string.
   * @param style
   *          Defines the 'design' of the vertex (color, etc.). 'null' for
   *          defaults.
   * @param xPos
   *          The X-position of the vertex (0.0 .. 100.0)
   * @param yPos
   *          The Y-position of the vertex (0.0 .. 100.0)
   */
  public Vertex(String label, GVSStyle style, double xPos, double yPos) {
    this.label = label;
    this.style = style;
    this.xPos = xPos;
    this.yPos = yPos;
  }

  @Override
  public String getGVSVertexLabel() {
    return label;
  }

  public GVSStyle setGVSStyle(GVSStyle style) {
    GVSStyle old = style;
    this.style = style;
    return old;
  }

  @Override
  public double getX() {
    return xPos;
  }

  @Override
  public double getY() {
    return yPos;
  }

  @Override
  public int compareTo(Vertex other) {
    if (label == other.label) {
      return 0;
    } else if (label == null) {
      return +1;
    } else if (other.label == null) {
      return -1;
    } else {
      return label.compareTo(other.label);
    }
  }

  @Override
  public String toString() {
    return label;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }

}
