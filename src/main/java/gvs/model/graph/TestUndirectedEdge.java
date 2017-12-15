package gvs.model.graph;

import gvs.business.graph.GVSDefaultVertex;
import gvs.business.graph.GVSUndirectedEdge;
import gvs.business.styles.GVSStyle;

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

  public TestUndirectedEdge(GVSDefaultVertex from, GVSDefaultVertex to,
      String label) {
    this(label);
    this.vertices = new GVSDefaultVertex[2];
    setFromVertex(from);
    setToVertex(to);
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

  public void setArrow(int arrowPosition) {
    if (arrowPosition == 1 || arrowPosition == 2) {
      this.arrowPosition = arrowPosition;
    }
  }

  public void setStyle(GVSStyle style) {
    this.style = style;
  }

}
