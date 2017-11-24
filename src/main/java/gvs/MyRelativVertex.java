package gvs;

import gvs.graph.GVSRelativeVertex;
import gvs.styles.GVSStyle;

/*
 * Created on 25.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyRelativVertex implements GVSRelativeVertex {

  private double xPos;
  private double yPos;
  private String label;
  private GVSStyle style;

  public MyRelativVertex(String pLabel, GVSStyle style, double pXpos,
      double pYpos) {
    this.label = pLabel;
    this.style = style;
    this.xPos = pXpos;
    this.yPos = pYpos;
  }

  public double getX() {
    return xPos;
  }

  public double getY() {
    return yPos;
  }

  public String getGVSVertexLabel() {
    return label;
  }

  public GVSStyle getStyle() {
    return style;
  }

  public void setStyle(GVSStyle style) {
    this.style = style;
  }
}
