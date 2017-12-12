package gvs.model.graph;

import gvs.business.graph.GVSDefaultVertex;
import gvs.business.styles.GVSStyle;

public class TestDefaultVertex implements GVSDefaultVertex {
  private String label;
  private GVSStyle style;
  
  public TestDefaultVertex(String label) {
   this.label = label;
  }
  
  public TestDefaultVertex(String label, GVSStyle style) {
    this.label = label;
    this.style = style;
   }
  
  @Override
  public String getGVSVertexLabel() {
    return label;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }
  
  public void setStyle(GVSStyle style) {
    this.style = style;
  }

}
