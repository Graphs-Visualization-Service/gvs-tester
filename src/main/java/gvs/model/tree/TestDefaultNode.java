package gvs.model.tree;

import gvs.styles.GVSStyle;
import gvs.tree.GVSDefaultTreeNode;

public class TestDefaultNode implements GVSDefaultTreeNode {

  private int childPointer = -1;
  private String label;
  private GVSDefaultTreeNode[] children;
  private GVSStyle style;

  public TestDefaultNode(String label, GVSDefaultTreeNode[] children,
      GVSStyle style) {
    this.label = label;
    this.children = children;
    if (children != null) {
      childPointer = children.length - 1;
    }
    this.style = style;
  }

  public TestDefaultNode(String label) {
    this(label, null, null);
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

  public void addChild(TestDefaultNode child) {
    if (children == null) {
      children = new GVSDefaultTreeNode[] { child };
      childPointer = 0;
    } else if (children[children.length - 1] != null) {
      GVSDefaultTreeNode[] old = children;
      children = new GVSDefaultTreeNode[old.length * 2];
      childPointer = old.length;
      for (int i = 0; i < childPointer; i++) {
        children[i] = old[i];
      }
      children[childPointer] = child;
    } else {
      children[++childPointer] = child;
    }
  }

}
