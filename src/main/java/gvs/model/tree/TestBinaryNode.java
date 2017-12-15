package gvs.model.tree;

import gvs.business.styles.GVSStyle;
import gvs.business.tree.GVSBinaryTreeNode;

public class TestBinaryNode implements GVSBinaryTreeNode {
  String label;
  GVSStyle style;
  GVSBinaryTreeNode leftChild;
  GVSBinaryTreeNode rightChild;

  public TestBinaryNode(String label, GVSStyle style) {
    this.label = label;
    this.style = style;
  }

  public TestBinaryNode(String label) {
    this(label, null);
  }

  @Override
  public String getNodeLabel() {
    return label;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }

  @Override
  public GVSBinaryTreeNode getGVSLeftChild() {
    return leftChild;
  }

  @Override
  public GVSBinaryTreeNode getGVSRightChild() {
    return rightChild;
  }

  public void setRightChild(GVSBinaryTreeNode child) {
    this.rightChild = child;
  }

  public void setLeftChild(GVSBinaryTreeNode child) {
    this.leftChild = child;
  }

  public void setStyle(GVSStyle style) {
    this.style = style;
  }

  @Override
  public String toString() {
    return label;
  }

}
