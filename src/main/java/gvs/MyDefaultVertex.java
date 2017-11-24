package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.styles.GVSStyle;

public class MyDefaultVertex implements GVSDefaultVertex {

  String label;
  GVSStyle style;
  boolean isExplored;

  public MyDefaultVertex(String pLabel, GVSStyle style) {
    this.label = pLabel;
    this.style = style;
    this.isExplored = false;
  }

  public String getGVSVertexLabel() {
    return label;
  }

  public void setLabel(String pLabel) {
    this.label = pLabel;
  }

  public boolean isExplored() {
    return isExplored;
  }

  public void setExplored(boolean isExplored) {
    this.isExplored = isExplored;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }
  
  public void setStyle(GVSStyle style) {
    this.style = style;
  }
}
