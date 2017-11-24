package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSUndirectedEdge;
import gvs.styles.GVSStyle;

/*
 * Created on 25.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyUndirectedEdge implements GVSUndirectedEdge {
  private String label;
  private GVSStyle style;
  private GVSDefaultVertex[] vertizes;
  private int arrowPos = 0;

  public MyUndirectedEdge(String pLabel, GVSStyle style,
      GVSDefaultVertex pVertizes[]) {
    this.label = pLabel;
    this.style = style;
    this.vertizes = pVertizes;
  }

  public MyUndirectedEdge(String pLabel, GVSStyle style,
      GVSDefaultVertex pVertizes[], int pArrowPos) {
    this.label = pLabel;
    this.style = style;
    this.vertizes = pVertizes;
    this.arrowPos = pArrowPos;
  }

  public GVSDefaultVertex[] getGVSVertizes() {
    return vertizes;
  }

  public String getGVSEdgeLabel() {
    return label;
  }

  public GVSStyle getStyle() {
    return style;
  }
  
  public void setStyle(GVSStyle style) {
    this.style = style;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public void setVertizes(GVSDefaultVertex[] vertizes) {
    this.vertizes = vertizes;
  }

  public int hasArrow() {
    return arrowPos;
  }

  public void setArrow(int pPosition) {
    this.arrowPos = pPosition;
  }

}
