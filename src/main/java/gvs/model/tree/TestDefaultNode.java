package gvs.model.tree;

import gvs.styles.GVSStyle;
import gvs.tree.GVSDefaultTreeNode;

public class TestDefaultNode implements GVSDefaultTreeNode {

  private String label;
  private GVSDefaultTreeNode[] children;
  private GVSStyle style;

  public TestDefaultNode(String label, GVSDefaultTreeNode[] children,
      GVSStyle style) {
    this.label = label;
    this.children = children;
    this.style = style;
  }

  @Override
  public String getNodeLabel() {
    return label;
  }

  @Override
  public GVSDefaultTreeNode[] getGVSChildNodes() {
    return children;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }

}
