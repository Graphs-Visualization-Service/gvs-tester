package gvs.model.graph;

import gvs.graph.GVSRelativeVertex;
import gvs.styles.GVSStyle;

public class TestRelativeVertex implements GVSRelativeVertex {
  private double x;
  private double y;
  private String label;
  private GVSStyle style;

  public TestRelativeVertex(double x, double y, String label, GVSStyle style) {
    this.label = label;
    this.style = style;
    this.x = x;
    this.y = y;
  }

  public TestRelativeVertex(double x, double y, String label) {
    this(x, y, label, null);
  }

  @Override
  public String getGVSVertexLabel() {
    return label;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }

  @Override
  public double getX() {
    return x;
  }

  @Override
  public double getY() {
    return y;
  }

  public void setStyle(GVSStyle style) {
    this.style = style;
  }

}
