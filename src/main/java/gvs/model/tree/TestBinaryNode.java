package gvs.model.tree;

import gvs.styles.GVSStyle;
import gvs.tree.GVSBinaryTreeNode;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((label == null) ? 0 : label.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TestBinaryNode other = (TestBinaryNode) obj;
    if (label == null) {
      if (other.label != null)
        return false;
    } else if (!label.equals(other.label))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return label;
  }

}
