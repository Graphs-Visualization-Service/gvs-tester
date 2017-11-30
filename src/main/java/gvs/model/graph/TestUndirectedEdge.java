package gvs.model.graph;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSUndirectedEdge;
import gvs.styles.GVSStyle;

public class TestUndirectedEdge implements GVSUndirectedEdge {
  private String label;
  private GVSStyle style;
  private GVSDefaultVertex[] vertices;
  private int arrowPosition;

  public TestUndirectedEdge(String label, GVSStyle style) {
    this.label = label;
    this.style = style;
    this.vertices = new GVSDefaultVertex[2];
  }
  
  public TestUndirectedEdge(String label) {
    this(label, null); 
  }
  
  public void setFromVertex(GVSDefaultVertex from) {
    vertices[0] = from;
  }
  
  public void setToVertex(GVSDefaultVertex to) {
    vertices[1] = to;
  }

  @Override
  public String getGVSEdgeLabel() {
    return label;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }

  @Override
  public GVSDefaultVertex[] getGVSVertizes() {
    return vertices;
  }

  @Override
  public int hasArrow() {
    return arrowPosition;
  }

}
