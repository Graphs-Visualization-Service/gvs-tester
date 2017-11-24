package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSDirectedEdge;
import gvs.styles.GVSStyle;

/*
 * Created on 17.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyDirectedEdge implements GVSDirectedEdge {

  private String label;
  GVSStyle style;
  GVSDefaultVertex start;
  GVSDefaultVertex end;

  boolean isExplored;

  public MyDirectedEdge(String pLabel, GVSStyle style, GVSDefaultVertex pStart,
      GVSDefaultVertex pEnd) {

    this.label = pLabel;
    this.style = style;
    this.start = pStart;
    this.end = pEnd;
    this.isExplored = false;
  }

  public GVSDefaultVertex getGVSStartVertex() {
    return start;
  }

  public GVSDefaultVertex getGVSEndVertex() {
    return end;
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

  public boolean isExplored() {
    return isExplored;
  }

  public void setExplored(boolean isExplored) {
    this.isExplored = isExplored;
  }
}
